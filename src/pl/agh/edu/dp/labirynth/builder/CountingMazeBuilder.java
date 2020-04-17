package pl.agh.edu.dp.labirynth.builder;

import pl.agh.edu.dp.labirynth.utils.Direction;
import pl.agh.edu.dp.labirynth.Maze;

public class CountingMazeBuilder extends MazeBuilder {
    private int roomsCount;
    private int doorsCount;
    private int wallsCount;

    @Override
    public void buildRoom(int number) {
        ++roomsCount;
        wallsCount += 4;
    }

    @Override
    public void buildDoor(int roomIndex1, int roomIndex2) {
        ++doorsCount;
        wallsCount -= 2;
    }

    @Override
    public void buildDoor(int roomIndex1, int roomIndex2, Direction dir) {
        ++doorsCount;
        wallsCount -= 2;
    }

    @Override
    public void clear() {
        roomsCount = 0;
        doorsCount = 0;
    }

    @Override
    public Maze getMaze() {
        return null;
    }

    public int getRoomCount() {
        return roomsCount;
    }

    public int getDoorCount() {
        return doorsCount;
    }

    public int getWallsCount() {
        return wallsCount;
    }
}
