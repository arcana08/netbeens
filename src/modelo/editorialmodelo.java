/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vista.editorialvista;

/**
 *
 * @author Alumno
 */
public class editorialmodelo {

    private String id;
    private String nombre;
    private String apellido;
    Statement st = null;
    ResultSet rs = null;
    DefaultTableModel modelautor;
    editorialvista vista;//hacer visibles los elementos del jform

    public editorialmodelo(editorialvista vista) {
        this.vista = vista;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    
    
    

    public void insertardatos() {
        String sql = "insert into editoriales(nombre) values('" + nombre + "')";
        try {
            st = utilidades.conexion.sta(st);
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "GURDADO");
        } catch (SQLException ex) {
            Logger.getLogger(editorialmodelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void inicio() {
        modelautor = (DefaultTableModel) vista.tablaautor.getModel();

    }

    public void cargartabla(String filtro) {
        String sql = "select * from editoriales where nombre like'" + filtro + "%'";
        modelautor.setRowCount(0);
        try {
            st = utilidades.conexion.sta(st);//abrir conexion
            rs = st.executeQuery(sql);
            while (rs.next()) {
                modelautor.addRow(new Object[]{
                    rs.getString("codigoeditorial"),
                    rs.getString("nombre"),
                });
            }
            vista.tablaautor.setModel(modelautor);
            st.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(editorialmodelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void mostrarBuscador() {
        vista.buscadorautor.setSize(380, 330);//tamaño
        vista.buscadorautor.setLocationRelativeTo(vista);//center
        vista.buscadorautor.setVisible(true);
        cargartabla("");
    }

    public void transferirdatos() {
        int filaseleccion = vista.tablaautor.getSelectedRow();
        vista.txtid.setText(vista.tablaautor.getValueAt(filaseleccion, 0).toString());
        vista.txtnombre.setText(vista.tablaautor.getValueAt(filaseleccion, 1).toString());
        vista.buscadorautor.setVisible(false);

    }

    public void modificardatos() {

        String sql = "update editoriales set nombre='" + nombre + "' where codigoeditorial=" + id + "";
        try {
            st = utilidades.conexion.sta(st);
            st.executeUpdate(sql);
            st.close();
            JOptionPane.showMessageDialog(vista, "MODIFICADO");
        } catch (SQLException ex) {
            Logger.getLogger(editorialmodelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminardatos(){
        String sql="delete from editoriales where codigoeditorial='"+id+"'";
        
        try {
            st=utilidades.conexion.sta(st);
            st.executeUpdate(sql);
            st.close();
            JOptionPane.showMessageDialog(vista, "ELIMINADO");
                    } catch (SQLException ex) {
            Logger.getLogger(editorialmodelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void bloqueoboton(boolean n,boolean g,boolean b,boolean m,boolean e,boolean c){
        vista.btnnuevo.setEnabled(n);
        vista.btng.setEnabled(g);
        vista.btnbuscar.setEnabled(b);
        vista.btnmodifi.setEnabled(m);
        vista.btneliminar.setEnabled(e);
        vista.btncancel.setEnabled(c);
    }
    public void limpiar(){
        vista.txtid.setText("");
        vista.txtnombre.setText("");
        
    }
    public void text(boolean p){
        vista.txtnombre.setEnabled(p);
        
    }

}
