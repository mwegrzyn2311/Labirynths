package pl.agh.edu.dp.labirynth;

import java.util.Vector;

public class Maze {
    private Vector<Room> rooms = new Vector<>();
    public Room currentRoom = null;

    public Maze() { }

    public void addRoom(Room room){
        rooms.add(room);
        if(this.currentRoom == null) {
            this.currentRoom = room;
        }
    }

    public void setRooms(Vector<Room> rooms) {
        this.rooms = rooms;
    }

    public int getRoomNumbers()
    {
        return rooms.size();
    }
}
