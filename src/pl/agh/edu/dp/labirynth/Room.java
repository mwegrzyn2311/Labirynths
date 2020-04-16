package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.gui.ElementImage;

import java.util.EnumMap;
import java.util.Map;

public class Room extends MapSite
{
    private int roomNumber;
    private Map<Direction, MapSite> sides;
    private Maze maze;


    public Room(int number, Maze maze){
        this.sides = new EnumMap<>(Direction.class);
        this.roomNumber = number;
        this.maze = maze;
    }

    public MapSite getSide(Direction direction){
        return this.sides.get(direction);
    }

    public ElementImage getSideImage(int i, int j) {
        if(i == 0 && j == 0) {
            //TODO: change Player to singleton
            return ElementImage.PLAYER;
        } else if(i != 0 && j != 0) {
            return ElementImage.SOLID_WALL;
        } else {
            return this.sides.get(Direction.vectorToDirection(i, j)).getImage();
        }
    }

    public void setSide(Direction direction, MapSite ms){
        this.sides.put(direction, ms);
    }

    public int getRoomNumber(){
        return this.roomNumber;
    }

    @Override
    public void enter(){
        System.out.println("Entering new room");
        this.maze.currentRoom = this;
    }

    @Override
    public ElementImage getImage() {
        return ElementImage.FLOOR;
    }
}
