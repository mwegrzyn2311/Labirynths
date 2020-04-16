package pl.agh.edu.dp.labirynth;

public enum Direction {
    North, South, East, West;

    public static Direction vectorToDirection(int i, int j) {
        if(i == 1 && j == 0) {
            return East;
        } else if(i == 0 && j == -1) {
            return South;
        } else if(i == -1 && j == 0) {
            return West;
        } else if(i == 0 && j == 1) {
            return North;
        } else {
            throw new IllegalArgumentException("Cannot convert given (i="+i+", j="+j+") to Direction!");
        }
    }
}