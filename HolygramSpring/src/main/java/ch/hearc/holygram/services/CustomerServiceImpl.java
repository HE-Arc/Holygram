package ch.hearc.holygram.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.hearc.holygram.models.Customer;
import ch.hearc.holygram.repositories.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }
}