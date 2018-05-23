package controllers;

import models.*;

import java.awt.event.*;

public class ControleurFenetre implements WindowListener{

    public void windowClosed(WindowEvent e){
    }

    public void windowActivated(WindowEvent e){
    }

    public void windowClosing(WindowEvent e){

	ConnexionBDDProjet.fermerConnexion();
	ConnexionBDDPerso.fermerConnexion();
    }

    public void windowDeactivated(WindowEvent e){
    }

    public void windowDeiconified(WindowEvent e){
    }

    public void windowIconified(WindowEvent e){
    }

    public void windowOpened(WindowEvent e){
    }

}
