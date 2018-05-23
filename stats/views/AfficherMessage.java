package views;

import java.awt.*;
import javax.swing.*;

public class AfficherMessage extends JOptionPane{

    public static void afficherErreur(String typeErreur, String messageErreur){

	AfficherMessage.showMessageDialog(null, messageErreur, typeErreur, JOptionPane.ERROR_MESSAGE);

    }

    public static void afficherInformation(String typeInformation, String messageInformation){

      AfficherMessage.showMessageDialog(null, messageInformation, typeInformation, JOptionPane.INFORMATION_MESSAGE);

    }

}
