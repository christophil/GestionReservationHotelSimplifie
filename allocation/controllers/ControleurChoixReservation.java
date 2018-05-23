package controllers;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import views.*;
import models.*;
import classes.*;

public class ControleurChoixReservation implements ActionListener{

    private Reservation reservation;
    private Fenetre fenetre;
    private PanneauRecherche panneauRecherche;

    public ControleurChoixReservation(Reservation r, Fenetre f, PanneauRecherche pr){

	     this.reservation = r;
       this.fenetre = f;
       this.panneauRecherche = pr;
    }

    @Override
    public void actionPerformed(ActionEvent e){

      this.panneauRecherche.removePanneauChoixReservation();
      PanneauInformationsRecherche panneauInformationsRecherche = new PanneauInformationsRecherche(this.reservation, this.fenetre, this.panneauRecherche);
      this.panneauRecherche.addPanneauInformationsRecherche(panneauInformationsRecherche);
      this.fenetre.setPanneauInformationsRecherche(panneauInformationsRecherche);
    }
}
