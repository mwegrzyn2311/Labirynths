package pl.agh.edu.dp.gui;

import pl.agh.edu.dp.labirynth.*;
import pl.agh.edu.dp.utils.Vector2d;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static java.awt.event.KeyEvent.*;

public class LevelPanel extends JPanel {
    private Maze maze;
    private Map<Vector2d, ElementTile> tilesMap = new HashMap<>();

    private int width;
    private int height;
    public Direction lastMove = null;
    public Direction oneMove = null;
    private BufferedImage image = null;
    private Timer timer;
    private MoveBindings bindings;


    public LevelPanel(BufferedImage image) {
        this.maze = MazeGame.createMaze();
        constructPanel();
        this.timer.start();
    }

    private void constructPanel(){
        this.setBackground(new Color(255, 255, 255));
        this.width = 3;
        this.height = 3;
        setKeyBindings();
        this.setLayout(new GridLayout(width, height));
        this.setPreferredSize(new Dimension(ElementTile.tileSize*width, ElementTile.tileSize*height));

        initTiles();
        this.timer = new Timer(180, actionEvent -> {
            try {
                executeOneTurn();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        this.timer.setRepeats(true);
    }

    private void executeOneTurn() throws IOException {
        if(lastMove != null) {
            maze.currentRoom.getSide(lastMove).enter();
        } else if(oneMove != null) {
            maze.currentRoom.getSide(oneMove).enter();
        }

        updateTiles();
        oneMove = null;
    }

    public void initTiles(){
        this.removeAll();
        ElementTile tile;
        ElementImage eleImage;

        for(int j = 1; j >= -1; j--) {
            for(int i = -1; i <= 1; i++) {
                eleImage = this.maze.currentRoom.getSideImage(i, j);
                tile = new ElementTile(eleImage.image);
                this.tilesMap.put(new Vector2d(i,j), tile);
                this.add(tile);
            }
        }
    }

    private void updateTiles(){
        ElementImage eleImage;
        for(int j = 1; j >= -1; j--) {
            for(int i = -1; i <= 1; i++) {
                eleImage = this.maze.currentRoom.getSideImage(i, j);
                this.tilesMap.get(new Vector2d(i,j)).changeImage(eleImage.image);
            }
        }
    }

    private void setKeyBindings(){
        this.setFocusable(true);
        this.bindings = new MoveBindings(this);
        this.addKeyListener(this.bindings);
    }
}
