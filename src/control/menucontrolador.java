package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.autormodelo;
import modelo.menumodelo;
import vista.autorvista;
import vista.menuprincipal;

public class menucontrolador implements ActionListener{
    menuprincipal vista;
    menumodelo modelo;

    public menucontrolador(menuprincipal vista, menumodelo modelo) {
        this.vista = vista;
        this.modelo = modelo;
        vista.menuventas.addActionListener(this);
        vista.menuclientes.addActionListener(this);
        vista.menupersinales.addActionListener(this);
        vista.menuproductos.addActionListener(this);
        vista.menuusuarios.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object p= e.getSource();
        if (p.equals(vista.menuclientes)) {
            autorvista v=new autorvista();
            
            v.setLocationRelativeTo(null);
            v.setVisible(true);
        }
        
    }
    
}
