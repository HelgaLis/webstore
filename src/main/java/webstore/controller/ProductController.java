package webstore.controller;



import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import webstore.service.ProductService;

@Controller
@RequestMapping("/market")
public class ProductController {
	@Autowired
	private ProductService productService;
	@RequestMapping("/products")
	public String list(Model model) {
		/*Product product = new Product("P1234","Ihpone6s",new BigDecimal(500));
		product.setCategory("Smartphone");
		product.setDescription("Very good phone");
		product.setManufacturer("Apple");
		product.setUnitsInStock(1000);*/
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}
	@RequestMapping("/update/stock")
	public String updateStock(Model model) {
		productService.updateAllStock();
		return "redirect:/products";
	}
	@RequestMapping("products/{category}")
	public String getsProductsByCategory(Model model,@PathVariable("category") String productCategory){
		model.addAttribute("products", productService.getProductsByCategory(productCategory));
		return "products";
	}
	
	@RequestMapping("products/categories")
	public String getCatecories(Model model){
		model.addAttribute("categories", productService.getAllProductCategories());
		return "categories";
	}
	@RequestMapping("/products/filter/{params}")
	public String getProductsByFilter(@MatrixVariable(pathVar="params") Map<String,List<String>> filterParams, Model model){
		model.addAttribute("products", productService.getPruductByFilter(filterParams));
		return "products";
	}
	@RequestMapping("/product")
	public String getProductById(@RequestParam("id") String productId, Model model){
		model.addAttribute("product", productService.getProductById(productId));
		return "product";
	}
	@RequestMapping("/products/{category}/{price}")
	public String filterProducts(@RequestParam("brand") String brand, @PathVariable("category") String category, 
			@MatrixVariable(pathVar="price") Map<String,String> priceParams, Model model){
		
		return "product";
	}
}
