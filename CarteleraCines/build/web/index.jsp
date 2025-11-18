<%-- 
    Document   : index
    Created on : 18-nov-2025, 9:57:34
    Author     : alval
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="estilo.css"> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página web PRSyS</title>
    </head>
    
<%@page import="java.util.ArrayList"%> 
<%@page import="control.ManejadorBaseDeDatos"%>
    <body>
        
         <% 
            ManejadorBaseDeDatos manejador = new ManejadorBaseDeDatos(); 
            ArrayList<String> lista = manejador.obtenerPeliculas(); 
        %>
        <h1>Aplicación web PRSyS</h1>
        <table border="0">
            <thead>
                <tr>
                    <th>Esta aplicación nos informará de películas</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Seleccione una de las películas</td>
                </tr>
                <tr>
                    <td><form action="response">
                            <strong> Seleccione una película </strong><br>
                            <select name="id_pelicula">
                                <%  
            for (int i=0; i<lista.size(); i++) { 
                 String temp = lista.get(i); 
                                %>
                                <option><%  
            out.println(temp + "<br>");                   
       %></option> <%  
           } 
           manejador.cerrar(); 
      %>
                            </select><br>
                            <input type="submit" value="enviar" name="enviar" />
                        </form></td>
                </tr>
            </tbody>
        </table>

        
    </body>
</html>
