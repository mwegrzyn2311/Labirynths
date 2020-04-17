package pl.agh.edu.dp.labirynth.builder;

import pl.agh.edu.dp.labirynth.utils.Direction;
import pl.agh.edu.dp.labirynth.Maze;

public abstract class MazeBuilder {

    abstract public void buildRoom(int number);
    abstract public void buildDoor(int roomIndex1, int roomIndex2);
    abstract public void buildDoor(int roomIndex1, int roomIndex2, Direction dir);
    abstract public void clear();
    abstract public Maze getMaze();
}
