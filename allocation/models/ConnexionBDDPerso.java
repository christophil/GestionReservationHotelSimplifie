package models;

import java.sql.*;

/**
* La classe ConnexionBDDPerso est un singleton qui represente la connexion a la BDD personnelle
*
* @version 1.0
* @author Philemon Christopher
*/

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
