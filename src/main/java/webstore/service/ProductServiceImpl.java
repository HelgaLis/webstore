package webstore.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webstore.domain.Product;
import webstore.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductRepository productRepository;
	@Override
	public void updateAllStock() {
		List<Product> allProducts = productRepository.getllProducts();
		allProducts.stream().filter(p->p.getUnitsInStock()<500).forEach(p->productRepository.updateStock(p.getProductId(), p.getUnitsInStock()+1000));
		
	}
	@Override
	public List<Product> getAllProducts() {
		return productRepository.getllProducts();
	}
	@Override
	public List<Product> getProductsByCategory(String category) {
		return productRepository.getProductsByCategory(category);
	}
	@Override
	public List<String> getAllProductCategories() {
		return productRepository.getAllProductCategories();
	}
	@Override
	public List<Product> getPruductByFilter(
			Map<String, List<String>> filterParams) {
		// TODO Auto-generated method stub
		return  productRepository.getPruductByFilter(filterParams);
	}
	@Override
	public Product getProductById(String productId) {
		// TODO Auto-generated method stub
		return productRepository.getProductById(productId);
	}
	@Override
	public List<Product> filterProducts(Map<String, Double> priceParams,
			String category, String brand) {
		// TODO Auto-generated method stub
		return productRepository.filterProducts(priceParams, category, brand);
	}


}
