package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vista.menuprincipal;

public class loginmodelo {

    private String usuario;
    private String contraseña;
    private String tipo;
    private String idusu;

    Statement st;
    ResultSet rs;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getIdusu() {
        return idusu;
    }

    public void setIdusu(String idusu) {
        this.idusu = idusu;
    }
    

    public boolean ingresar() {

        String sql = "select * from usuarios where usuario='" + usuario + "' and clave='" + contraseña + "' and estado='A'";
        boolean aux = false;
        try {
            st = utilidades.conexion.sta(st);
            rs = st.executeQuery(sql);
            rs.next();
            if (rs.getRow() == 0) {
                aux = false;
            } else {

                aux = true;
                tipo=rs.getString("rol");
                idusu=rs.getString("codigousuario");
                        
            }
            st.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(loginmodelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aux;
    }
}
