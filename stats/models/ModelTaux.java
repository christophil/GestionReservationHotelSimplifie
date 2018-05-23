package models;

import java.sql.*;
import classes.*;

public class ModelTaux{

  public static int getNombreAbsences(String date, int[] numeroClients){

      int resultat = 0;
      int presences = 0;
      int i = 0;

      while(i<numeroClients.length){

        try{

          PreparedStatement requete = ConnexionBDDPerso.getInstance().prepareStatement("SELECT COUNT(*) FROM historique WHERE date = ? AND client = ?");
          requete.setString(1, date);
          requete.setInt(2, numeroClients[i]);

          try{

            ResultSet nombreReservation = requete.executeQuery();

            nombreReservation.next();

            presences += nombreReservation.getInt(1);

            try{

              nombreReservation.close();
              requete.close();

              i++;

            }catch(SQLException e69){

              System.err.println("Erreur close getNumeroClient : " + e69.getMessage());
            }

          }catch(SQLException e70){

            System.err.println("Erreur execute getNumeroClient : " + e70.getMessage());
          }

        }catch(SQLException e71){

          System.err.println("Erreur requete getNumeroClient : " + e71.getMessage());
        }
      }

      resultat = ModelTaux.getNombreReservations(date) - presences;

      return resultat;
  }

  public static int[] getNumeroClients(int nombreClients, String date){

      int[] resultat = new int[nombreClients];

      for(int i = 0; i<nombreClients; i++){

        resultat[i] = 0;
      }

      try{

        PreparedStatement requete = ConnexionBDDProjet.getInstance().prepareStatement("SELECT DISTINCT client FROM Reservation WHERE debut = ?");
        requete.setString(1, date);

        try{

          ResultSet numeroClient = requete.executeQuery();

          int j = 0;

          while(numeroClient.next()){

            resultat[j] = numeroClient.getInt(1);

            j++;
          }

          try{

            numeroClient.close();
            requete.close();

          }catch(SQLException e68){

            System.err.println("Erreur close getNumeroClient : " + e68.getMessage());
          }

        }catch(SQLException e67){

          System.err.println("Erreur execute getNumeroClient : " + e67.getMessage());
        }

      }catch(SQLException e66){

        System.err.println("Erreur requete getNumeroClient : " + e66.getMessage());
      }

      return resultat;
  }

  public static int getNombreClients(String date){

      int resultat = 0;

      try{

        PreparedStatement requete = ConnexionBDDProjet.getInstance().prepareStatement("SELECT COUNT(DISTINCT client) FROM Reservation WHERE debut = ?");
        requete.setString(1, date);

        try{

          ResultSet nombreReservation = requete.executeQuery();

          nombreReservation.next();

          resultat = nombreReservation.getInt(1);

          try{

            nombreReservation.close();
            requete.close();

          }catch(SQLException e69){

            System.err.println("Erreur close getNumeroClient : " + e69.getMessage());
          }

        }catch(SQLException e70){

          System.err.println("Erreur execute getNumeroClient : " + e70.getMessage());
        }

      }catch(SQLException e71){

        System.err.println("Erreur requete getNumeroClient : " + e71.getMessage());
      }

      return resultat;
  }

  public static int getNombreReservations(String date){

      int resultat = 0;

      try{

        PreparedStatement requete = ConnexionBDDProjet.getInstance().prepareStatement("SELECT COUNT(*) FROM Reservation WHERE debut = ?");
        requete.setString(1, date);

        try{

          ResultSet nombreReservation = requete.executeQuery();

          nombreReservation.next();

          resultat = nombreReservation.getInt(1);

          try{

            nombreReservation.close();
            requete.close();

          }catch(SQLException e69){

            System.err.println("Erreur close getNumeroClient : " + e69.getMessage());
          }

        }catch(SQLException e70){

          System.err.println("Erreur execute getNumeroClient : " + e70.getMessage());
        }

      }catch(SQLException e71){

        System.err.println("Erreur requete getNumeroClient : " + e71.getMessage());
      }

      return resultat;
  }

