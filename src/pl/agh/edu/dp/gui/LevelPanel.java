package pl.agh.edu.dp.gui;

import pl.agh.edu.dp.labirynth.*;
import pl.agh.edu.dp.labirynth.builder.MazeBuilder;
import pl.agh.edu.dp.labirynth.utils.Direction;
import pl.agh.edu.dp.utils.Vector2d;


import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LevelPanel extends JPanel {
    private Player player;
    private Map<Vector2d, ElementTile> tilesMap = new HashMap<>();

    private int width;
    private int height;
    public Direction lastMove = null;
    public Direction oneMove = null;
    private Timer timer;
    private int delay = 300;
    private Game game;


    public LevelPanel(Game game, MazeBuilder builder) {
        Maze maze = MazeGame.createMaze(builder);
        this.player = new Player(maze.getStartingRoom());
        constructPanel();
        this.game = game;
        this.timer.start();
    }

    public void startTimer() {
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
            gameOver();
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

    private void gameOver() {
        game.getContentPane().removeAll();
        GameOverScreen gameOverScreen = new GameOverScreen(game);
        game.add(gameOverScreen);
        game.pack();
        game.setLocationRelativeTo(null);
        game.setVisible(true);
        gameOverScreen.requestFocusInWindow();
        timer.stop();
    }

    private void initTiles(){
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
        this.addKeyListener(new MoveBindings(this));
    }
}
