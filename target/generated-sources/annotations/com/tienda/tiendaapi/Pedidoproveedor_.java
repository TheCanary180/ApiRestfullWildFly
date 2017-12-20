package com.tienda.tiendaapi;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Pedidoproveedor.class)
public abstract class Pedidoproveedor_ {

	public static volatile SingularAttribute<Pedidoproveedor, Integer> fecha;
	public static volatile SingularAttribute<Pedidoproveedor, Integer> precio;
	public static volatile CollectionAttribute<Pedidoproveedor, Detalledecompra> detalledecompraCollection;
	public static volatile SingularAttribute<Pedidoproveedor, Proveedor> proveedorID;
	public static volatile SingularAttribute<Pedidoproveedor, Empleado> empleadoID;
	public static volatile SingularAttribute<Pedidoproveedor, Integer> id;

}

