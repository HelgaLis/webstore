package webstore.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import webstore.domain.Customer;



@Repository
public class InMemoryCustomerRepository implements CustomerRepository {
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<Customer> getAllCustomers() {
		Map<String, Object> params = new HashMap<>();
		List<Customer> result = jdbcTemplate.query("SELECT * FROM customers", params, new CustomerMapper() );
		return result;
	}
	private final static class CustomerMapper implements RowMapper<Customer>{

		@Override
		public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
			Customer customer = new Customer();
			customer.setCustomerId(rs.getString("ID"));
			customer.setName(rs.getString("NAME"));
			customer.setNoOfOrdersMade(rs.getInt("ORDERS_COUNT"));
			customer.setAddress(rs.getString("ADDRESS"));
			return customer;
		}
		
	}

}
