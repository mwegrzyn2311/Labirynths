package pl.agh.edu.dp.labirynth.utils;

public enum Direction {
    NORTH, SOUTH, EAST, WEST;

    public static Direction vectorToDirection(int i, int j) {
        if(i == 1 && j == 0) {
            return EAST;
        } else if(i == 0 && j == -1) {
            return SOUTH;
        } else if(i == -1 && j == 0) {
            return WEST;
        } else if(i == 0 && j == 1) {
            return NORTH;
        } else {
            throw new IllegalArgumentException("Cannot convert given (i="+i+", j="+j+") to Direction!");
        }
    }

    public Direction opposite() {
        switch(this) {
            case NORTH:
                return SOUTH;
            case SOUTH:
                return NORTH;
            case EAST:
                return WEST;
            case WEST:
                return EAST;
        }
        return null;
    }
}