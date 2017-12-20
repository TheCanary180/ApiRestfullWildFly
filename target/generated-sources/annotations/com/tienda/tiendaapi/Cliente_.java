package com.tienda.tiendaapi;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cliente.class)
public abstract class Cliente_ {

	public static volatile SingularAttribute<Cliente, String> apellidos;
	public static volatile SingularAttribute<Cliente, Integer> codigoPostal;
	public static volatile SingularAttribute<Cliente, String> direccion;
	public static volatile SingularAttribute<Cliente, byte[]> imagen;
	public static volatile SingularAttribute<Cliente, String> provincia;
	public static volatile SingularAttribute<Cliente, String> nombre;
	public static volatile SingularAttribute<Cliente, Integer> edad;
	public static volatile SingularAttribute<Cliente, String> pais;
	public static volatile SingularAttribute<Cliente, String> ciudad;
	public static volatile SingularAttribute<Cliente, Integer> id;
	public static volatile SingularAttribute<Cliente, Integer> telefono;
	public static volatile SingularAttribute<Cliente, String> dni;
	public static volatile SingularAttribute<Cliente, String> email;
	public static volatile CollectionAttribute<Cliente, Pedidocliente> pedidoclienteCollection;

}

