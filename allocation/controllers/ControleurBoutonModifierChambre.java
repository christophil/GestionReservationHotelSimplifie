package controllers;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import views.*;
import models.*;
import classes.*;

/**
* La classe ControleurBoutonModifierChambre est un ActionListener pour le bouton de modification de chambre
*
* @version 1.0
* @author Philemon Christopher
*/

public class ControleurBoutonModifierChambre implements ActionListener{

    private Reservation reservation;
    private Fenetre fenetre;

    public ControleurBoutonModifierChambre(Reservation r, Fenetre f){

	     this.reservation = r;
       this.fenetre = f;
    }

    @Override
    public void actionPerformed(ActionEvent e){

      int numeroChambre = Integer.parseInt(e.getActionCommand());

      ModelRecherche.choisirChambre(this.reservation.getNumeroClient(), numeroChambre, this.reservation.getDebut());

      AfficherMessage.afficherInformation("Confirmation", "La chambre " + e.getActionCommand() + " a bien été attribuée à " + this.reservation.getPrenomClient() + " " + this.reservation.getNomClient());

      this.fenetre.menuPrincipal();
    }
}
