package pl.agh.edu.dp.main;

import pl.agh.edu.dp.gui.Game;
import pl.agh.edu.dp.labirynth.*;

import javax.swing.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            try {
                Game game = new Game();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        /*MazeGame mazeGame = new MazeGame();
        Maze maze = mazeGame.createMaze();

        System.out.println(maze.getRoomNumbers());*/
    }
}