  public static int getNombreChambresOccupees(String date){

      int resultat = 0;

      try{

        PreparedStatement requete = ConnexionBDDPerso.getInstance().prepareStatement("SELECT COUNT(*) FROM historique WHERE date = ?");
        requete.setString(1, date);

        try{

          ResultSet nombreReservation = requete.executeQuery();

          nombreReservation.next();

          resultat = nombreReservation.getInt(1);

          try{

            nombreReservation.close();
            requete.close();

          }catch(SQLException e69){

            System.err.println("Erreur close getNumeroClient : " + e69.getMessage());
          }

        }catch(SQLException e70){

          System.err.println("Erreur execute getNumeroClient : " + e70.getMessage());
        }

      }catch(SQLException e71){

        System.err.println("Erreur requete getNumeroClient : " + e71.getMessage());
      }

      return resultat;
  }


  public static int getNombreJoursEntreDates(String debut, String fin){

      int resultat = 0;

      try{

        PreparedStatement requete = ConnexionBDDPerso.getInstance().prepareStatement("SELECT DATEDIFF( ?, ? )");
        requete.setString(1, debut);
        requete.setString(2, fin);

        try{

          ResultSet nombreReservation = requete.executeQuery();

          nombreReservation.next();

          resultat = nombreReservation.getInt(1);

          try{

            nombreReservation.close();
            requete.close();

          }catch(SQLException e69){

            System.err.println("Erreur close getNumeroClient : " + e69.getMessage());
          }

        }catch(SQLException e70){

          System.err.println("Erreur execute getNumeroClient : " + e70.getMessage());
        }

      }catch(SQLException e71){

        System.err.println("Erreur requete getNumeroClient : " + e71.getMessage());
      }

      resultat = resultat * (-1);

      resultat += 1;

      return resultat;
  }

  public static int getNombreChambresOccupeesPeriode(String debut, String fin){

      int resultat = 0;

      try{

        PreparedStatement requete = ConnexionBDDPerso.getInstance().prepareStatement("SELECT COUNT(*) FROM historique WHERE date >= ? AND date <= ?");
        requete.setString(1, debut);
        requete.setString(2, fin);

        try{

          ResultSet nombreReservation = requete.executeQuery();

          nombreReservation.next();

          resultat = nombreReservation.getInt(1);

          try{

            nombreReservation.close();
            requete.close();

          }catch(SQLException e69){

            System.err.println("Erreur close getNumeroClient : " + e69.getMessage());
          }

        }catch(SQLException e70){

          System.err.println("Erreur execute getNumeroClient : " + e70.getMessage());
        }

      }catch(SQLException e71){

        System.err.println("Erreur requete getNumeroClient : " + e71.getMessage());
      }

      return resultat;
  }

  public static void choisirChambre(int numeroClient, int numeroChambre){

    try{

      PreparedStatement requete = ConnexionBDDPerso.getInstance().prepareStatement("UPDATE chambre SET client = ? WHERE id = ?");
      requete.setInt(1, numeroClient);
      requete.setInt(2, numeroChambre);

      try{

        requete.executeUpdate();

        try{

          requete.close();

        }catch(SQLException e63){

          System.err.println("Erreur close choisirChambre : " + e63.getMessage());
        }

      }catch(SQLException e61){

        System.err.println("Erreur executeUpdate choisirChambre : " + e61.getMessage());
      }

    }catch(SQLException e60){

      System.err.println("Erreur requete choisirChambre : " + e60.getMessage());
    }

  }

  public static int getNombreChambreDisponible(String c){

    int resultat = 0;

    try{

      PreparedStatement requete = ConnexionBDDPerso.getInstance().prepareStatement("SELECT COUNT(*) FROM chambre WHERE categorie = ? AND client = 0");

      int categorie = 0;

      switch(c){
        case "Un lit simple":
          categorie = 1;
          break;
        case "Un lit double":
          categorie = 2;
          break;
        default:
          categorie = 3;
          break;
      }

      requete.setInt(1, categorie);

      try{

        ResultSet nombreChambreDisponible = requete.executeQuery();
        nombreChambreDisponible.next();

        resultat = nombreChambreDisponible.getInt(1);

        try{

          nombreChambreDisponible.close();
          requete.close();

        }catch(SQLException e52){

          System.err.println("Erreur close getNombreChambreDisponible : " + e52.getMessage());
        }

      }catch(SQLException e51){

        System.err.println("Erreur execute getNombreChambreDisponible : " + e51.getMessage());
      }

    }catch(SQLException e50){

      System.err.println("Erreur requete getNombreChambreDisponible : " + e50.getMessage());
    }

    return resultat;

  }

