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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TheCanary
 */
@Entity
@Table(name = "componente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Componente.findAll", query = "SELECT c FROM Componente c")
    , @NamedQuery(name = "Componente.findById", query = "SELECT c FROM Componente c WHERE c.id = :id")
    , @NamedQuery(name = "Componente.findByNombre", query = "SELECT c FROM Componente c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Componente.findByPrecio", query = "SELECT c FROM Componente c WHERE c.precio = :precio")
    , @NamedQuery(name = "Componente.findByUnidadesExistentes", query = "SELECT c FROM Componente c WHERE c.unidadesExistentes = :unidadesExistentes")
    , @NamedQuery(name = "Componente.findByUnidadesPedidos", query = "SELECT c FROM Componente c WHERE c.unidadesPedidos = :unidadesPedidos")

    , @NamedQuery(name = "Componente.findByCategoriaID", query = "SELECT c FROM Componente c, Categoria ca WHERE c.categoriaID =ca.id and c.categoriaID = :categoriaID")
    
})
public class Componente implements Serializable {

    @Lob
    @Column(name = "Imagen")
    private byte[] imagen;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 20)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Precio")
    private int precio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UnidadesExistentes")
    private int unidadesExistentes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UnidadesPedidos")
    private int unidadesPedidos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "componenteID")
    private Collection<Detalledecompra> detalledecompraCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "componenteID2")
    private Collection<Componentesproveedor> componentesproveedorCollection;
    @JoinColumn(name = "CategoriaID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Categoria categoriaID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "componenteID2")
    private Collection<Detalledepedido> detalledepedidoCollection;

    public Componente() {
    }

    public Componente(Integer id) {
        this.id = id;
    }

    public Componente(Integer id, int precio, int unidadesExistentes, int unidadesPedidos) {
        this.id = id;
        this.precio = precio;
        this.unidadesExistentes = unidadesExistentes;
        this.unidadesPedidos = unidadesPedidos;
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

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getUnidadesExistentes() {
        return unidadesExistentes;
    }

    public void setUnidadesExistentes(int unidadesExistentes) {
        this.unidadesExistentes = unidadesExistentes;
    }

    public int getUnidadesPedidos() {
        return unidadesPedidos;
    }

    public void setUnidadesPedidos(int unidadesPedidos) {
        this.unidadesPedidos = unidadesPedidos;
    }


    @XmlTransient
    public Collection<Detalledecompra> getDetalledecompraCollection() {
        return detalledecompraCollection;
    }

    public void setDetalledecompraCollection(Collection<Detalledecompra> detalledecompraCollection) {
        this.detalledecompraCollection = detalledecompraCollection;
    }

    @XmlTransient
    public Collection<Componentesproveedor> getComponentesproveedorCollection() {
        return componentesproveedorCollection;
    }

    public void setComponentesproveedorCollection(Collection<Componentesproveedor> componentesproveedorCollection) {
        this.componentesproveedorCollection = componentesproveedorCollection;
    }

    public Categoria getCategoriaID() {
        return categoriaID;
    }

    public void setCategoriaID(Categoria categoriaID) {
        this.categoriaID = categoriaID;
    }

    @XmlTransient
    public Collection<Detalledepedido> getDetalledepedidoCollection() {
        return detalledepedidoCollection;
    }

    public void setDetalledepedidoCollection(Collection<Detalledepedido> detalledepedidoCollection) {
        this.detalledepedidoCollection = detalledepedidoCollection;
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
        if (!(object instanceof Componente)) {
            return false;
        }
        Componente other = (Componente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tienda.tiendaapi.Componente[ id=" + id + " ]";
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }
    
}
