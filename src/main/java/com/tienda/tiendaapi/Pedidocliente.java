/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.tiendaapi;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TheCanary
 */
@Entity
@Table(name = "pedidocliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedidocliente.findAll", query = "SELECT p FROM Pedidocliente p")
    , @NamedQuery(name = "Pedidocliente.findById", query = "SELECT p FROM Pedidocliente p WHERE p.id = :id")
    , @NamedQuery(name = "Pedidocliente.findByFechaPedido", query = "SELECT p FROM Pedidocliente p WHERE p.fechaPedido = :fechaPedido")
    , @NamedQuery(name = "Pedidocliente.findByFechaEntrega", query = "SELECT p FROM Pedidocliente p WHERE p.fechaEntrega = :fechaEntrega")
    , @NamedQuery(name = "Pedidocliente.findByFechaEnvio", query = "SELECT p FROM Pedidocliente p WHERE p.fechaEnvio = :fechaEnvio")
    , @NamedQuery(name = "Pedidocliente.findByNombreDestinatario", query = "SELECT p FROM Pedidocliente p WHERE p.nombreDestinatario = :nombreDestinatario")
    , @NamedQuery(name = "Pedidocliente.findByDireccionDestinatario", query = "SELECT p FROM Pedidocliente p WHERE p.direccionDestinatario = :direccionDestinatario")
    , @NamedQuery(name = "Pedidocliente.findByCiudadDestinatario", query = "SELECT p FROM Pedidocliente p WHERE p.ciudadDestinatario = :ciudadDestinatario")
    , @NamedQuery(name = "Pedidocliente.findByProvinciaDestinatario", query = "SELECT p FROM Pedidocliente p WHERE p.provinciaDestinatario = :provinciaDestinatario")
    , @NamedQuery(name = "Pedidocliente.findByPaisDestinatario", query = "SELECT p FROM Pedidocliente p WHERE p.paisDestinatario = :paisDestinatario")
    , @NamedQuery(name = "Pedidocliente.findByCodigoPostalDestinatario", query = "SELECT p FROM Pedidocliente p WHERE p.codigoPostalDestinatario = :codigoPostalDestinatario")
    , @NamedQuery(name = "Pedidocliente.findByProducto", query = "SELECT p FROM Pedidocliente p WHERE p.producto = :producto")
    , @NamedQuery(name = "Pedidocliente.findByCantidad", query = "SELECT p FROM Pedidocliente p WHERE p.cantidad = :cantidad")
    , @NamedQuery(name = "Pedidocliente.findByTotal", query = "SELECT p FROM Pedidocliente p WHERE p.total = :total")

    , @NamedQuery(name = "Pedidocliente.findByCliente", query = "SELECT p FROM Pedidocliente p, Cliente c WHERE p.clienteID =c.id and p.clienteID = :clienteID")
    , @NamedQuery(name = "Pedidocliente.findByEmpleado", query = "SELECT p FROM Pedidocliente p, Empleado e WHERE p.clienteID =e.id and p.empleadoID = :empleadoID")
})
public class Pedidocliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaPedido")
    @Temporal(TemporalType.DATE)
    private Date fechaPedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaEntrega")
    @Temporal(TemporalType.DATE)
    private Date fechaEntrega;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaEnvio")
    @Temporal(TemporalType.DATE)
    private Date fechaEnvio;
    @Size(max = 50)
    @Column(name = "NombreDestinatario")
    private String nombreDestinatario;
    @Size(max = 50)
    @Column(name = "DireccionDestinatario")
    private String direccionDestinatario;
    @Size(max = 50)
    @Column(name = "CiudadDestinatario")
    private String ciudadDestinatario;
    @Size(max = 50)
    @Column(name = "ProvinciaDestinatario")
    private String provinciaDestinatario;
    @Size(max = 50)
    @Column(name = "PaisDestinatario")
    private String paisDestinatario;
    @Column(name = "CodigoPostalDestinatario")
    private Integer codigoPostalDestinatario;
    @Size(max = 50)
    @Column(name = "Producto")
    private String producto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Total")
    private double total;
    @JoinColumn(name = "ClienteID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Cliente clienteID;
    @JoinColumn(name = "EmpleadoID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Empleado empleadoID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedidoClienteID2")
    private Collection<Detalledepedido> detalledepedidoCollection;

    public Pedidocliente() {
    }

    public Pedidocliente(Integer id) {
        this.id = id;
    }

    public Pedidocliente(Integer id, Date fechaPedido, Date fechaEntrega, Date fechaEnvio, int cantidad, double total) {
        this.id = id;
        this.fechaPedido = fechaPedido;
        this.fechaEntrega = fechaEntrega;
        this.fechaEnvio = fechaEnvio;
        this.cantidad = cantidad;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public String getNombreDestinatario() {
        return nombreDestinatario;
    }

    public void setNombreDestinatario(String nombreDestinatario) {
        this.nombreDestinatario = nombreDestinatario;
    }

    public String getDireccionDestinatario() {
        return direccionDestinatario;
    }

    public void setDireccionDestinatario(String direccionDestinatario) {
        this.direccionDestinatario = direccionDestinatario;
    }

    public String getCiudadDestinatario() {
        return ciudadDestinatario;
    }

    public void setCiudadDestinatario(String ciudadDestinatario) {
        this.ciudadDestinatario = ciudadDestinatario;
    }

    public String getProvinciaDestinatario() {
        return provinciaDestinatario;
    }

    public void setProvinciaDestinatario(String provinciaDestinatario) {
        this.provinciaDestinatario = provinciaDestinatario;
    }

    public String getPaisDestinatario() {
        return paisDestinatario;
    }

    public void setPaisDestinatario(String paisDestinatario) {
        this.paisDestinatario = paisDestinatario;
    }

    public Integer getCodigoPostalDestinatario() {
        return codigoPostalDestinatario;
    }

    public void setCodigoPostalDestinatario(Integer codigoPostalDestinatario) {
        this.codigoPostalDestinatario = codigoPostalDestinatario;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Cliente getClienteID() {
        return clienteID;
    }

    public void setClienteID(Cliente clienteID) {
        this.clienteID = clienteID;
    }

    public Empleado getEmpleadoID() {
        return empleadoID;
    }

    public void setEmpleadoID(Empleado empleadoID) {
        this.empleadoID = empleadoID;
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
        if (!(object instanceof Pedidocliente)) {
            return false;
        }
        Pedidocliente other = (Pedidocliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tienda.tiendaapi.Pedidocliente[ id=" + id + " ]";
    }
    
}
