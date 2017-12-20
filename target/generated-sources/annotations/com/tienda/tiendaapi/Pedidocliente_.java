package com.tienda.tiendaapi;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Pedidocliente.class)
public abstract class Pedidocliente_ {

	public static volatile SingularAttribute<Pedidocliente, String> direccionDestinatario;
	public static volatile SingularAttribute<Pedidocliente, Empleado> empleadoID;
	public static volatile SingularAttribute<Pedidocliente, String> provinciaDestinatario;
	public static volatile SingularAttribute<Pedidocliente, Integer> codigoPostalDestinatario;
	public static volatile SingularAttribute<Pedidocliente, Date> fechaPedido;
	public static volatile SingularAttribute<Pedidocliente, String> producto;
	public static volatile SingularAttribute<Pedidocliente, String> ciudadDestinatario;
	public static volatile SingularAttribute<Pedidocliente, Double> total;
	public static volatile SingularAttribute<Pedidocliente, Date> fechaEnvio;
	public static volatile SingularAttribute<Pedidocliente, Cliente> clienteID;
	public static volatile SingularAttribute<Pedidocliente, String> nombreDestinatario;
	public static volatile SingularAttribute<Pedidocliente, Date> fechaEntrega;
	public static volatile SingularAttribute<Pedidocliente, Integer> id;
	public static volatile SingularAttribute<Pedidocliente, Integer> cantidad;
	public static volatile CollectionAttribute<Pedidocliente, Detalledepedido> detalledepedidoCollection;
	public static volatile SingularAttribute<Pedidocliente, String> paisDestinatario;

}

