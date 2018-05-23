package controllers;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import views.*;
import models.*;
import classes.*;

public class ControleurBoutonsMenuTaux implements ActionListener{

    private Fenetre fenetre;

    public ControleurBoutonsMenuTaux(Fenetre f){

       this.fenetre = f;
    }

    @Override
    public void actionPerformed(ActionEvent e){

      String texte = e.getActionCommand();

      if(texte.equals("Taux occupation ( date )")){

        this.fenetre.clearAll();
        this.fenetre.add(new PanneauTaux(this.fenetre, 1));
        this.fenetre.revalidate();
      }
      else if(texte.equals("Taux occupation ( période )")){

        this.fenetre.clearAll();
        this.fenetre.add(new PanneauTaux(this.fenetre, 2));
        this.fenetre.revalidate();
      }
      else{

        this.fenetre.clearAll();
        this.fenetre.add(new PanneauTaux(this.fenetre, 3));
        this.fenetre.revalidate();
      }
    }
}
