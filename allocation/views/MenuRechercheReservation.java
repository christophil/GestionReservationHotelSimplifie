package views;

import java.awt.*;
import javax.swing.*;
import controllers.*;

public class MenuRechercheReservation extends JPanel{

  private Fenetre fenetre;

    public MenuRechercheReservation(Fenetre f){

	this.setLayout(new GridLayout(1, 2));
  this.fenetre = f;

  ControleurBoutonsMenuRechercheReservation controleur = new ControleurBoutonsMenuRechercheReservation(this.fenetre);

  JButton reservation = new JButton("Recherche par numéro reservation");
  reservation.addActionListener(controleur);
	this.add(reservation);
  JButton client = new JButton("Recherche par informations Client");
  client.addActionListener(controleur);
	this.add(client);

    }
}
