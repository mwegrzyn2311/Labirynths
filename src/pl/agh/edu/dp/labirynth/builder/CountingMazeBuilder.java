package pl.agh.edu.dp.labirynth.builder;

public class CountingMazeBuilder extends MazeBuilder {
    private int roomsCount;
    private int doorsCount;

    @Override
    public void buildRoom(int number) {
        ++roomsCount;
    }

    @Override
    public void buildDoor(int from, int to) {
        ++doorsCount;
    }

    @Override
    public void clear() {
        super.clear();
        roomsCount = 0;
        doorsCount = 0;
    }

    public int getRoomCount() {
        return roomsCount;
    }

    public int getDoorCount() {
        return doorsCount;
    }
}
