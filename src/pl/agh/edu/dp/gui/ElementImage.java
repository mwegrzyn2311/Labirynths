package pl.agh.edu.dp.gui;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public enum ElementImage {
    PLAYER("player.png"),
    WALL("wall.png"),
    DOOR("door.png");

    public Image image;

    ElementImage(String imagePath) {
        try {
            this.image = ImageIO.read(getClass().getResource("/resources/images/" + imagePath));
            if (this.image == null)
                System.out.println("ElementImage initialization is wrong");
            this.image = this.image.getScaledInstance(ElementTile.tileSize, ElementTile.tileSize, Image.SCALE_SMOOTH);
        } catch (IOException ex) {
            throw new RuntimeException("Failed to load static resource");
        }
    }
}
