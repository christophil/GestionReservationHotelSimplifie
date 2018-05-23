package controllers;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import views.*;
import models.*;
import classes.*;

public class ControleurConfirmerReservation implements ActionListener{

    private Reservation reservation;
    private Fenetre fenetre;

    public ControleurConfirmerReservation(Reservation r, Fenetre f){

	     this.reservation = r;
       this.fenetre = f;
    }

    @Override
    public void actionPerformed(ActionEvent e){

      int chambre = Integer.parseInt(this.reservation.getChambreAllouee());

      if(chambre > 0){

        int numeroChambre = Integer.parseInt(this.reservation.getChambreAllouee());

        ModelRecherche.choisirChambre(this.reservation.getNumeroClient(), numeroChambre, this.reservation.getDebut());

        AfficherMessage.afficherInformation("Confirmation", "La chambre " + this.reservation.getChambreAllouee() + " a bien été attribuée à " + this.reservation.getPrenomClient() + " " + this.reservation.getNomClient());

        this.fenetre.menuPrincipal();
      }
      else{

        AfficherMessage.afficherErreur("Erreur attribution chambre", "Aucune chambre de type " + this.reservation.getCategorie() + " n'est actuellement disponible.");
        this.fenetre.menuPrincipal();
      }

    }
}
