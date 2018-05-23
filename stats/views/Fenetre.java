package views;

import java.awt.*;
import javax.swing.*;
import controllers.*;
import java.sql.*;

public class Fenetre extends JFrame {

    private PanneauInformationsRecherche panneauInformationsRecherche;

    public Fenetre(){

	super("Statistiques");

  this.panneauInformationsRecherche = null;

	this.setLayout(new BorderLayout());
	this.setMinimumSize(new Dimension(600,500));
	this.setLocationRelativeTo(null);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

  this.add(new MenuTaux(this));

	this.addWindowListener(new ControleurFenetre());
    }

    public void menuPrincipal(){

      this.clearAll();
      this.add(new MenuTaux(this));
      this.revalidate();
    }

    public void clearAll(){

      this.getContentPane().removeAll();
      this.getContentPane().repaint();
    }

    public PanneauInformationsRecherche getPanneauInformationsRecherche(){

      return this.panneauInformationsRecherche;
    }

    public void setPanneauInformationsRecherche(PanneauInformationsRecherche v){

      this.panneauInformationsRecherche = v;
    }

}
