package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.labirynth.maze_elements.Room;

import java.util.Optional;
import java.util.Vector;

public class Maze {
    private Vector<Room> rooms = new Vector<>();
    private Optional<Integer> startingRoomIndex;

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

    public void setStartingRoom(int index) {
        startingRoomIndex = Optional.of(index);
    }

    public Room getStartingRoom() {
        if(rooms.isEmpty()) {
            throw new RuntimeException("Maze has no rooms");
        }
        if(startingRoomIndex.isEmpty()) {
            return rooms.firstElement();
        } else {
            for(Room room : rooms) {
                if(startingRoomIndex.get() == room.getRoomNumber()) {
                    return room;
                }
            }
        }
        throw new RuntimeException("There is no room with index == starting index");
    }
}
