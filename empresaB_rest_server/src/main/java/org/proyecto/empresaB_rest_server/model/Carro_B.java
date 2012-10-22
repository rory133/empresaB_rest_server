package org.proyecto.empresaB_rest_server.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.proyecto.empresaB_rest_server.model.Producto_BSeleccionado;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;



@XmlRootElement(name="carro_b")
@Entity
/*@Component
@Scope("session")*/
@Table(name = "carro_b")
public class Carro_B implements Serializable{
	
	private static final long serialVersionUID = -5527547205002296042L;

	
	private Integer idcarro_b;
	private Date fecha_b;
	private Set<Producto_BSeleccionado> producto_BSeleccionado = new HashSet<Producto_BSeleccionado>(0);
	private Cliente_B cliente_b;
	private Boolean pagado;
	private Boolean enviado;
	private BigDecimal total;
	

	public Carro_B() {
	}


	public Carro_B(Date fecha_b) {
		super();
		this.fecha_b = fecha_b;
	}
	
	


	public Carro_B(Date fecha_b, Cliente_B cliente_b) {
		super();
		this.fecha_b = fecha_b;
		this.cliente_b = cliente_b;
	}


	public Carro_B( Set<Producto_BSeleccionado> producto_BSeleccionado) {
		super();
		this.producto_BSeleccionado = producto_BSeleccionado;
		this.fecha_b=new Date();
	}


	
	@Id
	@GeneratedValue
	@Column(name = "IDCARRO_B")
	public Integer getIdcarro_b() {
		return idcarro_b;
	}

	
	public void setIdcarro_b(Integer idcarro_b) {
		this.idcarro_b = idcarro_b;
	}


	@Column(name = "FECHA")
	public Date getFecha_b() {
		return fecha_b;
	}

	
	
	public void setFecha_b(Date fecha_b) {
		this.fecha_b = fecha_b;
	}

	@XmlTransient
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "carro_b")
	public Set<Producto_BSeleccionado> getProducto_BSeleccionado() {
		return producto_BSeleccionado;
	}


	
	public void setProducto_BSeleccionado(
			Set<Producto_BSeleccionado> producto_BSeleccionado) {
		this.producto_BSeleccionado = producto_BSeleccionado;
	}
	
	//@XmlTransient
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcliente", nullable = false)
	public Cliente_B getCliente_b() {
		return cliente_b;
	}


	public void setCliente_b(Cliente_B cliente_b) {
		this.cliente_b = cliente_b;
	}
	
	
	@Column(name = "PAGADO")
	public Boolean getPagado() {
		return pagado;
	}


	public void setPagado(Boolean pagado) {
		this.pagado = pagado;
	}

	
	@Column(name = "ENVIADO")
	public Boolean getEnviado() {
		return enviado;
	}


	public void setEnviado(Boolean enviado) {
		this.enviado = enviado;
	}
	
	
	@Column(name = "TOTAL")
	public BigDecimal getTotal() {
		return total;
	}


	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	
	
/*	@OneToMany(fetch = FetchType.LAZY, mappedBy = "carro_b")
	public Set<Producto_BSeleccionado> getProducto_bseleccionado() {
		return producto_BSeleccionado;
	}


	public void setProducto_bseleccionado(
			Set<Producto_BSeleccionado> producto_BSeleccionado) {
		this.producto_BSeleccionado = producto_BSeleccionado;
	}*/
	
	
	

	
/*	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "PRODUCTO_B-LINEA_DE_PRODUCTO_B", joinColumns = { @JoinColumn(name = "IDLINEA_DE_PRODUCTO_B") }, inverseJoinColumns = { @JoinColumn(name = "IDPRODUCTOB") })
	*/
	
	
/*	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "PRODUCTO_B_LINEA", joinColumns = { @JoinColumn(name = "IDLINEA_DE_PRODUCTO_B") }, inverseJoinColumns = {
			@JoinColumn(name = "IDPRODUCTOB") })*/
	
	//@ManyToMany(fetch = FetchType.LAZY, mappedBy = "carroB")
	
	
	
/*
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "PRODUCTO_B_LINEA", joinColumns = { 
			@JoinColumn(name = "IDLINEA_DE_PRODUCTO_B", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "IDPRODUCTOB", 
					nullable = false, updatable = false) })*/
	
/*	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "PRODUCTO_B_LINEA", joinColumns = { @JoinColumn(name = "IDLINEA_DE_PRODUCTO_B") }, inverseJoinColumns = {
			@JoinColumn(name = "IDPRODUCTOB") })*/
	

	
	
	
	
	
	
}
