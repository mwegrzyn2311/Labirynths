package pl.agh.edu.dp.labirynth.builder;

import pl.agh.edu.dp.labirynth.utils.Direction;
import pl.agh.edu.dp.labirynth.Maze;

public interface MazeBuilder {

    void buildRoom(int number);
    void buildDoor(int roomIndex1, int roomIndex2);
    void buildDoor(int roomIndex1, int roomIndex2, Direction dir);
    void clear();
    Maze getMaze();
}
