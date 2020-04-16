package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.gui.ElementImage;

public class Wall extends MapSite {
    public Wall(){

    }

    @Override
    public void enter(){

    }

    @Override
    public ElementImage getImage() {
        return ElementImage.WALL;
    }
}
