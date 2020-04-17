package pl.agh.edu.dp.labirynth.builder;

import pl.agh.edu.dp.labirynth.*;
import pl.agh.edu.dp.labirynth.factory.MazeFactory;
import pl.agh.edu.dp.labirynth.utils.Direction;
import pl.agh.edu.dp.labirynth.maze_elements.Door;
import pl.agh.edu.dp.labirynth.maze_elements.Room;
import pl.agh.edu.dp.labirynth.maze_elements.Wall;

import java.util.Optional;

public class StandardBuilderMaze extends MazeBuilder {
    private Maze maze = new Maze();
    private MazeFactory factory;

    public StandardBuilderMaze(MazeFactory factory) {
        this.factory = factory;
    }

    @Override
    public void buildRoom(int index) {
        if(!maze.getRoom(index).isEmpty()) {
            throw new IllegalArgumentException("Trying to build room on occupied place");
        }
        Room room = factory.makeRoom(index, maze);
        for (Direction dir: Direction.values()) {
            room.setSide(dir, factory.makeWall());
        }
        maze.addRoom(room);
    }

    @Override
    public void buildDoor(int roomIndex1, int roomIndex2) {
        if(maze.getRoom(roomIndex1).isEmpty() || maze.getRoom(roomIndex2).isEmpty()) {
            throw new IllegalArgumentException("Cannot connect non-existing rooms");
        }
        Room room1 = maze.getRoom(roomIndex1).get();
        Room room2 = maze.getRoom(roomIndex2).get();
        Direction dir = commonWall(room1, room2);
        Door door = factory.makeDoor(room1, room2);
        room1.setSide(dir, door);
        room2.setSide(dir.opposite(), door);
    }

    @Override
    public void buildDoor(int roomIndex1, int roomIndex2, Direction dir) {
        if(maze.getRoom(roomIndex1).isEmpty() || maze.getRoom(roomIndex2).isEmpty()) {
            throw new IllegalArgumentException("Cannot connect non-existing rooms");
        }
        Room room1 = maze.getRoom(roomIndex1).get();
        Room room2 = maze.getRoom(roomIndex2).get();
        if(!canConnectRoomsInDir(room1, room2, dir)) {
            throw new IllegalArgumentException("Cannot connect given rooms in given direction");
        }
        Door door = factory.makeDoor(room1, room2);
        room1.setSide(dir, door);
        room2.setSide(dir.opposite(), door);
    }

    private boolean canConnectRoomsInDir(Room room1, Room room2, Direction dir) {
        return (room1.getSide(dir) instanceof Wall && room2.getSide(dir.opposite()) instanceof Wall);
    }

    private Direction commonWall(Room from, Room to)
    {
        for(Direction dir : Direction.values()) {
            if(from.getSide(dir) instanceof Wall && to.getSide(dir.opposite()) instanceof Wall) {
                return dir;
            }
        }
        throw new IllegalArgumentException("Cannot connect these rooms");
    }

    public Maze getMaze() {
        return maze;
    }

    public void clear() {
        maze = new Maze();
    }
}
