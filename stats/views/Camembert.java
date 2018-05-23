package views;

import java.awt.*;
import javax.swing.*;
import java.awt.Color;

public class Camembert extends JComponent {

    private Color color;
    private int angle;

    public Camembert(int a){

	this.angle = a;
	this.color = Color.RED;
    }

    @Override
    public void paintComponent(Graphics pinceau){

	Graphics p = pinceau.create();

	p.setColor(Color.GREEN);
	p.fillArc(50, 20, this.getWidth() / 2, this.getWidth() / 2, -90, 360);

	p.setColor(this.color);
	p.fillArc(50, 20, this.getWidth() / 2, this.getWidth() / 2, -90, this.angle);
    }

    public void drawDisponible(int angle){

	this.color = Color.GREEN;
	this.angle = angle;
	repaint();
    }

}
// (360*oui)/(oui+non) ( faire différence oui = 0 )
