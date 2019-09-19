package com.zea.ovidio.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "compras")
public class Compras implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7166424010158544437L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "id_cliente", nullable = false)
	private Cliente idCliente;

	@ManyToOne
	@JoinColumn(name = "id_producto", nullable = false)
	private Producto idProducto;

	@Column(name = "numero_factura")
	private Integer numeroFactura;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cliente getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Cliente idCliente) {
		this.idCliente = idCliente;
	}

	public Producto getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Producto idProducto) {
		this.idProducto = idProducto;
	}

	public Integer getNumeroFactura() {
		return numeroFactura;
	}

	public void setNumeroFactura(Integer numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Compras [id=");
		builder.append(id);
		builder.append(", idCliente=");
		builder.append(idCliente);
		builder.append(", idProducto=");
		builder.append(idProducto);
		builder.append(", numeroFactura=");
		builder.append(numeroFactura);
		builder.append("]");
		return builder.toString();
	}

}
