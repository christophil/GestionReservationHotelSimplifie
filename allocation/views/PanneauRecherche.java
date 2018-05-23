package views;

import java.awt.*;
import javax.swing.*;
import controllers.*;

public class PanneauRecherche extends JPanel{

    private JTextField champsRecherche;
    private JTextField champsNom;
    private JTextField champsPrenom;
    private JButton boutonValider;
    private JButton boutonRetour;
    private JButton boutonAide;
    private Fenetre fenetre;
    private boolean reference;
    private PanneauInformationsRecherche panneauInformationsRecherche;
    private JPanel panneauChoixReservation;

    public PanneauRecherche(Fenetre f, boolean r){

  this.panneauChoixReservation = null;
  this.fenetre = f;
  this.reference = r;
  this.panneauInformationsRecherche = new PanneauInformationsRecherche();
  this.add(panneauInformationsRecherche, BorderLayout.CENTER);
	this.setLayout(new BorderLayout());
	this.champsRecherche = new JTextField();
  this.champsNom = new JTextField();
  this.champsPrenom = new JTextField();
	this.boutonValider = new JButton("Valider");
	this.boutonRetour = new JButton("Menu Principal");
  this.boutonRetour.addActionListener(new ControleurBoutonRetour(this.fenetre));
	this.boutonAide = new JButton("Aide");
  this.boutonAide.addActionListener(new ControleurBoutonAide(this.fenetre));

  if(this.reference){

    JPanel menu = new JPanel();
    menu.setLayout(new GridLayout(1, 3));
    menu.add(new JLabel("Reference : "));
    menu.add(this.champsRecherche);
    this.boutonValider.addActionListener(new ControleurRecherche(this.champsRecherche, null, null, true, this, this.fenetre));
    menu.add(boutonValider);

    this.add(menu, BorderLayout.NORTH);
  }
  else{

    JPanel menu = new JPanel();
    menu.setLayout(new GridLayout(1, 5));
    menu.add(new JLabel("Nom : "));
    menu.add(this.champsNom);
    menu.add(new JLabel("Prénom : "));
    menu.add(this.champsPrenom);
    this.boutonValider.addActionListener(new ControleurRecherche(null, this.champsNom, this.champsPrenom, true, this, this.fenetre));
    menu.add(boutonValider);

    this.add(menu, BorderLayout.NORTH);

  }

	JPanel menuNavigation = new JPanel();
	menuNavigation.setLayout(new GridLayout(1,2));
	menuNavigation.add(this.boutonAide);
	menuNavigation.add(this.boutonRetour);

	this.add(menuNavigation, BorderLayout.SOUTH);

    }

    public void modifierBoutonRetour(String v){

      this.boutonRetour.setText(v);
      this.revalidate();
    }

    public void addPanneauInformationsRecherche(PanneauInformationsRecherche p){

      this.remove(panneauInformationsRecherche);
      this.panneauInformationsRecherche = p;
      this.add(p, BorderLayout.CENTER);
      this.revalidate();
      this.repaint();
    }

    public void addPanneauChoixReservation(JPanel p){

      this.panneauChoixReservation = p;
      this.add(p, BorderLayout.CENTER);
      this.revalidate();
      this.repaint();
    }

    public void removePanneauChoixReservation(){
      this.remove(this.panneauChoixReservation);
      this.revalidate();
      this.repaint();
    }
}
