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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TheCanary
 */
@Entity
@Table(name = "componentesproveedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Componentesproveedor.findAll", query = "SELECT c FROM Componentesproveedor c")
    , @NamedQuery(name = "Componentesproveedor.findById", query = "SELECT c FROM Componentesproveedor c WHERE c.id = :id")
    , @NamedQuery(name = "Componentesproveedor.findByNombre", query = "SELECT c FROM Componentesproveedor c WHERE c.nombre = :nombre")

    , @NamedQuery(name = "Componentesproveedor.findComponente", query = "SELECT c FROM Componentesproveedor c, Componente co "
                          + "WHERE c.componenteID2 = co.id and c.componenteID2 = :componenteID2")
    , @NamedQuery(name = "Componentesproveedor.findProveedor", query = "SELECT c FROM Componentesproveedor c, Proveedor p "
                          + "WHERE c.componenteID2 = p.id and c.proveedorID2 = :proveedorID2")
})
public class Componentesproveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 20)
    @Column(name = "Nombre")
    private String nombre;
    @JoinColumn(name = "ComponenteID2", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Componente componenteID2;
    @JoinColumn(name = "ProveedorID2", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Proveedor proveedorID2;

    public Componentesproveedor() {
    }

    public Componentesproveedor(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Componente getComponenteID2() {
        return componenteID2;
    }

    public void setComponenteID2(Componente componenteID2) {
        this.componenteID2 = componenteID2;
    }

    public Proveedor getProveedorID2() {
        return proveedorID2;
    }

    public void setProveedorID2(Proveedor proveedorID2) {
        this.proveedorID2 = proveedorID2;
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
        if (!(object instanceof Componentesproveedor)) {
            return false;
        }
        Componentesproveedor other = (Componentesproveedor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tienda.tiendaapi.Componentesproveedor[ id=" + id + " ]";
    }
    
}
