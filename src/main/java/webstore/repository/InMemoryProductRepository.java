package webstore.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import webstore.domain.Product;
@Repository
public class InMemoryProductRepository implements ProductRepository {
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	@Override
	public List<Product> getllProducts() {
		Map<String, Object> params = new HashMap<>();
		List<Product> result = jdbcTemplate.query("SELECT * FROM products", params, new ProductMapper() );
		return result;
	}
	private static final class ProductMapper implements RowMapper<Product>{

		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			Product product = new Product();
			product.setProductId(rs.getString("ID"));
			product.setName(rs.getString("NAME"));
			product.setDescription(rs.getString("DESCRIPTION"));
			product.setUnitPrice(rs.getBigDecimal("UNIT_PRICE"));
			product.setManufacturer(rs.getString("MANUFACTURER"));
			product.setCategory(rs.getString("CATEGORY"));
			product.setCondition(rs.getString("CONDITION"));
			product.setUnitsInStock(rs.getLong("UNITS_IN_STOCK"));
			product.setUnitsInOrder(rs.getLong("UNITS_IN_ORDER"));
			product.setDiscontinued(rs.getBoolean("DISCONTINUED"));
			return product;
		}
		
	}
	@Override
	public void updateStock(String productId, long noOfUnits) {
		String SQL = "UPDATE PRODUCTS SET UNITS_IN_STOCK=:unitsInStock WHERE ID=:id";
		Map<String, Object> params = new HashMap<>();
		params.put("unitsInStock", noOfUnits);
		params.put("id", productId);
		jdbcTemplate.update(SQL, params);
		
	}
	@Override
	public List<Product> getProductsByCategory(String category) {
		String sql = "SELECT * FROM PRODUCTS WHERE CATEGORY = :category";
		Map<String, Object> params = new HashMap<>();
		params.put("category", category);
		return jdbcTemplate.query(sql, params, new ProductMapper());
	}
	@Override
	public List<String> getAllProductCategories() {
		String sql = "SELECT DISTINCT * FROM products";
		Map<String, Object> params = new HashMap<>();
		List<Product> cats = jdbcTemplate.query(sql, params, new ProductMapper());
		return cats.stream().map(p->p.getCategory()).collect(Collectors.toList());
	}
	@Override
	public List<Product> getPruductByFilter(
			Map<String, List<String>> filterParams) {
		String sql = "SELECT * FROM Products WHERE CATEGORY in (:categories) AND MANUFACTURER IN (:brands)";
		
		return jdbcTemplate.query(sql, filterParams, new ProductMapper());
	}
	@Override
	public Product getProductById(String productId) {
		String sql = "SELECT * FROM Products WHERE ID=:id";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", productId);
		return jdbcTemplate.queryForObject(sql, params, new ProductMapper());
	}
	@Override
	public List<Product> filterProducts(Map<String, Double> priceParams,
			String category, String brand) {
		String sql = "SELECT * FROM Products WHERE CATEGORY=:category AND MANUFACTURER=:brand AND UNIT_PRICE BEETWEEN :low AND :high";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("category", category);
		params.put("brand", brand);
		params.putAll(priceParams);
		return jdbcTemplate.query(sql, params, new ProductMapper());
	}

}
