package pl.agh.edu.dp.labirynth.factory;

import pl.agh.edu.dp.labirynth.Maze;
import pl.agh.edu.dp.labirynth.maze_elements.Door;
import pl.agh.edu.dp.labirynth.maze_elements.Room;
import pl.agh.edu.dp.labirynth.maze_elements.Wall;
import pl.agh.edu.dp.labirynth.maze_elements.enchanted.EnchantedDoor;
import pl.agh.edu.dp.labirynth.maze_elements.enchanted.EnchantedRoom;
import pl.agh.edu.dp.labirynth.maze_elements.enchanted.EnchantedWall;

public class EnchantedMazeFactory extends MazeFactory {
    private static EnchantedMazeFactory instance;

    protected EnchantedMazeFactory() {};

    public static EnchantedMazeFactory getInstance() {
        if(instance == null) {
            instance = new EnchantedMazeFactory();
        }
        return instance;
    }

    @Override
    public Room makeRoom(int index) {
        return new EnchantedRoom(index);
    }

    @Override
    public Wall makeWall() {
        return new EnchantedWall();
    }

    @Override
    public Door makeDoor(Room first, Room second) {
        return new EnchantedDoor(first, second);
    }
}
