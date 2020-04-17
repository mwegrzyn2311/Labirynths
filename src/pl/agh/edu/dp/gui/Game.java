package pl.agh.edu.dp.gui;

import pl.agh.edu.dp.labirynth.builder.MazeBuilder;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Game extends JFrame {
    MazeBuilder builder;

    public Game(MazeBuilder builder) {
        super("Labirynth");
        this.builder = builder;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        startLevel();
    }

    public void startLevel() {
            this.getContentPane().removeAll();

            LevelPanel panel = new LevelPanel(this, builder);
            this.add(panel);
            panel.requestFocusInWindow();

            this.setResizable(false);
            this.pack();
            this.setLocationRelativeTo(null);
            this.setVisible(true);
    }
}
