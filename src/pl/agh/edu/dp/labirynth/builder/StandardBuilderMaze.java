package pl.agh.edu.dp.labirynth.builder;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.Door;
import pl.agh.edu.dp.labirynth.Room;
import pl.agh.edu.dp.labirynth.Wall;

public class StandardBuilderMaze extends MazeBuilder {
    @Override
    public void buildRoom(int index) {
        if(!maze.getRoom(index).isEmpty()) {
            throw new IllegalArgumentException("Trying to build room on occupied place");
        }
        Room room = new Room(index, maze);
        room.setSide(Direction.East, new Wall());
        room.setSide(Direction.West, new Wall());
        room.setSide(Direction.North, new Wall());
        room.setSide(Direction.South, new Wall());

        maze.addRoom(room);
    }

    @Override
    public void buildDoor(int from, int to) {
        Room roomFrom = maze.getRoom(from).orElseThrow(IllegalArgumentException::new);
        Room roomTo = maze.getRoom(to).orElseThrow(IllegalArgumentException::new);

        Door door= new Door(roomFrom, roomTo);
        roomFrom.setSide(commonWall(roomFrom, roomTo), door);
        roomTo.setSide(commonWall(roomTo, roomFrom), door);
    }

    private Direction commonWall(Room from, Room to)
    {
        int fromIndex = from.getRoomNumber();
        int toIndex = to.getRoomNumber();

        if(fromIndex + 1 == toIndex) {
            return Direction.East;
        }
        if(fromIndex - 1 == toIndex) {
            return Direction.West;
        }
        if(fromIndex > toIndex) {
            return Direction.South;
        }
        return Direction.North;
    }
}
