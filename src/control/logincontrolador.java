package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.loginmodelo;
import modelo.menumodelo;


import vista.loginvista;
import vista.menuprincipal;


public class logincontrolador implements ActionListener{
    
    loginmodelo modelo;
    loginvista vista;
    
    

    public logincontrolador(loginmodelo modelo, loginvista vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.btningresar.addActionListener(this);
        
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        Object p= e.getSource();
       
        if (p.equals(vista.btningresar)) {
            modelo.setUsuario(vista.txtusu.getText());
            modelo.setContraseña(vista.txtcontra.getText());
            if (modelo.ingresar()) {
                menuprincipal menu=new menuprincipal();
                menumodelo m=new menumodelo(menu);
                menucontrolador c=new menucontrolador(menu, m);
                menu.setLocationRelativeTo(null);
                menu.setVisible(true);
                menu.txtusuario.setText(modelo.getUsuario());
                menu.txttipo.setText(modelo.getTipo()   );
                menu.txtidu.setText(modelo.getIdusu());
                vista.dispose();
            }else{
                JOptionPane.showMessageDialog(vista, "USUARIO NO VALIDO");
            }
 
            
            
        }
    }
    
}
