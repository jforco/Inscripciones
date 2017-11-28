package inscripciones;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class conexion {
    public Connection cnx = null;
    
    public Connection obtener() throws SQLException, ClassNotFoundException {
       if (cnx == null) {
          try {
             Class.forName("com.mysql.jdbc.Driver");
             //cnx = DriverManager.getConnection("jdbc:mysql://localhost/inscripcion", "root", "");
             //cnx = DriverManager.getConnection("jdbc:mysql://localhost/inscripcion2", "root", "");
             cnx = DriverManager.getConnection("jdbc:mysql://localhost/inscripcion3", "root", "");
          } catch (SQLException ex) {
             throw new SQLException(ex);
             
          } catch (ClassNotFoundException ex) {
             throw new ClassCastException(ex.getMessage());
          }
       }
       return cnx;
    }
    public void cerrar() throws SQLException {
       if (cnx != null) {
          cnx.close();
       }
    }
    
    public boolean registrar(String nombre, String sexo, String iglesia, String edad, 
            String pago, String telefono, String color) {
        try{
            PreparedStatement consulta;
            Connection conexion = obtener();
            consulta = conexion.prepareStatement("INSERT INTO registro" + 
                       "(nombre, sexo, edad, iglesia, pago, telefono, color) VALUES(?, ?, ?, ?, ?, ?, ?)");
            consulta.setString(1, nombre);
            consulta.setString(2, sexo);
            consulta.setString(3, edad);
            consulta.setString(4, iglesia);
            consulta.setString(5, pago);
            consulta.setString(6, telefono);
            consulta.setString(7, color);
            consulta.executeUpdate();
            conexion.close();
            return true;
        }catch(SQLException ex){
            System.out.println("error al inscribir");
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
            return false; 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
            return false;
        }
    }
    
    

    public ArrayList<String> verDatos(String sexo, String e) {
        ArrayList<colores> lista = new ArrayList<>();       //lista de colores y cantidad
        
        
        int edad = Integer.parseInt(e);
        ArrayList<String> a = new ArrayList<>();            //lista de colores en general
        //cambio segun edad
        if(edad%2==0){
            a.add("Rojo");
            a.add("Amarillo");
            a.add("Verde");
            a.add("Azul");
            //a.add("Celeste");
            //a.add("Naranja");
        }else{
            //a.add("Naranja");
            //a.add("Celeste");
            a.add("Azul");
            a.add("Verde");
            a.add("Amarillo");
            a.add("Rojo");
        }
        
        
        //obtenemos las cantidades de cada color en "lista"
        for(String color:a){
            try {
                PreparedStatement consulta;
                Connection conexion = obtener();
                consulta = conexion.prepareStatement
                ("SELECT COUNT(*) AS cantidad FROM registro WHERE color=? and sexo=? and edad=?" );
                consulta.setString(1,color );
                consulta.setString(2,sexo);
                consulta.setInt(3,edad);
                ResultSet resultado = consulta.executeQuery();
                while(resultado.next()){
                    System.out.println( resultado.getInt("cantidad"));
                    System.out.println(color);
                    int cant = resultado.getInt("cantidad");
                    colores c = new colores(color, cant);
                    lista.add(c);
                }
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //ordenamos segun donde falte
        Collections.sort(lista, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                colores c1 = (colores) o1;
                colores c2 = (colores) o2;
                return new Integer(c1.getCantidad()).compareTo(c2.getCantidad());
            }
        });
        
        //pasamos a una lista para devolver
        a.clear();
        for(colores c: lista){
            a.add(c.getColor());
        }
        return a;
    }
    
    
}
