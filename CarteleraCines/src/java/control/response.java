package control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class response extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
        
            // Recuperar datos del formulario
            // Habilitar conexion con BBDD
            // Realizar la operacion con la BBDD
            // cerrra conexion con la BBDD 
            String peli = request.getParameter("id_pelicula");
            ManejadorBaseDeDatos manejador = new ManejadorBaseDeDatos();
            String[] nombre_pelicula = manejador.obtenerDatosDePelicula(peli);
            
            
            // actualizar las etquetas "pendiente" del codigo inferior
            String pendiente = "actualizar";
            out.println("<HTML>");
            out.println("<HEAD> <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
            out.println(" <TITLE> Cartelera cinematografica </TITLE>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"estilo.css\"> </HEAD>");
            out.println("<BODY>");
            out.println("<table border=\"0\">");
            out.println("<tr>");
            out.println("<td><big><strong>Nombre de la pelicula:</strong></big></td>");
            out.println("<td><span style=\"font-size:large; font-style:italic;\">" + nombre_pelicula[2] + "</span></td>");
            out.println("</tr> ");
            out.println("<tr>");
            out.println("<td><strong>Genero:</strong></td>");
            out.println("<td><span style=\"font-size:large; font-style: italic;\">" + nombre_pelicula[3] + "</span></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td><strong>Cine:</strong></td>");
            out.println("<td><strong>" + nombre_pelicula[0] + "</strong>");
            out.println("</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td><strong>Localizacion:</strong></td>");
            out.println("<td>" + nombre_pelicula[1] + "</td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</BODY>");
            out.println("</HTML>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}