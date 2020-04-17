package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.labirynth.maze_elements.Room;
import pl.agh.edu.dp.labirynth.utils.Direction;

public class Player {
    private boolean alive = true;
    public Room currentRoom;

    public Player(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void move(Direction dir) {
        currentRoom.getSide(dir).enter(this);
    }

    public void kill() {
        this.alive = false;
    }

    public boolean isDead() {
        return !alive;
    }

    public void update(int deltaTime) {
        this.currentRoom.update(deltaTime, this);
    }
}
