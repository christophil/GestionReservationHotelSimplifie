package controllers;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import views.*;
import models.*;
import classes.*;

public class ControleurModifierChambre implements ActionListener{

    private Reservation reservation;
    private PanneauInformationsRecherche panneau;
    private Fenetre fenetre;

    public ControleurModifierChambre(Reservation r, PanneauInformationsRecherche p, Fenetre f){

	     this.reservation = r;
       this.panneau = p;
       this.fenetre = f;
    }

    @Override
    public void actionPerformed(ActionEvent e){

      int chambre = Integer.parseInt(this.reservation.getChambreAllouee());

      if(chambre > 0){

        this.panneau.removeMenuBoutons();
        this.panneau.removeMenuInfos();

        int nombreChambreDisponible = ModelRecherche.getNombreChambreDisponible(this.reservation.getCategorie());

        int[] listeChambre = new int[50];

        listeChambre = ModelRecherche.getListeChambreDisponible(this.reservation.getCategorie());

        int tmp = nombreChambreDisponible;
        int nombreLigne = 1;

        while( (tmp - 10 ) > 0){

          tmp = tmp - 10;
          nombreLigne++;
        }

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(nombreLigne, 10));

        JButton[] boutons  = new JButton[nombreChambreDisponible];

        ControleurBoutonModifierChambre controleurBoutons = new ControleurBoutonModifierChambre(this.reservation, this.fenetre);

        for(int i = 0; i < nombreChambreDisponible; i++){

          boutons[i] = new JButton();
          boutons[i].setText("" + listeChambre[i]);
          boutons[i].addActionListener(controleurBoutons);
          p.add(boutons[i]);

        }

        this.panneau.getPanneauRecherche().modifierBoutonRetour("Retour");
        this.panneau.afficherChambresDisponible(p);

      }
      else{

        AfficherMessage.afficherErreur("Erreur attribution chambre", "Aucune chambre de type " + this.reservation.getCategorie() + " n'est actuellement disponible.");
        this.fenetre.menuPrincipal();
      }

    }
}
