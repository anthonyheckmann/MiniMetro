package com.minimetro;

public class Line {
    public enum Color {
        RED, GREEN, YELLOW, BLUE, ORANGE, PURPLE;
    }

    private final Color color;
    private final Route route;

    public Line(Color color, Route route) {
        this.color = color;
        this.route = route;
    }

    public Color getColor() {
        return color;
    }

    public Route getRoute() {
        return route;
    }

    @Override
    public String toString() {
        return "Line{" +
            "color=" + color +
            ", route=" + route +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Line line = (Line) o;

        if (color != line.color) return false;
        if (route != null ? !route.equals(line.route) : line.route != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = color != null ? color.hashCode() : 0;
        result = 31 * result + (route != null ? route.hashCode() : 0);
        return result;
    }
}
