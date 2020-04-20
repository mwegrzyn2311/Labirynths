package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.labirynth.builder.MazeBuilder;
import pl.agh.edu.dp.labirynth.utils.Direction;

import java.awt.image.BufferedImage;

public class MazeGame {

    public static Maze createMaze(MazeBuilder builder) {
        return builder.getMaze();
    }

    public static void fillBuilderFromBufferedImage(MazeBuilder builder, BufferedImage image) {
        builder.clear();
        Maze maze = builder.getMaze();
        boolean isRoom;
        int width = image.getWidth()-2;
        for(int j = 1; j < image.getHeight()-1; j++) {
            for(int i = 1; i < image.getWidth()-1; i++) {
                int index = (j-1)*width+(i-1);
                int clr = image.getRGB(i, j);
                switch(clr) {
                    case (-32985):
                        maze.setStartingRoom(index);
                        isRoom = true;
                        break;
                    case (-1):
                        isRoom = true;
                        break;
                    default:
                        isRoom = false;
                        break;
                }
                if(!isRoom) {
                    continue;
                }
                builder.buildRoom(index);
            }
        }
        for(int j = 1; j < image.getHeight()-1; j++) {
            for(int i = 1; i < image.getWidth()-1; i++) {
                int index = (j-1)*width+(i-1);
                int curr = image.getRGB(i,j);
                if(curr != -1 && curr != -32985) {
                    continue;
                }
                int clr = image.getRGB(i+1, j);
                if(clr == -1 || clr == -32985) {
                    builder.buildDoor(index, index+1, Direction.EAST);
                }
                clr = image.getRGB(i, j+1);
                if(clr == -1 || clr == -32985) {
                    builder.buildDoor(index, index+width, Direction.SOUTH);
                }
            }
        }
    }
}
