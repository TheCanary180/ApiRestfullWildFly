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
@Table(name = "detalledepedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detalledepedido.findAll", query = "SELECT d FROM Detalledepedido d")
    , @NamedQuery(name = "Detalledepedido.findById", query = "SELECT d FROM Detalledepedido d WHERE d.id = :id")
    , @NamedQuery(name = "Detalledepedido.findByCantidad", query = "SELECT d FROM Detalledepedido d WHERE d.cantidad = :cantidad")
    , @NamedQuery(name = "Detalledepedido.findByPrecio", query = "SELECT d FROM Detalledepedido d WHERE d.precio = :precio")

    , @NamedQuery(name = "Detalledepedido.findByComponente", query = "SELECT d FROM Detalledepedido d, Componente c "
            + "WHERE d.componenteID2 = c.id and d.componenteID2 = :componenteID")
    , @NamedQuery(name = "Detalledepedido.findByCliente", query = "SELECT d FROM Detalledepedido d, Pedidocliente p "
            + "WHERE d.componenteID2 = p.id and d.pedidoClienteID2 = :clienteID")
})
public class Detalledepedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Precio")
    private int precio;
    @JoinColumn(name = "ComponenteID2", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Componente componenteID2;
    @JoinColumn(name = "PedidoClienteID2", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Pedidocliente pedidoClienteID2;

    public Detalledepedido() {
    }

    public Detalledepedido(Integer id) {
        this.id = id;
    }

    public Detalledepedido(Integer id, int cantidad, int precio) {
        this.id = id;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Componente getComponenteID2() {
        return componenteID2;
    }

    public void setComponenteID2(Componente componenteID2) {
        this.componenteID2 = componenteID2;
    }

    public Pedidocliente getPedidoClienteID2() {
        return pedidoClienteID2;
    }

    public void setPedidoClienteID2(Pedidocliente pedidoClienteID2) {
        this.pedidoClienteID2 = pedidoClienteID2;
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
        if (!(object instanceof Detalledepedido)) {
            return false;
        }
        Detalledepedido other = (Detalledepedido) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tienda.tiendaapi.Detalledepedido[ id=" + id + " ]";
    }
    
}
