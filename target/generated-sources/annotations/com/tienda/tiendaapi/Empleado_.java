package com.tienda.tiendaapi;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Empleado.class)
public abstract class Empleado_ {

	public static volatile SingularAttribute<Empleado, Integer> codigoPostal;
	public static volatile SingularAttribute<Empleado, String> direccion;
	public static volatile SingularAttribute<Empleado, byte[]> imagen;
	public static volatile SingularAttribute<Empleado, String> turno;
	public static volatile SingularAttribute<Empleado, String> provincia;
	public static volatile SingularAttribute<Empleado, String> nombre;
	public static volatile SingularAttribute<Empleado, Integer> edad;
	public static volatile SingularAttribute<Empleado, String> pais;
	public static volatile SingularAttribute<Empleado, String> puesto;
	public static volatile SingularAttribute<Empleado, String> ciudad;
	public static volatile SingularAttribute<Empleado, String> apellido;
	public static volatile SingularAttribute<Empleado, Date> fechaContratacion;
	public static volatile CollectionAttribute<Empleado, Pedidoproveedor> pedidoproveedorCollection;
	public static volatile SingularAttribute<Empleado, Integer> id;
	public static volatile SingularAttribute<Empleado, Integer> telefono;
	public static volatile SingularAttribute<Empleado, String> dni;
	public static volatile SingularAttribute<Empleado, String> email;
	public static volatile CollectionAttribute<Empleado, Pedidocliente> pedidoclienteCollection;

}