  public static int[] getListeChambreDisponible(String c){

    int[] resultat = new int[50];

    try{

      PreparedStatement requete = ConnexionBDDPerso.getInstance().prepareStatement("SELECT id FROM chambre WHERE categorie = ? AND client = 0 ORDER BY id");

      int categorie = 0;

      switch(c){
        case "Un lit simple":
          categorie = 1;
          break;
        case "Un lit double":
          categorie = 2;
          break;
        default:
          categorie = 3;
          break;
      }

      requete.setInt(1, categorie);

      try{

        ResultSet ChambreDisponible = requete.executeQuery();

        int i = 0;

        while(ChambreDisponible.next()){

            resultat[i] = ChambreDisponible.getInt(1);

            i++;
        }

        try{

          ChambreDisponible.close();
          requete.close();

        }catch(SQLException e52){

          System.err.println("Erreur close getNombreChambreDisponible : " + e52.getMessage());
        }

      }catch(SQLException e51){

        System.err.println("Erreur execute getNombreChambreDisponible : " + e51.getMessage());
      }

    }catch(SQLException e50){

      System.err.println("Erreur requete getNombreChambreDisponible : " + e50.getMessage());
    }

    return resultat;

  }

    public static Reservation getReservationReference(String reference){

	Reservation resultat = new Reservation();

	try{


	    PreparedStatement requete = ConnexionBDDProjet.getInstance().prepareStatement("SELECT * FROM Reservation WHERE reference = ?");

	    requete.setString(1, reference);

	    try{

		ResultSet reservation = requete.executeQuery();

		try{

		    if(reservation.next() == false){

          return resultat;
        }

		    resultat.setReference(reservation.getString(2));
		    resultat.setDebut(reservation.getString(3));
		    resultat.setNuits(reservation.getString(4));

        int categorie = reservation.getInt(5);
        int numeroClient = reservation.getInt(6);

        resultat.setNumeroClient(numeroClient);

        switch(categorie){
          case 1:
            resultat.setCategorie("Un lit simple");
            break;
          case 2:
            resultat.setCategorie("Un lit double");
            break;
          default:
            resultat.setCategorie("Deux lits simples");
            break;
        }

		    // finir d'attribuer les choses dans reservation

		    try{

			reservation.close();

			try{

			    requete.close();

          try{

            requete = ConnexionBDDProjet.getInstance().prepareStatement("SELECT * FROM Client WHERE id = ?");

      	    requete.setInt(1, numeroClient);

            try{

              ResultSet infosClient = requete.executeQuery();

              try{

                infosClient.next();

                resultat.setNomClient(infosClient.getString(3));
                resultat.setPrenomClient(infosClient.getString(2));

                try{

                  infosClient.close();

                  try{

                    requete.close();

                    try{

                      requete = ConnexionBDDPerso.getInstance().prepareStatement("SELECT COUNT(*) FROM chambre WHERE categorie = ? AND client = 0");

                	    requete.setInt(1, categorie);

                      ResultSet nombreChambreDisponible = requete.executeQuery();

                      nombreChambreDisponible.next();

                      if(nombreChambreDisponible.getInt(1) > 0){

                        nombreChambreDisponible.close();
                        requete.close();

                        requete = ConnexionBDDPerso.getInstance().prepareStatement("SELECT id FROM chambre WHERE categorie = ? AND client = 0 ORDER BY id");
                        requete.setInt(1, categorie);

                        ResultSet chambreAllouee = requete.executeQuery();
                        chambreAllouee.next();

                        resultat.setChambreAllouee(chambreAllouee.getString(1));

                        chambreAllouee.close();
                        requete.close();
                      }
                      else{

                        resultat.setChambreAllouee("0");
                      }

                    }catch(SQLException e35){

                      System.err.println("Erreur choix chambre disponible : " + e35.getMessage());
                    }

                  }catch(SQLException e34){

                    System.err.println("Erreur close requete : " + e34.getMessage());
                  }

                }catch(SQLException e33){

                  System.err.println("Erreur close infosClient getNomClient : " + e33.getMessage());
                }

              }catch(SQLException e32){

                System.err.println("Erreur next requete getNomClient : " + e32.getMessage());
              }

            }catch(SQLException e31){

              System.err.println("Erreur execute requete getNomClient : " + e31.getMessage());
            }

          }catch(SQLException e30){

            System.err.println("Erreur requete getNomClient : " + e30.getMessage());
          }

			}catch(SQLException e12){

			    System.err.println("Erreur close requete getVote : " + e12.getMessage());
			}

		    }catch(SQLException e11){

			System.err.println("Erreur close infos getVote : " + e11.getMessage());
		    }

		}catch(SQLException e10){

		    System.err.println("Erreur get getVotes : " + e10.getMessage());
		}

	    }catch(SQLException e9){

		System.err.println("Erreur execute requete getVotes : " + e9.getMessage());
	    }

	}catch(SQLException e8){

	    System.err.println("Erreur requete getVotes : " + e8.getMessage());
	}

	return resultat;
    }


