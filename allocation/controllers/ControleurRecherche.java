package controllers;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import views.*;
import models.*;
import classes.*;

public class ControleurRecherche implements ActionListener{

    private JTextField champsRecherche;
    private JTextField champsNom;
    private JTextField champsPrenom;
    private String regex;
    private JLabel labelTaux;
    private Boolean reference;
    private PanneauRecherche panneauRecherche;
    private Fenetre fenetre;

    public ControleurRecherche(JTextField cr, JTextField cn, JTextField cp, Boolean r, PanneauRecherche pr, Fenetre f){

	this.champsRecherche = cr;
  this.champsNom = cn;
  this.champsPrenom = cp;
	this.reference = r;
	this.panneauRecherche = pr;
  this.fenetre = f;

	if(this.reference){

	    this.regex = "\\d\\d\\d\\d-\\d\\d\\d\\d-[A-Z][A-Z][A-Z][A-Z]";
	}
	else{

	}
    }

    @Override
    public void actionPerformed(ActionEvent e){

      if(this.champsRecherche != null){

      	String input = this.champsRecherche.getText();

      	if(input.matches(this.regex)){

      	    Reservation reservation = ModelRecherche.getReservationReference(input);

            if(reservation.getDebut() != null){

              PanneauInformationsRecherche panneauInformationsRecherche = new PanneauInformationsRecherche(reservation, this.fenetre, this.panneauRecherche);
        	    this.panneauRecherche.addPanneauInformationsRecherche(panneauInformationsRecherche);
              this.fenetre.setPanneauInformationsRecherche(panneauInformationsRecherche);

            }
            else{

              AfficherMessage.afficherErreur("Réservation introuvable", "Aucune réservation ayant pour référence " + this.champsRecherche.getText() + " n'a été trouvée.");
            }
      	}
      	else{

      	        AfficherMessage.afficherErreur("Erreur reference", "Reference invalide ! Réessayez ! Format valide : 0000-0000-AAAA");
      	}

    }
    else{

      int numeroClient = ModelRecherche.getNumeroClient(this.champsNom.getText(), this.champsPrenom.getText());

      if(numeroClient > 0){

        int nombreReservation = ModelRecherche.getNombreReservation(numeroClient);

        if(nombreReservation > 0){

          Reservation[] reservations = new Reservation[nombreReservation];

          reservations = ModelRecherche.getReservationsNumero(numeroClient, nombreReservation, this.champsNom.getText(), this.champsPrenom.getText());

          JPanel panneau = new JPanel();

          int ligne = nombreReservation / 2;

          if((nombreReservation % 2) > 0){

            ligne++;
          }

          panneau.setLayout(new GridLayout(ligne, 2));
          for(int i = 0; i<nombreReservation; i++){

            JButton bouton = new JButton("<html>Reservation " + reservations[i].getReference() + "<br />de type " + reservations[i].getCategorie());
            bouton.addActionListener(new ControleurChoixReservation(reservations[i], this.fenetre, this.panneauRecherche));
            panneau.add(bouton);
          }

          this.panneauRecherche.addPanneauChoixReservation(panneau);
        }
        else{

          AfficherMessage.afficherErreur("Réservation introuvable", "Aucune réservation au nom de " + this.champsPrenom.getText() + " " + this.champsNom.getText());
        }

      }
      else{

        AfficherMessage.afficherErreur("Client introuvable", "<html>Le client n'a pas été trouvé.<br />Vérifiez avoir bien renseigné le nom et le prénom.");
      }

    }

  }
}
