package pl.agh.edu.dp.labirynth.factory;

import pl.agh.edu.dp.labirynth.*;
import pl.agh.edu.dp.labirynth.maze_elements.Door;
import pl.agh.edu.dp.labirynth.maze_elements.Room;
import pl.agh.edu.dp.labirynth.maze_elements.Wall;

public class MazeFactory {
    private static MazeFactory instance;

    protected MazeFactory() {};

    public static MazeFactory getInstance() {
        if(instance == null) {
            instance = new MazeFactory();
        }
        return instance;
    }

    public Room makeRoom(int index) {
        return new Room(index);
    }

    public Wall makeWall() {
        return new Wall();
    }

    public Door makeDoor(Room first, Room second) {
        return new Door(first, second);
    }

}
