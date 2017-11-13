/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samples.rest;

import com.samples.entity.Customer;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author james
 */
@Stateless
public class CustomerFacade {

    @PersistenceContext(unitName = "AlbaAirways-ServerSidePU")
    private EntityManager em;

    public List<Customer> findAll() {
        return em.createQuery("select c from Customer c").getResultList();
    }

    public List<Customer> findByName(String surname) {
        return em.createQuery("select c from Customer c where UPPER(c.surname) LIKE :custName").
                setParameter("custName", "%" + surname.toUpperCase() + "%").getResultList();
    }

    public List<Customer> findByCustomerId(int customerId) {
        return em.createQuery("select c from Customer c where c.customerId = :custId").
                setParameter("custId", customerId).getResultList();
    }
}
