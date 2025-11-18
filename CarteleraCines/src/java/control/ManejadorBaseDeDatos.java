/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author alval
 */
public class ManejadorBaseDeDatos {
    
    private Connection conexion;
    private PreparedStatement st;
    private ResultSet resultado;
    
    public ManejadorBaseDeDatos() { 
        try { 
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            String url = "jdbc:mysql://localhost:3306/bd_peliculas?useSSL=false"; 
            conexion = java.sql.DriverManager.getConnection(url,"root","root"); 
            System.out.println(">>>> Conexión a la BBDD realizada."); 
        } catch (ClassNotFoundException | SQLException ex) {  
            System.out.println(">>>> Error al conectar con la BBDD: " + ex.getMessage()); 
    } 
 } 
    
    public ArrayList<String> obtenerPeliculas() { 
        ArrayList<String> lista = new ArrayList(); 
        try { 
            String sql = "SELECT id_pelicula,titulo FROM peliculas"; 
            st = conexion.prepareStatement(sql); 
            resultado = st.executeQuery();             
            while (resultado.next()) { 
                lista.add(resultado.getString("titulo")); 
            } 
            return lista; 
        } catch (SQLException ex) { 
            System.out.println(">>>> Error obtenerPeliculas(): " + ex.getMessage());         
        } 
        return null; 
    }
    
    public String[] obtenerDatosDePelicula (String nombre) { 
        String[] datos = new String [4]; 
        try { 
            String sql = "SELECT * FROM cines, peliculas WHERE cines.id_cine=peliculas.id_cine AND peliculas.titulo =?"; 
            st = conexion.prepareStatement(sql); 
            st.setString(1, nombre); 
            resultado = st.executeQuery();          
            resultado.next(); 
            datos[0] = resultado.getString("nombre"); 
            datos[1] = resultado.getString("ubicacion"); 
            datos[2] = resultado.getString("titulo"); 
            datos[3] = resultado.getString("genero"); 
            return datos; 
        } catch (SQLException ex) { 
            System.out.println(">>>> Error obtenerDatosDePelicula(): " + ex.getMessage());         
        } 
        return null; 
}
    
      public void cerrar() { 
        try { 
            if (resultado != null) 
                  resultado.close(); 
            st.close(); 
            conexion.close(); 
        } catch (SQLException ex) { } 
    }
}
