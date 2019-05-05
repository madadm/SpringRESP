package edu.repository;

import edu.entity.Customer;
import edu.entity.Merchant;
import edu.entity.Payment;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Repository
public class CustomerRepository implements ICustomerRepository {
    //@PersistenceContext
    //private EntityManager em;
    @Autowired
    SessionFactory session;

    @Transactional
    public Customer findById(int id) {
        Customer customer = null;
        customer = session.getCurrentSession().find(Customer.class, id);
        return customer;
    }

    public void save(Customer customer) {
        session.getCurrentSession().persist(customer);
        //em.persist(customer);
    }

    public boolean remove(int id) {
        Customer customer = findById(id);
        if (customer != null) {
            session.getCurrentSession().remove(customer);
            return true;
        }
        return false;
    }

    public boolean update(Customer updatedCustomer) {
        if (updatedCustomer != null) {
            return true;
        } else {
            return true;
        }
    }

    @Transactional
    public List<Customer> findAll() {

        return  (List<Customer>) session.getCurrentSession().createQuery("from customer").list();
    }
    @Transactional
    public Collection<Payment> getPayments(int id){
        Customer customer=session.getCurrentSession().find(Customer.class, id);
        return customer.getPayments();
    }
    @Transactional
    public Collection<Merchant> getMerchants(int id){
        Customer customer=session.getCurrentSession().find(Customer.class,id);
        return customer.getMerchants();
    }
}
