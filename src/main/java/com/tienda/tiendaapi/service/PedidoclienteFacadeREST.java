/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.tiendaapi.service;

import com.tienda.tiendaapi.Pedidocliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author TheCanary
 */
@Stateless
@Path("com.tienda.tiendaapi.pedidocliente")
public class PedidoclienteFacadeREST extends AbstractFacade<Pedidocliente> {

    @PersistenceContext(unitName = "com.tienda_TiendaApi_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public PedidoclienteFacadeREST() {
        super(Pedidocliente.class);
    }

    @POST
    @Override
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Pedidocliente entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") Integer id, Pedidocliente entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Pedidocliente find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pedidocliente> findAll() {
        return super.findAll();
    }
    
    @GET
    @Path("cliente/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pedidocliente> findCliente(@PathParam("id") Integer id) {
        TypedQuery<Pedidocliente> query = em.createNamedQuery("Pedidocliente.findByCliente", Pedidocliente.class);
        query.setParameter("clienteID", id);
        List<Pedidocliente> results = query.getResultList();
        return results;
    }
    
    @GET
    @Path("empleado/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pedidocliente> findEmpleado(@PathParam("id") Integer id) {
        TypedQuery<Pedidocliente> query = em.createNamedQuery("Pedidocliente.findByEmpleado", Pedidocliente.class);
        query.setParameter("empleadoID", id);
        List<Pedidocliente> results = query.getResultList();
        return results;
    }

    @GET
    @Path("{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pedidocliente> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
