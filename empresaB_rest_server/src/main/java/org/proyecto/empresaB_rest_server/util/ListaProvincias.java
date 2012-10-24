package org.proyecto.empresaB_rest_server.util;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Repository;


@Repository("listaProvincias")
public class ListaProvincias {
	
	//public Map listadoProvincias;
	List<String> listadoProvincias = new ArrayList<String>();
	
	
	public ListaProvincias() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void SetListadoProvincias() { 
		//Map opciones = new HashMap();
 
		//Map<String,String> provincias = new LinkedHashMap<String,String>();
		
		
		this.listadoProvincias.add("Alava");
		this.listadoProvincias.add("Albacete");
		this.listadoProvincias.add("Alicante");
		this.listadoProvincias.add("Almeria");
		this.listadoProvincias.add("Asturias");
		this.listadoProvincias.add("Avila");
		this.listadoProvincias.add("Badajoz");
		this.listadoProvincias.add("Barcelona");
		this.listadoProvincias.add("Burgos");
		this.listadoProvincias.add("Caceres");
		this.listadoProvincias.add("Cadiz");
		this.listadoProvincias.add("Cantabria");
		this.listadoProvincias.add("Castellon");
		this.listadoProvincias.add("Ceuta");
		this.listadoProvincias.add("Ciudad Real");
		this.listadoProvincias.add("Cordoba");
		this.listadoProvincias.add("Coruña, A");
		this.listadoProvincias.add("Cuenca");
		this.listadoProvincias.add("Girona");
		this.listadoProvincias.add("Granada");
		this.listadoProvincias.add("Guadalajara");
		this.listadoProvincias.add("Guipuzcoa");
		this.listadoProvincias.add("Huelva");
		this.listadoProvincias.add("Huesca");
		this.listadoProvincias.add("Illes Balears");
		this.listadoProvincias.add("Jaen");
		this.listadoProvincias.add("Leon");
		this.listadoProvincias.add("Lleida");
		this.listadoProvincias.add("Lugo");
		this.listadoProvincias.add("Madrid");
		this.listadoProvincias.add("Malaga");
		this.listadoProvincias.add("Melilla");
		this.listadoProvincias.add("Murcia");
		this.listadoProvincias.add("Navarra");
		this.listadoProvincias.add("Ourense");
		this.listadoProvincias.add("Palencia");
		this.listadoProvincias.add("Palmas, Las");
		this.listadoProvincias.add("Pontevedra");
		this.listadoProvincias.add("Rioja, La");
		this.listadoProvincias.add("Salamanca");
		this.listadoProvincias.add("Santa Cruz De Tenerife");
		this.listadoProvincias.add("Segovia");
		this.listadoProvincias.add("Sevilla");
		this.listadoProvincias.add("Soria");
		this.listadoProvincias.add("Tarragona");
		this.listadoProvincias.add("Teruel");
		this.listadoProvincias.add("Toledo");
		this.listadoProvincias.add("Valencia");
		this.listadoProvincias.add("Valladolid");
		this.listadoProvincias.add("Vizcaya");
		this.listadoProvincias.add("Zamora");
		this.listadoProvincias.add("Zaragoza");
	}


/*	public void SetListadoProvincias() { 
		//Map opciones = new HashMap();
 
		//Map<String,String> provincias = new LinkedHashMap<String,String>();
		
		
		this.listadoProvincias.put("01", "Alava");
		this.listadoProvincias.put("02", "Albacete");
		this.listadoProvincias.put("03", "Alicante");
		this.listadoProvincias.put("04", "Almeria");
		this.listadoProvincias.put("33", "Asturias");
		this.listadoProvincias.put("05", "Avila");
		this.listadoProvincias.put("06", "Badajoz");
		this.listadoProvincias.put("08", "Barcelona");
		this.listadoProvincias.put("09", "Burgos");
		this.listadoProvincias.put("10", "Caceres");
		this.listadoProvincias.put("11", "Cadiz");
		this.listadoProvincias.put("39", "Cantabria");
		this.listadoProvincias.put("12", "Castellon");
		this.listadoProvincias.put("51", "Ceuta");
		this.listadoProvincias.put("13", "Ciudad Real");
		this.listadoProvincias.put("14", "Cordoba");
		this.listadoProvincias.put("15", "Coruña, A");
		this.listadoProvincias.put("16", "Cuenca");
		this.listadoProvincias.put("17", "Girona");
		this.listadoProvincias.put("18", "Granada");
		this.listadoProvincias.put("19", "Guadalajara");
		this.listadoProvincias.put("20", "Guipuzcoa");
		this.listadoProvincias.put("21", "Huelva");
		this.listadoProvincias.put("22", "Huesca");
		this.listadoProvincias.put("07", "Illes Balears");
		this.listadoProvincias.put("23", "Jaen");
		this.listadoProvincias.put("24", "Leon");
		this.listadoProvincias.put("25", "Lleida");
		this.listadoProvincias.put("27", "Lugo");
		this.listadoProvincias.put("28", "Madrid");
		this.listadoProvincias.put("29", "Malaga");
		this.listadoProvincias.put("52", "Melilla");
		this.listadoProvincias.put("30", "Murcia");
		this.listadoProvincias.put("31", "Navarra");
		this.listadoProvincias.put("32", "Ourense");
		this.listadoProvincias.put("34", "Palencia");
		this.listadoProvincias.put("35", "Palmas, Las");
		this.listadoProvincias.put("36", "Pontevedra");
		this.listadoProvincias.put("26", "Rioja, La");
		this.listadoProvincias.put("37", "Salamanca");
		this.listadoProvincias.put("38", "Santa Cruz De Tenerife");
		this.listadoProvincias.put("40", "Segovia");
		this.listadoProvincias.put("41", "Sevilla");
		this.listadoProvincias.put("42", "Soria");
		this.listadoProvincias.put("43", "Tarragona");
		this.listadoProvincias.put("44", "Teruel");
		this.listadoProvincias.put("45", "Toledo");
		this.listadoProvincias.put("46", "Valencia");
		this.listadoProvincias.put("47", "Valladolid");
		this.listadoProvincias.put("48", "Vizcaya");
		this.listadoProvincias.put("49", "Zamora");
		this.listadoProvincias.put("50", "Zaragoza");
	}
*/
	public List<String> getListadoProvincias() {
		return listadoProvincias;
	}
	
	

}
