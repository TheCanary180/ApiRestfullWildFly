package com.tienda.tiendaapi;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Proveedor.class)
public abstract class Proveedor_ {

	public static volatile SingularAttribute<Proveedor, Integer> codigoPostal;
	public static volatile SingularAttribute<Proveedor, String> direccion;
	public static volatile SingularAttribute<Proveedor, byte[]> imagen;
	public static volatile CollectionAttribute<Proveedor, Componentesproveedor> componentesproveedorCollection;
	public static volatile SingularAttribute<Proveedor, String> provincia;
	public static volatile SingularAttribute<Proveedor, String> pais;
	public static volatile SingularAttribute<Proveedor, String> nombreProveedor;
	public static volatile SingularAttribute<Proveedor, String> nombreContacto;
	public static volatile SingularAttribute<Proveedor, String> ciudad;
	public static volatile CollectionAttribute<Proveedor, Pedidoproveedor> pedidoproveedorCollection;
	public static volatile SingularAttribute<Proveedor, Integer> id;
	public static volatile SingularAttribute<Proveedor, Integer> telefono;
	public static volatile SingularAttribute<Proveedor, Integer> fax;
	public static volatile SingularAttribute<Proveedor, String> email;

}

