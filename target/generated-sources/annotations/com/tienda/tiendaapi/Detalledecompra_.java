package com.tienda.tiendaapi;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Detalledecompra.class)
public abstract class Detalledecompra_ {

	public static volatile SingularAttribute<Detalledecompra, Integer> precio;
	public static volatile SingularAttribute<Detalledecompra, Pedidoproveedor> pedidoProveedorID;
	public static volatile SingularAttribute<Detalledecompra, Integer> id;
	public static volatile SingularAttribute<Detalledecompra, Integer> cantidad;
	public static volatile SingularAttribute<Detalledecompra, Componente> componenteID;

}

