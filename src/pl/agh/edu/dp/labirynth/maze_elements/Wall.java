package pl.agh.edu.dp.labirynth.maze_elements;

import pl.agh.edu.dp.gui.ElementImage;
import pl.agh.edu.dp.labirynth.Player;

public class Wall extends MapSite {
    public Wall(){

    }

    @Override
    public void enter(Player player){
        System.out.println("Cannot enter wall");
    }

    @Override
    public ElementImage getImage() {
        return ElementImage.WALL;
    }
}
