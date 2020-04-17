package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.labirynth.maze_elements.Room;

import java.util.Optional;
import java.util.Vector;

public class Maze {
    private Vector<Room> rooms = new Vector<>();

    public Maze() { }

    public void addRoom(Room room){
        rooms.add(room);
    }

    public void setRooms(Vector<Room> rooms) {
        this.rooms = rooms;
    }
    public Optional<Room> getRoom(int index) {
        return rooms.stream()
                .filter(room -> room.getRoomNumber() == index)
                .findAny();
    }

    public int getRoomNumbers()
    {
        return rooms.size();
    }

    public Room getStartingRoom() {
        if(rooms.isEmpty()) {
            throw new RuntimeException("Maze has no rooms");
        }
        return rooms.firstElement();
    }
}
