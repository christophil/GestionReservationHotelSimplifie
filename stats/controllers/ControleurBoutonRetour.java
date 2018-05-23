package controllers;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import views.*;
import models.*;
import classes.*;

public class ControleurBoutonRetour implements ActionListener{

    private Fenetre fenetre;

    public ControleurBoutonRetour(Fenetre f){

       this.fenetre = f;
    }

    @Override
    public void actionPerformed(ActionEvent e){

      String bouton = e.getActionCommand();

      if(bouton.equals("Menu Principal")){

        this.fenetre.menuPrincipal();
      }
    }
}