    public static Reservation[] getReservationsNumero(int numeroClient, int nombreReservation, String nom, String prenom){

	Reservation[] resultat = new Reservation[nombreReservation];

  for(int i = 0; i<nombreReservation; i++){

    resultat[i] = new Reservation();
  }

	try{


	    PreparedStatement requete = ConnexionBDDProjet.getInstance().prepareStatement("SELECT * FROM Reservation WHERE client = ?");

	    requete.setInt(1, numeroClient);

	    try{

		ResultSet reservations = requete.executeQuery();

		try{

        int j = 0;

        PreparedStatement requete2;
        PreparedStatement requete3;

		    while(reservations.next()){

          resultat[j].setReference(reservations.getString(2));
  		    resultat[j].setDebut(reservations.getString(3));
  		    resultat[j].setNuits(reservations.getString(4));
          resultat[j].setNomClient(nom);
          resultat[j].setPrenomClient(prenom);

          int categorie = reservations.getInt(5);

          resultat[j].setNumeroClient(numeroClient);

          switch(categorie){
            case 1:
              resultat[j].setCategorie("Un lit simple");
              break;
            case 2:
              resultat[j].setCategorie("Un lit double");
              break;
            default:
              resultat[j].setCategorie("Deux lits simples");
              break;
          }

          try{

            requete2 = ConnexionBDDPerso.getInstance().prepareStatement("SELECT COUNT(*) FROM chambre WHERE categorie = ? AND client = 0");

            requete2.setInt(1, categorie);

            ResultSet nombreChambreDisponible = requete2.executeQuery();

            nombreChambreDisponible.next();

            if(nombreChambreDisponible.getInt(1) > 0){

              nombreChambreDisponible.close();
              requete2.close();

              requete3 = ConnexionBDDPerso.getInstance().prepareStatement("SELECT id FROM chambre WHERE categorie = ? AND client = 0 ORDER BY id");
              requete3.setInt(1, categorie);

              ResultSet chambreAllouee = requete3.executeQuery();
              chambreAllouee.next();

              resultat[j].setChambreAllouee(chambreAllouee.getString(1));

              chambreAllouee.close();
              requete3.close();
            }
            else{

              resultat[j].setChambreAllouee("0");
            }

          }catch(SQLException e35){

            System.err.println("Erreur choix chambre disponible : " + e35.getMessage());
          }

          j++;

        }

		    try{

			      reservations.close();
          }catch(SQLException e80){

            System.err.println("Erreur close reservations getReservationsNumero : " + e80);
          }

    			try{

    			    requete.close();

          }catch(SQLException e34){

              System.err.println("Erreur close requete : " + e34.getMessage());
          }


			}catch(SQLException e12){

			    System.err.println("Erreur close requete getVote : " + e12.getMessage());
			}

		}catch(SQLException e11){

			System.err.println("Erreur close infos getVote : " + e11.getMessage());
		}

		}catch(SQLException e10){

		    System.err.println("Erreur get getVotes : " + e10.getMessage());
		}

	return resultat;
    }


}
