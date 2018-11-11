package webstore.repository;

import java.util.List;

import webstore.domain.Customer;

public interface CustomerRepository {
	public List<Customer> getAllCustomers();
}
