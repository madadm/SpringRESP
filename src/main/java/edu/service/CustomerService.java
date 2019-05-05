package edu.service;

import edu.entity.Customer;
import edu.entity.Merchant;
import edu.entity.Payment;
import edu.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;


@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    @Transactional
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Transactional
    public boolean remove(int id) {
        return customerRepository.remove(id);
    }

    @Transactional
    public boolean updateCcNo(int id, String ccNo) {
        Customer customerToUpdate = customerRepository.findById(id);
        if (customerToUpdate != null) {
            customerToUpdate.setCcNo(ccNo);
            return customerRepository.update(customerToUpdate);
        }
        return false;
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
    public Collection<Payment> getPayments(int id) {
        return customerRepository.getPayments(id);
    }
    public Collection<Merchant> getMerchants(int id){return customerRepository.getMerchants(id);}
}

