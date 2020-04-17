package pl.agh.edu.dp.labirynth.maze_elements;

import pl.agh.edu.dp.gui.ElementImage;
import pl.agh.edu.dp.labirynth.Player;
import pl.agh.edu.dp.labirynth.utils.Direction;
import pl.agh.edu.dp.labirynth.Maze;

import java.util.EnumMap;
import java.util.Map;

public class Room extends MapSite
{
    private int roomNumber;
    private Map<Direction, MapSite> sides;
    public Maze maze;


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
            return ElementImage.PLAYER;
        } else if(i != 0 && j != 0) {
            return ElementImage.WALL;
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
    public void enter(Player player) {
        player.currentRoom = this;
    }

    @Override
    public ElementImage getImage() {
        throw new IllegalArgumentException("Currently you can only enter room by a door");
    }

    public void update(int deltaTime, Player player) {

    }
}
