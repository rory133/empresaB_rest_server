package org.proyecto.empresaB_rest_server.service.impl;




	import java.io.BufferedInputStream;
	import java.io.BufferedOutputStream;
	import java.io.Closeable;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.net.URLDecoder;

	import javax.servlet.ServletException;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	/**
	proporciona una imagen desde un path absoluto
	 */
	public class ImagenServlet extends HttpServlet {

	    // Constants ----------------------------------------------------------------------------------

	    private static final int DEFAULT_BUFFER_SIZE = 204800; // 200KB.

	    // Properties ---------------------------------------------------------------------------------

	    private String imagePath;

	    // Actions ------------------------------------------------------------------------------------

	    public void init() throws ServletException {

	        // se define el path
	        this.imagePath = "C:\\imagenes\\empresaB_rest_server\\";


	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException
	    {
	        // Get requested imagen por el pathinfo.
	        String requestedImage = request.getPathInfo();

	        // Checkeamos el nombre.
	        if (requestedImage == null) {
	            // si no existe mandamos no found.
	            
	            response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404.
	            return;
	        }

	        //se prepara el ogjeto.
	        File image = new File(imagePath, URLDecoder.decode(requestedImage, "UTF-8"));

	        // se comprueba que exista en el sistema de ficheros.
	        if (!image.exists()) {
	            //si no existe mandamos not-found.
	            response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404.
	            return;
	        }

	        // compobanmos el contenttype
	        String contentType = getServletContext().getMimeType(image.getName());

	        // comprobamos que sea una imagen
	        if (contentType == null || !contentType.startsWith("image")) {
	            //si no lo es-not-found
	            response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404.
	            return;
	        }

	        // Iniciamos el servlet response.
	        response.reset();
	        response.setBufferSize(DEFAULT_BUFFER_SIZE);
	        response.setContentType(contentType);
	        response.setHeader("Content-Length", String.valueOf(image.length()));
	        response.setHeader("Content-Disposition", "inline; filename=\"" + image.getName() + "\"");

	        // Preparamos streams.
	        BufferedInputStream input = null;
	        BufferedOutputStream output = null;

	        try {
	            //Abrimos streams.
	            input = new BufferedInputStream(new FileInputStream(image), DEFAULT_BUFFER_SIZE);
	            output = new BufferedOutputStream(response.getOutputStream(), DEFAULT_BUFFER_SIZE);

	            // Write escribimos el fichero en el response.
	            byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
	            int length;
	            while ((length = input.read(buffer)) > 0) {
	                output.write(buffer, 0, length);
	            }
	        } finally {
	            // cerramos streams.
	            close(output);
	            close(input);
	        }
	    }

	    

	    private static void close(Closeable resource) {
	        if (resource != null) {
	            try {
	                resource.close();
	            } catch (IOException e) {
	                //primtamos las excepciones producidas.
	                e.printStackTrace();
	            }
	        }
	    }

	}