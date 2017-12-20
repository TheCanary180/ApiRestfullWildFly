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
import javax.persistence.Lob;
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
@Table(name = "empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e")
    , @NamedQuery(name = "Empleado.findById", query = "SELECT e FROM Empleado e WHERE e.id = :id")
    , @NamedQuery(name = "Empleado.findByNombre", query = "SELECT e FROM Empleado e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "Empleado.findByApellido", query = "SELECT e FROM Empleado e WHERE e.apellido = :apellido")
    , @NamedQuery(name = "Empleado.findByDni", query = "SELECT e FROM Empleado e WHERE e.dni = :dni")
    , @NamedQuery(name = "Empleado.findByPuesto", query = "SELECT e FROM Empleado e WHERE e.puesto = :puesto")
    , @NamedQuery(name = "Empleado.findByTurno", query = "SELECT e FROM Empleado e WHERE e.turno = :turno")
    , @NamedQuery(name = "Empleado.findByEdad", query = "SELECT e FROM Empleado e WHERE e.edad = :edad")
    , @NamedQuery(name = "Empleado.findByTelefono", query = "SELECT e FROM Empleado e WHERE e.telefono = :telefono")
    , @NamedQuery(name = "Empleado.findByEmail", query = "SELECT e FROM Empleado e WHERE e.email = :email")
    , @NamedQuery(name = "Empleado.findByDireccion", query = "SELECT e FROM Empleado e WHERE e.direccion = :direccion")
    , @NamedQuery(name = "Empleado.findByCiudad", query = "SELECT e FROM Empleado e WHERE e.ciudad = :ciudad")
    , @NamedQuery(name = "Empleado.findByProvincia", query = "SELECT e FROM Empleado e WHERE e.provincia = :provincia")
    , @NamedQuery(name = "Empleado.findByPais", query = "SELECT e FROM Empleado e WHERE e.pais = :pais")
    , @NamedQuery(name = "Empleado.findByCodigoPostal", query = "SELECT e FROM Empleado e WHERE e.codigoPostal = :codigoPostal")
    , @NamedQuery(name = "Empleado.findByFechaContratacion", query = "SELECT e FROM Empleado e WHERE e.fechaContratacion = :fechaContratacion")})
public class Empleado implements Serializable {

    @Lob
    @Column(name = "Imagen")
    private byte[] imagen;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 25)
    @Column(name = "Nombre")
    private String nombre;
    @Size(max = 25)
    @Column(name = "Apellido")
    private String apellido;
    @Size(max = 9)
    @Column(name = "Dni")
    private String dni;
    @Size(max = 20)
    @Column(name = "Puesto")
    private String puesto;
    @Size(max = 20)
    @Column(name = "Turno")
    private String turno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Edad")
    private int edad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Telefono")
    private int telefono;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Correo electrónico no válido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "Email")
    private String email;
    @Size(max = 50)
    @Column(name = "Direccion")
    private String direccion;
    @Size(max = 50)
    @Column(name = "Ciudad")
    private String ciudad;
    @Size(max = 50)
    @Column(name = "Provincia")
    private String provincia;
    @Size(max = 50)
    @Column(name = "Pais")
    private String pais;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CodigoPostal")
    private int codigoPostal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaContratacion")
    @Temporal(TemporalType.DATE)
    private Date fechaContratacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleadoID")
    private Collection<Pedidocliente> pedidoclienteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleadoID")
    private Collection<Pedidoproveedor> pedidoproveedorCollection;

    public Empleado() {
    }

    public Empleado(Integer id) {
        this.id = id;
    }

    public Empleado(Integer id, int edad, int telefono, int codigoPostal, Date fechaContratacion) {
        this.id = id;
        this.edad = edad;
        this.telefono = telefono;
        this.codigoPostal = codigoPostal;
        this.fechaContratacion = fechaContratacion;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }


    @XmlTransient
    public Collection<Pedidocliente> getPedidoclienteCollection() {
        return pedidoclienteCollection;
    }

    public void setPedidoclienteCollection(Collection<Pedidocliente> pedidoclienteCollection) {
        this.pedidoclienteCollection = pedidoclienteCollection;
    }

    @XmlTransient
    public Collection<Pedidoproveedor> getPedidoproveedorCollection() {
        return pedidoproveedorCollection;
    }

    public void setPedidoproveedorCollection(Collection<Pedidoproveedor> pedidoproveedorCollection) {
        this.pedidoproveedorCollection = pedidoproveedorCollection;
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
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tienda.tiendaapi.Empleado[ id=" + id + " ]";
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }
    
}
