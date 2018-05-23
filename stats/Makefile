JFLAGS = -g
JC = javac
J = java
.SUFFIXES: .java .class
.java.class:
		$(JC) $(JFLAGS) $*.java

CLASSES = \
		controllers/ControleurFenetre.java \
		controllers/ControleurTaux.java \
		controllers/ControleurBoutonsMenuTaux.java \
		controllers/ControleurBoutonRetour.java \
		controllers/ControleurBoutonAide.java \
		models/ConnexionBDDPerso.java \
		models/ConnexionBDDProjet.java \
		models/ModelTaux.java \
		views/Fenetre.java \
		views/PanneauInformationsRecherche.java \
		views/Camembert.java \
		views/AfficherMessage.java \
		views/PanneauTaux.java \
		views/MenuTaux.java \
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
