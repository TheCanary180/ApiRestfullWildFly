/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.tiendaapi;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TheCanary
 */
@Entity
@Table(name = "detalledecompra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detalledecompra.findAll", query = "SELECT d FROM Detalledecompra d")
    , @NamedQuery(name = "Detalledecompra.findById", query = "SELECT d FROM Detalledecompra d WHERE d.id = :id")
    , @NamedQuery(name = "Detalledecompra.findByCantidad", query = "SELECT d FROM Detalledecompra d WHERE d.cantidad = :cantidad")
    , @NamedQuery(name = "Detalledecompra.findByPrecio", query = "SELECT d FROM Detalledecompra d WHERE d.precio = :precio")

    , @NamedQuery(name = "Detalledecompra.findByComponente", query = "SELECT d FROM Detalledecompra d, Componente c "
            + "WHERE d.componenteID = c.id and d.componenteID = :componenteID")
    , @NamedQuery(name = "Detalledecompra.findByProveedor", query = "SELECT d FROM Detalledecompra d, Pedidoproveedor p "
            + "WHERE d.componenteID = p.id and d.pedidoProveedorID = :pedidoProveedorID")    
})
public class Detalledecompra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Cantidad")
    private Integer cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Precio")
    private int precio;
    @JoinColumn(name = "ComponenteID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Componente componenteID;
    @JoinColumn(name = "PedidoProveedorID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Pedidoproveedor pedidoProveedorID;

    public Detalledecompra() {
    }

    public Detalledecompra(Integer id) {
        this.id = id;
    }

    public Detalledecompra(Integer id, int precio) {
        this.id = id;
        this.precio = precio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Componente getComponenteID() {
        return componenteID;
    }

    public void setComponenteID(Componente componenteID) {
        this.componenteID = componenteID;
    }

    public Pedidoproveedor getPedidoProveedorID() {
        return pedidoProveedorID;
    }

    public void setPedidoProveedorID(Pedidoproveedor pedidoProveedorID) {
        this.pedidoProveedorID = pedidoProveedorID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detalledecompra)) {
            return false;
        }
        Detalledecompra other = (Detalledecompra) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tienda.tiendaapi.Detalledecompra[ id=" + id + " ]";
    }
    
}
