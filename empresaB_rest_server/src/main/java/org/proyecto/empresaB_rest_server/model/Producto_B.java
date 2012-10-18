package org.proyecto.empresaB_rest_server.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;





//@XStreamAlias("productos-xml")
@XmlRootElement(name="producto_b")
@Entity
@Table(name = "producto_b")
public class Producto_B implements Serializable{
	
	private static final long serialVersionUID = -5527547244002296042L;
	
	  @Id
	//  @Column(name = "IDPRODUCTOB")
	  @Column(name = "IDPRODUCTOB", unique = true, nullable = false)	 
	  @GeneratedValue
	  private Integer idproductob;
	  
	/*  
	  @OneToMany
	  @JoinColumn(name="IDPRODUCTOB")               
	  @org.hibernate.annotations.IndexColumn(name="IDPRODUCTOSELECCIONADO")
	  */
	  
	/*  @OneToMany(fetch = FetchType.LAZY, mappedBy = "idproductob")	  */
	 // @OneToMany(fetch = FetchType.LAZY, mappedBy = "producto_b")
	  
/*	  @OneToMany
	  @JoinColumn(name="IDPRODUCTOB")
	   private List<Producto_BSeleccionado> productos_b_seleccionados=new ArrayList<Producto_BSeleccionado>(0);
	     */        
	  
	 // @XStreamOmitField
	  @OneToMany(fetch = FetchType.LAZY, mappedBy = "producto_b")
	  private Set<Producto_BSeleccionado> productos_b_seleccionados=new HashSet<Producto_BSeleccionado>(0);

	  
	  @Size(min = 1, max = 45, message= "hay que indicar un codigo de producto")
	  @NotNull(message = "Whoooops")
	  @Column(name = "NOMBRE_PRODUCTOB")
	  private String nombre_productoB;
	  
	  
	 

	 
	
	  @NotNull(message = "hay que indicar una cantidad de existencias")
	  @Column (name = "CANTIDAD_EXISTENCIAS_B")
	  private Integer cantidad_existencias;
	  
 
	  @NotNull(message = "hay que indicar una longitud")
	  @Digits(integer=10, fraction=2,  message= "la longitud es un numero con dos decimales")
	  @Column (name = "LONGITUD_B")
	  private BigDecimal longitud_b;
	  

	  @NotNull(message = "hay que indicar un diametro")
	  @Digits(integer=10, fraction=2,  message= "el diametro es un numero con dos decimales")
	  @Column (name = "DIAMETRO_B")	 
	  private BigDecimal diametro_b;
	  
	  @NotNull(message = "hay que indicar un precio")
	  @Digits(integer=10, fraction=2,  message= "el precio es un numero con dos decimales")
	  @NumberFormat(style=Style.CURRENCY)
	  @Column (name = "PRECIO_B")
	  private BigDecimal precio_b;
	  

	  
	//  private Producto_BSeleccionado pruducto_BSeleccionado;
	  
	  
	  










	public Producto_B() {
		
	}







	public Producto_B(String nombre_productoB, Integer cantidad_existencias,
			BigDecimal longitud_b, BigDecimal diametro_b, BigDecimal precio_b) {
		super();
		this.nombre_productoB = nombre_productoB;
		this.cantidad_existencias = cantidad_existencias;
		this.longitud_b = longitud_b;
		this.diametro_b = diametro_b;
		this.precio_b = precio_b;
	}
	public void imprimir(){
		System.out.print(this.getIdproductob());
		System.out.print(" : ");		
		System.out.print(this.getNombre_productoB());
		System.out.print(" : ");
		System.out.print(this.getCantidad_existencias());
		System.out.print(" : ");
		System.out.print(this.getPrecio_b());
		System.out.println("en producto");
	}







	public Integer getIdproductob() {
		return idproductob;
	}



	public void setIdproductob(Integer idproductob) {
		this.idproductob = idproductob;
	}



	public String getNombre_productoB() {
		return nombre_productoB;
	}



	public void setNombre_productoB(String nombre_productoB) {
		this.nombre_productoB = nombre_productoB;
	}



	public Integer getCantidad_existencias() {
		return cantidad_existencias;
	}



	public void setCantidad_existencias(Integer cantidad_existencias) {
		this.cantidad_existencias = cantidad_existencias;
	}


	public BigDecimal getLongitud_b() {
		return longitud_b;
	}







	public void setLongitud_b(BigDecimal longitud_b) {
		this.longitud_b = longitud_b;
	}







	public BigDecimal getDiametro_b() {
		return diametro_b;
	}







	public void setDiametro_b(BigDecimal diametro_b) {
		this.diametro_b = diametro_b;
	}







	public BigDecimal getPrecio_b() {
		return precio_b;
	}







	public void setPrecio_b(BigDecimal precio_b) {
		this.precio_b = precio_b;
	}






	@XmlTransient
	public Set<Producto_BSeleccionado> getProductos_b_seleccionados() {
		return productos_b_seleccionados;
	}







	public void setProductos_b_seleccionados(
			Set<Producto_BSeleccionado> productos_b_seleccionados) {
		this.productos_b_seleccionados = productos_b_seleccionados;
	}








	
	


	
/*	@OneToOne(fetch = FetchType.LAZY, mappedBy = "producto_b", cascade = CascadeType.ALL)
	public Producto_BSeleccionado getPruducto_BSeleccionado() {
		return pruducto_BSeleccionado;
	}


	public void setPruducto_BSeleccionado(
			Producto_BSeleccionado pruducto_BSeleccionado) {
		this.pruducto_BSeleccionado = pruducto_BSeleccionado;
	}
*/
	
	
	  

}
