package models;

import java.sql.*;

// Singleton de la connexion a la BDD perso
public class ConnexionBDDPerso{

    private static Connection connexion = null;

    private static void constructeur(){

	try{

	    connexion = DriverManager.getConnection("");

	}catch(SQLException e){

	    System.err.println("Erreur connexion BDD : " + e.getMessage());
	}

    }

    public static Connection getInstance(){

	if(connexion == null){

	    constructeur();
	    return connexion;
	}
	else{

	    return connexion;
	}
    }

    public static void fermerConnexion(){

	if(connexion != null){

	    try{

		connexion.close();

	    }catch(SQLException e2){

		System.err.println("Erreur close connexion : " +e2.getMessage());
	    }
	}
    }
}
