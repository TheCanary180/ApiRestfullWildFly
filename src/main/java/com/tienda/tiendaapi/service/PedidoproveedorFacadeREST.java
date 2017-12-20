/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.tiendaapi.service;

import com.tienda.tiendaapi.Detalledecompra;
import com.tienda.tiendaapi.Pedidoproveedor;
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
@Path("com.tienda.tiendaapi.pedidoproveedor")
public class PedidoproveedorFacadeREST extends AbstractFacade<Pedidoproveedor> {

    @PersistenceContext(unitName = "com.tienda_TiendaApi_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public PedidoproveedorFacadeREST() {
        super(Pedidoproveedor.class);
    }

    @POST
    @Override
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Pedidoproveedor entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") Integer id, Pedidoproveedor entity) {
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
    public Pedidoproveedor find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pedidoproveedor> findAll() {
        return super.findAll();
    }
    
    @GET
    @Path("empleado/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pedidoproveedor> findEmpleado(@PathParam("id") Integer id) {
        TypedQuery<Pedidoproveedor> query = em.createNamedQuery("Pedidoproveedor.findByEmpleado", Pedidoproveedor.class);
        query.setParameter("empleadoID", id);
        List<Pedidoproveedor> results = query.getResultList();
        return results;
    }
    
    @GET
    @Path("proveedor/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pedidoproveedor> findProveedor(@PathParam("id") Integer id) {
        TypedQuery<Pedidoproveedor> query = em.createNamedQuery("Pedidoproveedor.findByProveedor", Pedidoproveedor.class);
        query.setParameter("proveedorID", id);
        List<Pedidoproveedor> results = query.getResultList();
        return results;
    }

    @GET
    @Path("{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pedidoproveedor> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
