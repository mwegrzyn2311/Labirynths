package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.labirynth.builder.MazeBuilder;
import pl.agh.edu.dp.labirynth.maze_elements.Door;
import pl.agh.edu.dp.labirynth.maze_elements.Room;
import pl.agh.edu.dp.labirynth.maze_elements.Wall;
import pl.agh.edu.dp.labirynth.utils.Direction;

public class MazeGame {
//    public static Maze createMaze(){
//        Maze maze = new Maze();
//
//        Room r1 = new Room(1, maze);
//        Room r2 = new Room(2, maze);
//
//        Door door = new Door(r1, r2);
//
//        maze.addRoom(r1);
//        maze.addRoom(r2);
//
//        r1.setSide(Direction.NORTH, r2);
//        r1.setSide(Direction.EAST, new Wall());
//        r1.setSide(Direction.SOUTH, new Wall());
//        r1.setSide(Direction.WEST, new Wall());
//
//        r2.setSide(Direction.NORTH, new Wall());
//        r2.setSide(Direction.EAST, new Wall());
//        r2.setSide(Direction.SOUTH, new Door(r2, r1));
//        r2.setSide(Direction.WEST, new Wall());
//
//        return maze;
//    }

    public static Maze createMaze(MazeBuilder builder){
        builder.clear();
        builder.buildRoom(1);
        builder.buildRoom(2);
        builder.buildDoor(1, 2);

        return builder.getMaze();
    }

}
