/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.tiendaapi.service;

import com.tienda.tiendaapi.Detalledecompra;
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
@Path("com.tienda.tiendaapi.detalledecompra")
public class DetalledecompraFacadeREST extends AbstractFacade<Detalledecompra> {

    @PersistenceContext(unitName = "com.tienda_TiendaApi_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public DetalledecompraFacadeREST() {
        super(Detalledecompra.class);
    }

    @POST
    @Override
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Detalledecompra entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") Integer id, Detalledecompra entity) {
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
    public Detalledecompra find(@PathParam("id") Integer id) {
        return super.find(id);
    }
    
    @GET
    @Path("componente/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Detalledecompra> findComponente(@PathParam("id") Integer id) {
        TypedQuery<Detalledecompra> query = em.createNamedQuery("Detalledecompra.findByProveedor", Detalledecompra.class);
        query.setParameter("componenteID", id);
        List<Detalledecompra> results = query.getResultList();
        return results;
    }
    
    @GET
    @Path("proveedor/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Detalledecompra> findProveedor(@PathParam("id") Integer id) {
        TypedQuery<Detalledecompra> query = em.createNamedQuery("Detalledecompra.findByComponente", Detalledecompra.class);
        query.setParameter("pedidoProveedorID", id);
        List<Detalledecompra> results = query.getResultList();
        return results;
    }

    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public List<Detalledecompra> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces( MediaType.APPLICATION_JSON)
    public List<Detalledecompra> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
