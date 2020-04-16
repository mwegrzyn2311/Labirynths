package pl.agh.edu.dp.gui;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public enum ElementImage {
    PLAYER("player.png"),
    WALL("wall.png"),
    SOLID_WALL("solidWall.png"),
    FLOOR("floor.png"),
    DOOR("door.png");

    public Image image;

    ElementImage(String imagePath) {
        try {
            this.image = ImageIO.read(getClass().getResource("/resources/images/" + imagePath));
            if (this.image == null)
                System.out.println("ElementImage initialization is wrong");
        } catch (IOException ex) {
            throw new RuntimeException("Failed to load static resource");
        }
    }
}
