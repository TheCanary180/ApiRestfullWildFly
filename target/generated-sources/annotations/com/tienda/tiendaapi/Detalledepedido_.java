package com.tienda.tiendaapi;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Detalledepedido.class)
public abstract class Detalledepedido_ {

	public static volatile SingularAttribute<Detalledepedido, Integer> precio;
	public static volatile SingularAttribute<Detalledepedido, Componente> componenteID2;
	public static volatile SingularAttribute<Detalledepedido, Integer> id;
	public static volatile SingularAttribute<Detalledepedido, Integer> cantidad;
	public static volatile SingularAttribute<Detalledepedido, Pedidocliente> pedidoClienteID2;

}

