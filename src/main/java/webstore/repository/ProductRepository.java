package webstore.repository;

import java.util.List;
import java.util.Map;

import webstore.domain.Product;

public interface ProductRepository {
	List<Product> getllProducts();
	void updateStock(String productId, long nonOfUnits);
	List<Product> getProductsByCategory(String category);
	List<String> getAllProductCategories();
	List<Product> getPruductByFilter(Map<String,List<String>> filterParams);
	Product getProductById(String productId);
	List<Product> filterProducts(Map<String,Double> priceParams, String category, String brand);
}
