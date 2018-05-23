package controllers;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import views.*;
import models.*;
import classes.*;

public class ControleurBoutonAide implements ActionListener{

    private Fenetre fenetre;

    public ControleurBoutonAide(Fenetre f){

       this.fenetre = f;
    }

    @Override
    public void actionPerformed(ActionEvent e){

      AfficherMessage.afficherInformation("Aide", "<html>Pour obtenir les statistiques, il vous suffit de choisir le type d'informations<br/>que vous desirez dans le menu principal, de rentrer les ou les dates qui vous intéressent<br />et vous obtiendrez un graphique legendé contenant ces derniers.");

    }
}
