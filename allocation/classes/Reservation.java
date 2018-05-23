package classes;

/**
* La classe Reservation sert d'interface pour gérer les reservations
*
* @version 1.0
* @author Philemon Christopher
*/

public class Reservation{

    private String reference;
    private String debut;
    private String nuits;
    private String categorie;
    private String nomClient;
    private String prenomClient;
    private int numeroClient;
    private String chambreAllouee;

    public Reservation(){

    }

    public Reservation(String r, String d, String n, String c, String nc, String pc, String ca, int numC){

	this.reference = r;
	this.debut = d;
	this.nuits = n;
	this.categorie = c;
	this.nomClient = nc;
	this.prenomClient = pc;
	this.chambreAllouee = ca;
  this.numeroClient = numC;

    }

    public int getNumeroClient(){

      return this.numeroClient;
    }
    public String getChambreAllouee(){

	return this.chambreAllouee;
    }

    public String getReference(){

	return this.reference;
    }

    public String getDebut(){

	return this.debut;
    }

    public String getNuits(){

	return this.nuits;
    }

    public String getCategorie(){

	return this.categorie;
    }

    public String getNomClient(){

	return this.nomClient;
    }

    public String getPrenomClient(){

	return this.prenomClient;
    }

    public void setReference(String v){

	this.reference = v;
    }

    public void setDebut(String v){

	this.debut = v;
    }

    public void setNuits(String v){

	this.nuits = v;
    }

    public void setCategorie(String v){

	this.categorie = v;
    }

    public void setNomClient(String v){

	this.nomClient = v;
    }

    public void setPrenomClient(String v){

	this.prenomClient = v;
    }

    public void setChambreAllouee(String v){

	this.chambreAllouee = v;
    }

    public void setNumeroClient(int v){

      this.numeroClient = v;
    }
}
