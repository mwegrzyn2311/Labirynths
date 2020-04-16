package pl.agh.edu.dp.labirynth;

public class MazeGame {
    public static Maze createMaze(){
        Maze maze = new Maze();

        Room r1 = new Room(1, maze);
        Room r2 = new Room(2, maze);

        Door door = new Door(r1, r2);

        maze.addRoom(r1);
        maze.addRoom(r2);

        r1.setSide(Direction.North, r2);
        r1.setSide(Direction.East, new Wall());
        r1.setSide(Direction.South, new Wall());
        r1.setSide(Direction.West, new Wall());

        r2.setSide(Direction.North, new Wall());
        r2.setSide(Direction.East, new Wall());
        r2.setSide(Direction.South, new Door(r2, r1));
        r2.setSide(Direction.West, new Wall());

        return maze;
    }
}
