package views;

import java.awt.*;
import javax.swing.*;

import classes.*;
import controllers.*;

public class PanneauInformationsRecherche extends JPanel{

    private JLabel reference;
    private JLabel debut;
    private JLabel nuits;
    private JLabel categorie;
    private JLabel client;
    private JLabel chambreDisponible;
    private JPanel menuInfos;
    private JPanel menuBoutons;
    private Fenetre fenetre;
    private PanneauRecherche panneauRecherche;
    private JPanel chambresDisponibles;
    private JPanel panneauInformationsRecherche;

    public PanneauInformationsRecherche(){

    }
    
    public PanneauInformationsRecherche(Reservation r, Fenetre f, PanneauRecherche pr){

	this.setLayout(new BorderLayout());
  this.fenetre = f;
  this.panneauRecherche = pr;
  this.chambresDisponibles = null;
  this.panneauInformationsRecherche = new JPanel();
  this.panneauInformationsRecherche.setLayout(new BorderLayout());

	this.reference = new JLabel(" Réference : " + r.getReference());
	this.debut = new JLabel(" Date de début : " + r.getDebut());
	this.nuits = new JLabel(" Nombre de nuits : " + r.getNuits());
	this.categorie = new JLabel(" Catégorie de la chambre : " + r.getCategorie());
	this.client = new JLabel(" Nom client : " + r.getPrenomClient() + " " + r.getNomClient());
	this.chambreDisponible = new JLabel("Chambre disponible attribuée : " + r.getChambreAllouee());

	this.menuInfos = new JPanel();
	menuInfos.setLayout(new GridLayout(7, 1));
	menuInfos.add(new JLabel("--Informations sur la réservation--"));
	menuInfos.add(this.reference);
	menuInfos.add(this.debut);
	menuInfos.add(this.nuits);
	menuInfos.add(this.categorie);
	menuInfos.add(this.client);
	menuInfos.add(this.chambreDisponible);

	this.panneauInformationsRecherche.add(menuInfos, BorderLayout.CENTER);

	this.menuBoutons = new JPanel();
	menuBoutons.setLayout(new GridLayout(2,1));
  JButton confirmer = new JButton("Confirmer");
  confirmer.addActionListener(new ControleurConfirmerReservation(r, this.fenetre));
  confirmer.setBackground(Color.GREEN);
  confirmer.setOpaque(true);
	menuBoutons.add(confirmer);

  JButton modifier = new JButton("Modifier Chambre");
  modifier.addActionListener(new ControleurModifierChambre(r, this, this.fenetre));
  modifier.setBackground(Color.ORANGE);
  modifier.setOpaque(true);
	menuBoutons.add(modifier);

	this.panneauInformationsRecherche.add(menuBoutons, BorderLayout.EAST);

  this.add(panneauInformationsRecherche);
    }

    public void removeMenuInfos(){

      this.remove(this.menuInfos);
      this.revalidate();
    }

    public void removeMenuBoutons(){

      this.remove(this.menuBoutons);
      this.revalidate();
    }

    public PanneauRecherche getPanneauRecherche(){

      return this.panneauRecherche;
    }

    public void afficherChambresDisponible(JPanel p){

      this.chambresDisponibles = p;
      this.remove(this.panneauInformationsRecherche);
      this.add(this.chambresDisponibles, BorderLayout.CENTER);
      this.revalidate();
    }

    public void supprimerChambresDisponible(){

      this.remove(this.chambresDisponibles);
      this.add(this.panneauInformationsRecherche, BorderLayout.CENTER);
      this.revalidate();
      this.repaint();
      this.chambresDisponibles = null;
    }
}
