JFLAGS = -g
JC = javac
J = java
.SUFFIXES: .java .class
.java.class:
		$(JC) $(JFLAGS) $*.java

CLASSES = \
		controllers/ControleurFenetre.java \
		controllers/ControleurRecherche.java \
		controllers/ControleurConfirmerReservation.java \
		controllers/ControleurModifierChambre.java \
		controllers/ControleurBoutonModifierChambre.java \
		controllers/ControleurBoutonsMenuRechercheReservation.java \
		controllers/ControleurBoutonRetour.java \
		controllers/ControleurBoutonAide.java \
		controllers/ControleurChoixReservation.java \
		models/ConnexionBDDPerso.java \
		models/ConnexionBDDProjet.java \
		models/ModelRecherche.java \
		views/Fenetre.java \
		views/PanneauInformationsRecherche.java \
		views/AfficherMessage.java \
		views/PanneauRecherche.java \
		views/MenuRechercheReservation.java \
		classes/Reservation.java \
		Main.java

default: classes

classes: $(CLASSES:.java=.class)

run: classes
		$(J) -cp "mariadb-client.jar:." Main

clean:
		$(RM) *.class
		$(RM) *~
		$(RM) views/*.class
		$(RM) views/*~
		$(RM) models/*.class
		$(RM) models/*~
		$(RM) controllers/*.class
		$(RM) controllers/*~
		$(RM) classes/*.class
		$(RM) classes/*~
