package controllers;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import views.*;
import models.*;
import classes.*;

public class ControleurTaux implements ActionListener{

    private JTextField champsRecherche;
    private JTextField champsNom;
    private JTextField champsPrenom;
    private String regex;
    private JLabel labelTaux;
    private int typeTaux;
    private PanneauTaux panneauTaux;
    private Fenetre fenetre;

    public ControleurTaux(JTextField cr, JTextField cn, JTextField cp, int tt, PanneauTaux pt, Fenetre f){

	this.champsRecherche = cr;
  this.champsNom = cn;
  this.champsPrenom = cp;
	this.typeTaux = tt;
	this.panneauTaux = pt;
  this.fenetre = f;

	this.regex = "\\d\\d\\d\\d-\\d\\d-\\d\\d";

    }

    @Override
    public void actionPerformed(ActionEvent e){

      if((this.champsRecherche != null) && (this.typeTaux == 1)){

      	String input = this.champsRecherche.getText();

      	if(input.matches(this.regex)){

          int nombreChambreOccupees = ModelTaux.getNombreChambresOccupees(input);

          PanneauInformationsRecherche panneauInformationsRecherche = new PanneauInformationsRecherche(nombreChambreOccupees, input, null, this.fenetre, this.panneauTaux, 1);
          this.panneauTaux.addPanneauInformationsRecherche(panneauInformationsRecherche);
          this.fenetre.setPanneauInformationsRecherche(panneauInformationsRecherche);

      	}
      	else{

      	        AfficherMessage.afficherErreur("Erreur date", "Date invalide ! Réessayez ! Format valide : 0000-00-00");
      	}

    }
    else if((this.champsRecherche != null) && (this.typeTaux == 3)){

      String input = this.champsRecherche.getText();

      if(input.matches(this.regex)){

        int nombreClients = ModelTaux.getNombreClients(input);

        if(nombreClients != 0){

          int[] numeroClients = new int[nombreClients];

          numeroClients = ModelTaux.getNumeroClients(nombreClients, input);

          int absences = ModelTaux.getNombreAbsences(input, numeroClients);

          PanneauInformationsRecherche panneauInformationsRecherche = new PanneauInformationsRecherche(absences, input, null, this.fenetre, this.panneauTaux, 3);
          this.panneauTaux.addPanneauInformationsRecherche(panneauInformationsRecherche);
          this.fenetre.setPanneauInformationsRecherche(panneauInformationsRecherche);

        }
        else{

          PanneauInformationsRecherche panneauInformationsRecherche = new PanneauInformationsRecherche(nombreClients, input, null, this.fenetre, this.panneauTaux, 3);
          this.panneauTaux.addPanneauInformationsRecherche(panneauInformationsRecherche);
          this.fenetre.setPanneauInformationsRecherche(panneauInformationsRecherche);

        }

      }
      else{

    	        AfficherMessage.afficherErreur("Erreur date", "Date invalide ! Réessayez ! Format valide : 0000-00-00");
    	}
    }
    else{

      String debut = this.champsNom.getText();
      String fin = this.champsPrenom.getText();

      if((debut.matches(this.regex)) && (fin.matches(this.regex))){

        int nombreChambreOccupees = ModelTaux.getNombreChambresOccupeesPeriode(debut, fin);

        PanneauInformationsRecherche panneauInformationsRecherche = new PanneauInformationsRecherche(nombreChambreOccupees, debut, fin, this.fenetre, this.panneauTaux, 2);
        this.panneauTaux.addPanneauInformationsRecherche(panneauInformationsRecherche);
        this.fenetre.setPanneauInformationsRecherche(panneauInformationsRecherche);

      }
      else{

        AfficherMessage.afficherErreur("Erreur date", "Les deux dates doivent être valides ! Réessayez ! Format valide : 0000-00-00");
      }
    }
  }
}
