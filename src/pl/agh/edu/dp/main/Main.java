package pl.agh.edu.dp.main;

import com.sun.security.jgss.GSSUtil;
import pl.agh.edu.dp.gui.Game;
import pl.agh.edu.dp.labirynth.MazeGame;
import pl.agh.edu.dp.labirynth.builder.MazeBuilder;
import pl.agh.edu.dp.labirynth.builder.StandardBuilderMaze;
import pl.agh.edu.dp.labirynth.factory.BombedMazeFactory;
import pl.agh.edu.dp.labirynth.factory.EnchantedMazeFactory;
import pl.agh.edu.dp.labirynth.factory.MazeFactory;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        MazeBuilder builder = new StandardBuilderMaze(MazeFactory.getInstance());
        /*builder.clear();
        builder.buildRoom(1);
        builder.buildRoom(2);
        builder.buildDoor(1, 2);*/
        BufferedImage image = ImageIO.read(Main.class.getResource("/resources/levels/level1.png"));
        MazeGame.fillBuilderFromBufferedImage(builder, image);

        if(BombedMazeFactory.getInstance() == BombedMazeFactory.getInstance()) {
            System.out.println("Bombed maze factory is singleton");
        } else {
            System.out.println("Bombed maze factory is not singleton");
        }
        if(EnchantedMazeFactory.getInstance() == EnchantedMazeFactory.getInstance()) {
            System.out.println("Enchanted maze factory is singleton");
        } else {
            System.out.println("Enchanted maze factory is not singleton");
        }
        if(MazeFactory.getInstance() == MazeFactory.getInstance()) {
            System.out.println("Classic maze factory is singleton");
        } else {
            System.out.println("Classic maze factory is not singleton");
        }

        SwingUtilities.invokeLater(() -> {
            try {
                Game game = new Game(builder);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}



