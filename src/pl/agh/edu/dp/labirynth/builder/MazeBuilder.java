package pl.agh.edu.dp.labirynth.builder;

import pl.agh.edu.dp.labirynth.Maze;

public abstract class MazeBuilder {
    protected Maze maze;

    abstract public void buildRoom(int number);
    abstract public void buildDoor(int from, int to);
    public Maze getMaze() {
        return maze;
    }
    public void clear() {
        maze = new Maze();
    }
}
