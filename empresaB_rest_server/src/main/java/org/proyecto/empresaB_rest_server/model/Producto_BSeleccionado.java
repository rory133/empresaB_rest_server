package org.proyecto.empresaB_rest_server.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;


@Entity
@Table(name = "producto_bseleccionado")
public class Producto_BSeleccionado implements Serializable {
	
	private static final long serialVersionUID = -5527566206302296042L;
	
	 private Integer idproductoSeleccionado;
	  private Integer cantidad;
	/*  private Integer idproductob;*/
	  private Producto_B producto_b;
	  private Carro_B carro_b;
	//  private Set<Carro_B> carroB =new HashSet<Carro_B>(0);

	
	  /*@OneToOne(fetch = FetchType.LAZY)
	  @PrimaryKeyJoinColumn*/
	  
	  
	  
	  public Producto_BSeleccionado() {

		}
	  
	
	  




/*	@GenericGenerator(name = "generator", strategy = "foreign", 
	parameters = @Parameter(name = "property", value = "producto_B"))
	@Id
	@GeneratedValue(generator = "generator")*/
	//@Column(name = "IDPRODUCTOB", unique = true, nullable = false)
	  
	/*  
	@Column(name = "IDPRODUCTOB", unique = false, nullable = false)
	public Integer getIdproductob() {
		return this.idproductob;
	}

	public void setIdproductob(Integer idproductob) {
		this.idproductob = idproductob;
	}

	*/
	
	@Column(name = "CANTIDAD")
	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}


/*	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	*/
	
	
	/*
	@ManyToOne
	@JoinColumn(name="IDPRODUCTOB", referencedColumnName = "IDPRODUCTOB", insertable = false, updatable = false)
	*/
	
	
/*	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDPRODUCTOB", nullable = false)*/
	
/*	@ManyToOne
	@JoinColumn(name="IDPRODUCTOB", referencedColumnName = "IDPRODUCTOB", insertable = false, updatable = false)
	public Producto_B getProducto_B() {
		return producto_b;
	}



	public void setProducto_B(Producto_B producto_b) {
		
		this.producto_b = producto_b;
	}
*/

	
	


	  @Id
	  @Column(name = "IDPRODUCTOSELECCIONADO", unique = true, nullable = false)	 
	  @GeneratedValue
	public Integer getIdproductoSeleccionado() {
		return idproductoSeleccionado;
	}







	public void setIdproductoSeleccionado(Integer idproductoSeleccionado) {
		this.idproductoSeleccionado = idproductoSeleccionado;
	}





/*
	@ManyToOne
	@JoinColumn(name="IDPRODUCTOB", referencedColumnName = "IDPRODUCTOB", insertable = false, updatable = false)
	public Producto_B getProducto_b() {
		return producto_b;
	}

	public void setProducto_b(Producto_B producto_b) {
		this.producto_b = producto_b;
	}

*/



	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idproductoB", nullable = false)
	public Producto_B getProducto_b() {
		return producto_b;
	}

	public void setProducto_b(Producto_B producto_b) {
		this.producto_b = producto_b;
	}





	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDCARRO_B", nullable = false)
	public Carro_B getCarro_b() {
		return carro_b;
	}


	public void setCarro_b(Carro_B carro_b) {
		this.carro_b = carro_b;
	}




	



	
	
	


/*
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "producto_BSeleccionado")
	public Set<Carro_B> getCarroB() {
		return carroB;
	}



	public void setCarroB(Set<Carro_B> carroB) {
		this.carroB = carroB;
	}*/
	

	
	

	  
	  
	  
	 
}

