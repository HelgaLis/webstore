package webstore.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import webstore.service.ProductService;

@Controller
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
}
