package webstore.controller;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import webstore.domain.Product;
import webstore.exception.NoProductFoundUnderCategoryException;
import webstore.exception.ProductNotFoundException;
import webstore.service.ProductService;

@Controller
@RequestMapping("/market")
public class ProductController {
	@Autowired
	private ProductService productService;

	@InitBinder
	public void initializeBinder(WebDataBinder binder) {
		binder.setAllowedFields("productId", "name", "unitPrice", "description", "category", "unitsInStock",
				"condition", "productImage","manufacturer","unitsInOrder","discontinued","productManual");
	}

	@RequestMapping("/products")
	public String list(Model model) {
		/*
		 * Product product = new Product("P1234","Ihpone6s",new BigDecimal(500));
		 * product.setCategory("Smartphone"); product.setDescription("Very good phone");
		 * product.setManufacturer("Apple"); product.setUnitsInStock(1000);
		 */
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}

	@RequestMapping("/update/stock")
	public String updateStock(Model model) {
		productService.updateAllStock();
		return "redirect:/products";
	}

	@RequestMapping("products/{category}")
	public String getsProductsByCategory(Model model, @PathVariable("category") String productCategory) {
		List<Product> products = productService.getProductsByCategory(productCategory);
		if(products == null || products.isEmpty()){
			throw new NoProductFoundUnderCategoryException();
		}
		model.addAttribute("products", products);
		return "products";
	}

	@RequestMapping("products/categories")
	public String getCatecories(Model model) {
		model.addAttribute("categories", productService.getAllProductCategories());
		return "categories";
	}

	@RequestMapping("/products/filter/{params}")
	public String getProductsByFilter(@MatrixVariable(pathVar = "params") Map<String, List<String>> filterParams,
			Model model) {
		model.addAttribute("products", productService.getPruductByFilter(filterParams));
		return "products";
	}

	@RequestMapping("/product")
	public String getProductById(@RequestParam("id") String productId, Model model) {
		model.addAttribute("product", productService.getProductById(productId));
		return "product";
	}

	@RequestMapping("/products/{category}/{price}")
	public String filterProducts(@RequestParam("brand") String brand, @PathVariable("category") String category,
			@MatrixVariable(pathVar = "price") Map<String, String> priceParams, Model model) {

		return "product";
	}

	@RequestMapping(value = "/products/add", method = RequestMethod.GET)
	public String adddNewProductForm(Model model) {
		Product newProduct = new Product();
		model.addAttribute("newProduct", newProduct);
		return "addProduct";
	}

	@RequestMapping(value = "/products/add", method = RequestMethod.POST)
	public String processAddNewProduct(@ModelAttribute("newProduct") Product newProduct, BindingResult result,
			HttpServletRequest request) {
		if (result.getSuppressedFields().length > 0) {
			throw new RuntimeException(StringUtils.arrayToCommaDelimitedString(result.getSuppressedFields()));
		}
		MultipartFile productImage = newProduct.getProductImage();
		MultipartFile productManual = newProduct.getProductManual();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		if (productImage != null && !productImage.isEmpty()) {
			try {
				productImage.transferTo(new File(rootDirectory + "/resources/images/" + newProduct.getProductId() + ".png"));
			} catch (Exception e) {
				throw new RuntimeException("Product Image saving failed", e);
			}
		}
		if(productManual!=null&&!productManual.isEmpty()) {
			try {
				productManual.transferTo(new File(rootDirectory + "/resources/pdfs/" + newProduct.getProductId() + ".pdf"));
			}
			catch(Exception e) {
				throw new RuntimeException("Product manual saved failed",e);
			}
		}
		productService.addProduct(newProduct);
		return "redirect:/market/products";
	}
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handleError(HttpServletRequest request, ProductNotFoundException exception){
		ModelAndView mav = new ModelAndView();
		mav.addObject("invalidProductId", exception.getProductId());
		mav.addObject("exception", exception);
		mav.addObject("url", request.getRequestURL()+"?"+request.getQueryString());
		mav.setViewName("productNotFound");
		return mav;
	}
}
