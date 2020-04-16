package pl.agh.edu.dp.gui;

import pl.agh.edu.dp.labirynth.Direction;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MoveBindings implements KeyListener {
    private LevelPanel levelPanel;
    private boolean upPressed=false;
    private boolean rightPressed=false;
    private boolean downPressed=false;
    private boolean leftPressed=false;

    public MoveBindings(LevelPanel levelPanel){
        this.levelPanel = levelPanel;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }
    @Override
    public void keyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()){
            // Firstly moving player
            case(KeyEvent.VK_UP):
                upPressed = true;
                this.levelPanel.lastMove = Direction.North;
                this.levelPanel.oneMove = Direction.North;
                break;
            case(KeyEvent.VK_RIGHT):
                rightPressed = true;
                this.levelPanel.lastMove = Direction.East;
                this.levelPanel.oneMove = Direction.East;
                break;
            case(KeyEvent.VK_DOWN):
                downPressed = true;
                this.levelPanel.lastMove = Direction.South;
                this.levelPanel.oneMove = Direction.South;
                break;
            case(KeyEvent.VK_LEFT):
                leftPressed = true;
                this.levelPanel.lastMove = Direction.West;
                this.levelPanel.oneMove = Direction.West;
                break;

            default:
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()){

            // Firstly move
            case(KeyEvent.VK_UP):
                upPressed = false;
                break;
            case(KeyEvent.VK_RIGHT):
                rightPressed = false;
                break;
            case(KeyEvent.VK_DOWN):
                downPressed = false;
                break;
            case(KeyEvent.VK_LEFT):
                leftPressed = false;
                break;
            default:
        }

        if(!(upPressed || rightPressed || downPressed || leftPressed))
            this.levelPanel.lastMove = null;
    }
}
