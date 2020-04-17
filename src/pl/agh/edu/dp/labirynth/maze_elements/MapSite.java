package pl.agh.edu.dp.labirynth.maze_elements;

import pl.agh.edu.dp.gui.ElementImage;
import pl.agh.edu.dp.labirynth.Player;

public abstract class MapSite {
    public abstract void enter(Player player);

    public abstract ElementImage getImage();
}
