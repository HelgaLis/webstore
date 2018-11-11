package webstore.repository;

import java.util.List;

import webstore.domain.Product;

public interface ProductRepository {
	List<Product> getllProducts();
	void updateStock(String productId, long nonOfUnits);
	List<Product> getProductsByCategory(String category);
	List<String> getAllProductCategories();
}
