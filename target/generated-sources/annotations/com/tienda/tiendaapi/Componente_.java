package com.tienda.tiendaapi;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Componente.class)
public abstract class Componente_ {

	public static volatile SingularAttribute<Componente, Integer> precio;
	public static volatile CollectionAttribute<Componente, Detalledecompra> detalledecompraCollection;
	public static volatile SingularAttribute<Componente, byte[]> imagen;
	public static volatile SingularAttribute<Componente, Integer> unidadesPedidos;
	public static volatile SingularAttribute<Componente, Integer> id;
	public static volatile CollectionAttribute<Componente, Componentesproveedor> componentesproveedorCollection;
	public static volatile CollectionAttribute<Componente, Detalledepedido> detalledepedidoCollection;
	public static volatile SingularAttribute<Componente, String> nombre;
	public static volatile SingularAttribute<Componente, Integer> unidadesExistentes;
	public static volatile SingularAttribute<Componente, Categoria> categoriaID;

}

