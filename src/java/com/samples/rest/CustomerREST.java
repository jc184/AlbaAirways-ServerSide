/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samples.rest;

import com.samples.entity.Customer;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author james
 */
@Path("customer")
@RequestScoped
public class CustomerREST {

    @Context
    private UriInfo context;

    @Inject
    private CustomerFacade customerFacade;

    /**
     * Creates a new instance of CustomerREST
     */
    public CustomerREST() {
    }

    /**
     * Retrieves representation of an instance of com.samples.rest.CustomerREST
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces({"application/json"})
    public List<Customer> getJson() {
        return customerFacade.findAll();
    }

    @GET
    @Path("/search/{name}")
    @Produces({"application/json"})
    public List<Customer> findByName(@PathParam("name") String name) {
        return customerFacade.findByName(name);
    }

    @GET
    @Path("/find/{id}")
    @Produces({"application/json"})
    public List<Customer> findByCustomerId(@PathParam("id") int id) {
        return customerFacade.findByCustomerId(id);
    }

    /**
     * PUT method for updating or creating an instance of CustomerREST
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
