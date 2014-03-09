package com.minimetro;

public class Train {
    private static final int INIT_CAPACITY = 8;

    public enum Speed {
        SLOWEST, SLOWER, SLOW, NORMAL, FAST, FASTER, FASTEST;
    }

    private int capacity = INIT_CAPACITY;
    private Speed speed = Speed.NORMAL;

    private final Line line;

    public Train(Line line) {
        this.line = line;
    }

    public int getCapacity() {
        return capacity;
    }

    public Speed getSpeed() {
        return speed;
    }

    public Line getLine() {
        return line;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setSpeed(Speed speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Train{" +
            "capacity=" + capacity +
            ", speed=" + speed +
            ", line=" + line +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Train train = (Train) o;

        if (capacity != train.capacity) return false;
        if (line != null ? !line.equals(train.line) : train.line != null) return false;
        if (speed != train.speed) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = capacity;
        result = 31 * result + (speed != null ? speed.hashCode() : 0);
        result = 31 * result + (line != null ? line.hashCode() : 0);
        return result;
    }
}
