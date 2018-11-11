package webstore.service;

import java.util.List;

import webstore.domain.Product;

public interface ProductService {
	public void updateAllStock();
	public List<Product> getAllProducts();
}
