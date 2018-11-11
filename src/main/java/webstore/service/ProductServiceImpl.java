package webstore.service;

import java.util.List;

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

}
