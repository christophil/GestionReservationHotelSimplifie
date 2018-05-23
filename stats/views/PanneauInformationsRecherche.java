package views;

import java.awt.*;
import javax.swing.*;

import classes.*;
import controllers.*;
import models.*;

public class PanneauInformationsRecherche extends JPanel{

    private JPanel menuInfos;
    private JPanel menuBoutons;
    private Fenetre fenetre;
    private PanneauTaux panneauTaux;
    private JPanel panneauInformationsRecherche;

    public PanneauInformationsRecherche(){

    }

    public PanneauInformationsRecherche(int nombreChambreOccupees, String date, String dateFin, Fenetre f, PanneauTaux pt, int type){

	this.setLayout(new BorderLayout());
  this.fenetre = f;
  this.panneauTaux = pt;
  this.panneauInformationsRecherche = new JPanel();
  this.panneauInformationsRecherche.setLayout(new BorderLayout());

  if(type == 1){

    this.panneauInformationsRecherche.add(new Camembert((int) (nombreChambreOccupees * 3.6) ));

    double nco = (double) nombreChambreOccupees;
    this.panneauInformationsRecherche.add(new JLabel("<html>" + nco/100 + " % de chambre(s) occupée(s) ( rouge ) le " + date + "<br />soit " + nombreChambreOccupees + " sur 100"), BorderLayout.SOUTH);

  }

  if(type == 2){

    int nombreJours = ModelTaux.getNombreJoursEntreDates(date, dateFin);
    double nco = (double) nombreChambreOccupees;
    this.panneauInformationsRecherche.add(new Camembert((int) ((nombreChambreOccupees * 3.6)/nombreJours) ));
    this.panneauInformationsRecherche.add(new JLabel("<html>" + nombreChambreOccupees + " chambre(s) occupée(s) ( rouge ) sur les " + 100 * nombreJours + " <br/>chambres disponibles entre le " + date + " et le " + dateFin + "<br /> soit " + nco / ( 100 * nombreJours ) + "%"), BorderLayout.SOUTH);

  }

  if(type == 3){

    int reservations = ModelTaux.getNombreReservations(date);
    this.panneauInformationsRecherche.add(new Camembert((int) (nombreChambreOccupees * (360/reservations)) ));
    double presentations = (double) reservations - (double) nombreChambreOccupees;
    this.panneauInformationsRecherche.add(new JLabel("<html>" + (reservations - nombreChambreOccupees) + " presentation(s) ( vert ) sur " + reservations + " reservation(s) le " + date + "<br /> soit " + (presentations / reservations) + "%"), BorderLayout.SOUTH);

  }



  this.add(panneauInformationsRecherche);
    }


    public PanneauTaux getPanneauTaux(){

      return this.panneauTaux;
    }

}
