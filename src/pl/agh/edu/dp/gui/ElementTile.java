package pl.agh.edu.dp.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ElementTile extends JComponent {
    private Image image;
    public static int tileSize = 100;

    public ElementTile(Image image){
        this.image = image;
        this.setPreferredSize(new Dimension(tileSize, tileSize));
    }

    public void changeImage(Image image){
        if(image != this.image){
            this.image = image;
            repaint(0,0,getWidth(),getHeight());
        }
    }

    public final void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (this.image != null) {
            g.drawImage(this.image, 0, 0, null);
        }

    }
}
