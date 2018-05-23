package controllers;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import views.*;
import models.*;
import classes.*;

/**
* La classe ControleurBoutonAide est un ActionListener pour le bouton d'aide
*
* @version 1.0
* @author Philemon Christopher
*/

public class ControleurBoutonAide implements ActionListener{

    private Fenetre fenetre;

    public ControleurBoutonAide(Fenetre f){

       this.fenetre = f;
    }

    @Override
    public void actionPerformed(ActionEvent e){

      AfficherMessage.afficherInformation("Aide", "<html>Pour attribuer une chambre à partir d'une réservation/d'un nom et prénom, il vous suffit de rentrer un numéro de réservation/nom et prénom valide. <br />Une chambre correspondant à la réservation sera alors automatiquement attribuée. Il suffira de cliquer sur <br />le bouton 'Confirmer' pour valider l'attribution. <br />Si vous souhaitez attribuer une autre chambre, il suffira de cliquer sur le bouton 'Modifier chambre' puis de <br />cliquer sur le numéro de chambre souhaité parmi la liste des chambres disponibles.");

    }
}
