package com.tienda.tiendaapi;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Categoria.class)
public abstract class Categoria_ {

	public static volatile SingularAttribute<Categoria, String> descripcion;
	public static volatile SingularAttribute<Categoria, byte[]> imagen;
	public static volatile SingularAttribute<Categoria, Integer> id;
	public static volatile SingularAttribute<Categoria, String> nombreCategoria;
	public static volatile CollectionAttribute<Categoria, Componente> componenteCollection;

}

