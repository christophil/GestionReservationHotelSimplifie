package controllers;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import views.*;
import models.*;
import classes.*;

public class ControleurBoutonsMenuRechercheReservation implements ActionListener{

    private Fenetre fenetre;

    public ControleurBoutonsMenuRechercheReservation(Fenetre f){

       this.fenetre = f;
    }

    @Override
    public void actionPerformed(ActionEvent e){

      String texte = e.getActionCommand();

      if(texte.equals("Recherche par numéro reservation")){

        this.fenetre.clearAll();
        this.fenetre.add(new PanneauRecherche(this.fenetre, true));
        this.fenetre.revalidate();
      }
      else{

        this.fenetre.clearAll();
        this.fenetre.add(new PanneauRecherche(this.fenetre, false));
        this.fenetre.revalidate();
      }
    }
}
