package views;

import java.awt.*;
import javax.swing.*;
import controllers.*;

public class MenuTaux extends JPanel{

  private Fenetre fenetre;

    public MenuTaux(Fenetre f){

	this.setLayout(new GridLayout(1, 3));
  this.fenetre = f;

  ControleurBoutonsMenuTaux controleur = new ControleurBoutonsMenuTaux(this.fenetre);

  JButton occupationDate = new JButton("Taux occupation ( date )");
  occupationDate.addActionListener(controleur);
	this.add(occupationDate);
  JButton occupationPeriode = new JButton("Taux occupation ( période )");
  occupationPeriode.addActionListener(controleur);
  this.add(occupationPeriode);
  JButton nonPresentation = new JButton("Taux non présentation");
  nonPresentation.addActionListener(controleur);
	this.add(nonPresentation);

    }
}
