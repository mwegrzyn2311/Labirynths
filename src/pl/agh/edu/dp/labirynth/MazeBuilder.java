package pl.agh.edu.dp.labirynth;

public abstract class MazeBuilder {
    protected Maze maze;

    abstract void buildRoom(int number);
    abstract void buildDoor(int from, int to);
    Maze getMaze() {
        return maze;
    }
    void clear() {
        maze = new Maze();
    }
}
