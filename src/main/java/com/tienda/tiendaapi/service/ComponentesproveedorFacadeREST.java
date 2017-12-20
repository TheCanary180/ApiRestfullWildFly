/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.tiendaapi.service;

import com.tienda.tiendaapi.Componentesproveedor;
import com.tienda.tiendaapi.Detalledecompra;
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
@Path("com.tienda.tiendaapi.componentesproveedor")
public class ComponentesproveedorFacadeREST extends AbstractFacade<Componentesproveedor> {

    @PersistenceContext(unitName = "com.tienda_TiendaApi_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public ComponentesproveedorFacadeREST() {
        super(Componentesproveedor.class);
    }

    @POST
    @Override
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Componentesproveedor entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") Integer id, Componentesproveedor entity) {
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
    public Componentesproveedor find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public List<Componentesproveedor> findAll() {
        return super.findAll();
    }
    
    @GET
    @Path("componente/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Componentesproveedor> findComponente(@PathParam("id") Integer id) {
        TypedQuery<Componentesproveedor> query = em.createNamedQuery("Componentesproveedor.findComponente", Componentesproveedor.class);
        query.setParameter("componenteID2", id);
        List<Componentesproveedor> results = query.getResultList();
        return results;
    }
    
    @GET
    @Path("proveedor/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Componentesproveedor> findProveedor(@PathParam("id") Integer id) {
        TypedQuery<Componentesproveedor> query = em.createNamedQuery("Componentesproveedor.findProveedor", Componentesproveedor.class);
        query.setParameter("proveedorID2", id);
        List<Componentesproveedor> results = query.getResultList();
        return results;
    }

    @GET
    @Path("{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Componentesproveedor> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
