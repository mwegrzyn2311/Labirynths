package pl.agh.edu.dp.labirynth.factory;

import pl.agh.edu.dp.labirynth.Maze;
import pl.agh.edu.dp.labirynth.maze_elements.Room;
import pl.agh.edu.dp.labirynth.maze_elements.Wall;
import pl.agh.edu.dp.labirynth.maze_elements.bombed.BombedRoom;
import pl.agh.edu.dp.labirynth.maze_elements.bombed.BombedWall;

public class BombedMazeFactory extends MazeFactory {
    @Override
    public Wall makeWall() {
        return new BombedWall();
    }

    @Override
    public Room makeRoom(int index, Maze maze) {
        return new BombedRoom(index, maze);
    }
}
