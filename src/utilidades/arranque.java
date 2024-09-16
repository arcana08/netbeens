package utilidades;

import control.logincontrolador;
import modelo.loginmodelo;
import vista.loginvista;

public class arranque {

    public static void main(String[] args) {
        loginvista v=new loginvista();
        loginmodelo m=new loginmodelo();
        logincontrolador c=new logincontrolador(m, v);
        v.setLocationRelativeTo(null);
        v.setVisible(true);
    }
    
}
