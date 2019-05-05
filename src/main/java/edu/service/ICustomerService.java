package edu.service;

import edu.entity.Customer;
import edu.entity.Merchant;
import edu.entity.Payment;

import java.util.Collection;
import java.util.List;

public interface ICustomerService {
    public Customer findById(int id);

    public void save(Customer customer);

    public boolean remove(int id);

    public boolean updateCcNo(int id, String ccNo);

    //    public List<String> getNamesBySumPaid(double sumPaid);
    public List<Customer> findAll();
    public Collection<Payment> getPayments(int id);
    public Collection<Merchant> getMerchants(int id);
}