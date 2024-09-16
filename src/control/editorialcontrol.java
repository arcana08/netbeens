/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import modelo.editorialmodelo;
import vista.editorialvista;

/**
 *
 * @author Alumno
 */
public class editorialcontrol  implements ActionListener,KeyListener{
    editorialmodelo modelo;
    editorialvista vista;

    public editorialcontrol(editorialmodelo modelo, editorialvista vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.btng.addActionListener(this);
        vista.btnbuscar.addActionListener(this);
        vista.txtfiltro.addKeyListener(this);
        vista.btnaceptar.addActionListener(this);
        vista.btnmodifi.addActionListener(this);
        vista.btneliminar.addActionListener(this);
        vista.btnnuevo.addActionListener(this);
        vista.btncancel.addActionListener(this);
        
    }
    
    
    
 

    @Override
    public void actionPerformed(ActionEvent e) {
        Object p=e.getSource();
       if (p.equals(vista.btng)){
           modelo.setNombre(vista.txtnombre.getText());
           modelo.insertardatos();
           modelo.bloqueoboton(true, false, true, false, false,false);
           modelo.text(false);
           modelo.limpiar();
       }
       if(p.equals(vista.btnbuscar)){
           modelo.mostrarBuscador();
       }
       if(p.equals(vista.btnaceptar)){
           modelo.transferirdatos();
           modelo.bloqueoboton(false, false, false, true, true,true);
           modelo.text(true);
       }
        if (p.equals(vista.btnmodifi)) {
            modelo.setId(vista.txtid.getText());
            modelo.setNombre(vista.txtnombre.getText());
            modelo.modificardatos();
            modelo.bloqueoboton(true, false, true, false, false,false);
            modelo.text(false);
            modelo.limpiar();
        }
        if (p.equals(vista.btneliminar)) {
            int respuesta= JOptionPane.showConfirmDialog(vista, "ELIMINAR?");
            modelo.setId(vista.txtid.getText());
            if (respuesta==0) {
                modelo.eliminardatos();
            }
            modelo.bloqueoboton(true, false, true, false, false,false);
            modelo.limpiar();
            modelo.text(false);
        }
        if (p.equals(vista.btnnuevo)) {
            modelo.bloqueoboton(false, true, false, false, false,true);
            modelo.limpiar();
            modelo.text(true);
        }
        if (p.equals(vista.btncancel)) {
            modelo.bloqueoboton(true, false, true, false, false, false);
            modelo.limpiar();
            modelo.text(false);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Object p=e.getSource();
        if(p.equals(vista.txtfiltro)){
            modelo.cargartabla(vista.txtfiltro.getText());
        }
    }
    
}
