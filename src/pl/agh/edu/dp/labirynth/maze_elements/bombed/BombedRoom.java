package pl.agh.edu.dp.labirynth.maze_elements.bombed;

import pl.agh.edu.dp.labirynth.Maze;
import pl.agh.edu.dp.labirynth.Player;
import pl.agh.edu.dp.labirynth.maze_elements.Room;

public class BombedRoom extends Room {
    static final int timeToDetonate = 10*100;
    int timer = 0;
    public BombedRoom(int number, Maze maze) {
        super(number, maze);
    }

    @Override
    public void enter(Player player) {
        super.enter(player);
        timer = 0;
    }

    @Override
    public void update(int deltaTime, Player player) {
        timer += deltaTime;
        if(timer > timeToDetonate) {
            player.kill();
        }
    }
}
