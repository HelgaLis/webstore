package webstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webstore.domain.Customer;
import webstore.repository.CustomerRepository;
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.getAllCustomers();
	}

}
