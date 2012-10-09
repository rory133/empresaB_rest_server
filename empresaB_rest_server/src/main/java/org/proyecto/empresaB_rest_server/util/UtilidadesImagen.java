package org.proyecto.empresaB_rest_server.util;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.MultipartFile;



public class UtilidadesImagen {
	
	protected static Logger logger = Logger.getLogger("*en Utilidaes imagen*");
	
	   @Value("#{imagen.dir}") 
	    private String directorioImagenes="pakito"; 
	
	public void saveImage(String filename, MultipartFile image)throws RuntimeException{
		logger.info("en save imagenes");
		try{
			File file = new File("C:/imagenes/imagenesEmpresaB/"+ filename);
			FileUtils.writeByteArrayToFile(file,image.getBytes());
			logger.info("en try de save imagenes");
		}catch (IOException e){
			throw new RuntimeException ("no se puede cargar la imagen");
			
		}
	}
}

