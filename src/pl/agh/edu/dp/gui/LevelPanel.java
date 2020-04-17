package pl.agh.edu.dp.gui;

import pl.agh.edu.dp.labirynth.*;
import pl.agh.edu.dp.labirynth.builder.StandardBuilderMaze;
import pl.agh.edu.dp.labirynth.factory.BombedMazeFactory;
import pl.agh.edu.dp.labirynth.factory.EnchantedMazeFactory;
import pl.agh.edu.dp.labirynth.factory.MazeFactory;
import pl.agh.edu.dp.labirynth.utils.Direction;
import pl.agh.edu.dp.utils.Vector2d;


import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LevelPanel extends JPanel {
    private Maze maze;
    private Player player;
    private Map<Vector2d, ElementTile> tilesMap = new HashMap<>();

    private int width;
    private int height;
    public Direction lastMove = null;
    public Direction oneMove = null;
    private BufferedImage image = null;
    private Timer timer;
    private MoveBindings bindings;
    private int delay = 300;


    public LevelPanel(BufferedImage image) {
        this.maze = MazeGame.createMaze(new StandardBuilderMaze(BombedMazeFactory.getInstance()));
        this.player = new Player(this.maze.getStartingRoom());
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
        this.timer = new Timer(delay, actionEvent -> {
            try {
                executeOneTurn();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        this.timer.setRepeats(true);
    }

    private void executeOneTurn() throws IOException {
        player.update(delay);
        if(player.isDead()) {
            System.out.println("Co ty sobie myślisz, cwaniaczku, że z piątego przykazania możesz sobie zrobić spółkę z ograniczoną odpowiedzialnością?!");
            return;
        }
        if(lastMove != null) {
            player.move(lastMove);
            updateTiles();
        } else if(oneMove != null) {
            player.move(oneMove);
            updateTiles();
        }
        oneMove = null;
    }

    public void initTiles(){
        this.removeAll();
        ElementTile tile;
        ElementImage eleImage;

        for(int j = 1; j >= -1; j--) {
            for(int i = -1; i <= 1; i++) {
                eleImage = this.player.currentRoom.getSideImage(i, j);
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
                eleImage = this.player.currentRoom.getSideImage(i, j);
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
