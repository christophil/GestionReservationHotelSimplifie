package views;

import java.awt.*;
import javax.swing.*;
import controllers.*;

public class PanneauTaux extends JPanel{

    private JTextField champsRecherche;
    private JTextField champsNom;
    private JTextField champsPrenom;
    private JButton boutonValider;
    private JButton boutonRetour;
    private JButton boutonAide;
    private Fenetre fenetre;
    private int typeTaux; // 1 = occupation date, 2 = occupation periode, 3 = non présentation
    private PanneauInformationsRecherche panneauInformationsRecherche;
    private JPanel panneauChoixReservation;

    public PanneauTaux(Fenetre f, int tt){

  this.panneauChoixReservation = null;
  this.fenetre = f;
  this.typeTaux = tt;
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

  if(this.typeTaux == 1){

    JPanel menu = new JPanel();
    menu.setLayout(new GridLayout(1, 3));
    menu.add(new JLabel("Date : "));
    menu.add(this.champsRecherche);
    this.boutonValider.addActionListener(new ControleurTaux(this.champsRecherche, null, null, 1, this, this.fenetre));
    menu.add(boutonValider);

    this.add(menu, BorderLayout.NORTH);
  }
  else if(this.typeTaux == 2){

    JPanel menu = new JPanel();
    menu.setLayout(new GridLayout(1, 5));
    menu.add(new JLabel("Début : "));
    menu.add(this.champsNom);
    menu.add(new JLabel("Fin : "));
    menu.add(this.champsPrenom);
    this.boutonValider.addActionListener(new ControleurTaux(null, this.champsNom, this.champsPrenom, 2, this, this.fenetre));
    menu.add(boutonValider);

    this.add(menu, BorderLayout.NORTH);
  }
  else{

    JPanel menu = new JPanel();
    menu.setLayout(new GridLayout(1, 3));
    menu.add(new JLabel("Date : "));
    menu.add(this.champsRecherche);
    this.boutonValider.addActionListener(new ControleurTaux(this.champsRecherche, null, null, 3, this, this.fenetre));
    menu.add(boutonValider);

    this.add(menu, BorderLayout.NORTH);

    /*JPanel menu = new JPanel();
    menu.setLayout(new GridLayout(1, 5));
    menu.add(new JLabel("Nom : "));
    menu.add(this.champsNom);
    menu.add(new JLabel("Prénom : "));
    menu.add(this.champsPrenom);
    this.boutonValider.addActionListener(new ControleurTaux(null, this.champsNom, this.champsPrenom, 3, this, this.fenetre));
    menu.add(boutonValider);

    this.add(menu, BorderLayout.NORTH);
*/
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
