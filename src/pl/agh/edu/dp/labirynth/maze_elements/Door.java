package pl.agh.edu.dp.labirynth.maze_elements;

import pl.agh.edu.dp.gui.ElementImage;
import pl.agh.edu.dp.labirynth.maze_elements.MapSite;
import pl.agh.edu.dp.labirynth.maze_elements.Room;

public class Door extends MapSite {
    private Room room1;
    private Room room2;
    public boolean opened;

    public Door(Room r1, Room r2){
        this.room1 = r1;
        this.room2 = r2;
    }


    @Override
    public void enter(){
        System.out.println("Entering door");
    }

    @Override
    public ElementImage getImage() {
        return ElementImage.DOOR;
    }

    public Room getRoom1() {
        return room1;
    }

    public void setRoom1(Room room1) {
        this.room1 = room1;
    }

    public Room getRoom2() {
        return room2;
    }

    public void setRoom2(Room room2) {
        this.room1 = room2;
    }
}
