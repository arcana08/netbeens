/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Alumno
 */
public class conexion {
    static Connection conn=null;
    static Statement st=null;
    static String bd="bibliotecabd";
    static String user="root";
    static String clave="";
    static String url="jdbc:mysql://localhost:3307/"+bd;
    
    
    public static Connection Enlace(Connection conn) throws SQLException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection(url,user,clave);
            System.out.println("conexion exitosa");
        }catch(Exception e){
            System.out.println("conexion fallida"+e);
        }
        return conn;
    }
    
    public static Statement sta(Statement st) throws SQLException{
        conn=Enlace(conn);
        st=conn.createStatement();
        return st;
    }
    
}
