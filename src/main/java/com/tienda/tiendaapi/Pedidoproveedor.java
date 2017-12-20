/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.tiendaapi;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TheCanary
 */
@Entity
@Table(name = "pedidoproveedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedidoproveedor.findAll", query = "SELECT p FROM Pedidoproveedor p")
    , @NamedQuery(name = "Pedidoproveedor.findById", query = "SELECT p FROM Pedidoproveedor p WHERE p.id = :id")
    , @NamedQuery(name = "Pedidoproveedor.findByFecha", query = "SELECT p FROM Pedidoproveedor p WHERE p.fecha = :fecha")
    , @NamedQuery(name = "Pedidoproveedor.findByPrecio", query = "SELECT p FROM Pedidoproveedor p WHERE p.precio = :precio")

    , @NamedQuery(name = "Pedidoproveedor.findByEmpleado", query = "SELECT p FROM Pedidoproveedor p, Empleado e WHERE p.empleadoID = e.id and p.empleadoID =:empleadoID")
    , @NamedQuery(name = "Pedidoproveedor.findByProveedor", query = "SELECT p FROM Pedidoproveedor p, Proveedor pr WHERE p.empleadoID = pr.id and p.proveedorID =:proveedorID")
})
public class Pedidoproveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha")
    private int fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Precio")
    private int precio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedidoProveedorID")
    private Collection<Detalledecompra> detalledecompraCollection;
    @JoinColumn(name = "ProveedorID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Proveedor proveedorID;
    @JoinColumn(name = "EmpleadoID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Empleado empleadoID;

    public Pedidoproveedor() {
    }

    public Pedidoproveedor(Integer id) {
        this.id = id;
    }

    public Pedidoproveedor(Integer id, int fecha, int precio) {
        this.id = id;
        this.fecha = fecha;
        this.precio = precio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @XmlTransient
    public Collection<Detalledecompra> getDetalledecompraCollection() {
        return detalledecompraCollection;
    }

    public void setDetalledecompraCollection(Collection<Detalledecompra> detalledecompraCollection) {
        this.detalledecompraCollection = detalledecompraCollection;
    }

    public Proveedor getProveedorID() {
        return proveedorID;
    }

    public void setProveedorID(Proveedor proveedorID) {
        this.proveedorID = proveedorID;
    }

    public Empleado getEmpleadoID() {
        return empleadoID;
    }

    public void setEmpleadoID(Empleado empleadoID) {
        this.empleadoID = empleadoID;
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
        if (!(object instanceof Pedidoproveedor)) {
            return false;
        }
        Pedidoproveedor other = (Pedidoproveedor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tienda.tiendaapi.Pedidoproveedor[ id=" + id + " ]";
    }
    
}
