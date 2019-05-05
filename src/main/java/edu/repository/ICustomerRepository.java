package edu.repository;

import edu.entity.Customer;
import edu.entity.Merchant;
import edu.entity.Payment;

import java.util.Collection;
import java.util.List;

public interface ICustomerRepository {
    public Customer findById(int id);
    public void save(Customer customer);
    public boolean remove(int id);
    public boolean update(Customer customerToUpdate);
    //    public List<String> getNamesBySumPaid(double sumPaid);
    public List<Customer> findAll();
    public Collection<Payment> getPayments(int id);
    public Collection<Merchant> getMerchants(int id);
}
