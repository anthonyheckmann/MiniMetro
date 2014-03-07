package com.minimetro;

public class Line {
    private final Terminal fromTerminal;
    private final Terminal toTerminal;

    public Line(Terminal fromTerminal, Terminal toTerminal) {
        if(fromTerminal.equals(toTerminal)) {
            throw new IllegalArgumentException("The from terminal, " + fromTerminal.toString() +
                    ", cannot be the same as the to terminal, " + toTerminal.toString() + ".");
        }

        this.fromTerminal = fromTerminal;
        this.toTerminal = toTerminal;
    }

    public Terminal getFromTerminal() {
        return fromTerminal;
    }

    public Terminal getToTerminal() {
        return toTerminal;
    }

    @Override
    public String toString() {
        return "Line{" +
            "fromTerminal=" + fromTerminal +
            ", toTerminal=" + toTerminal +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Line line = (Line) o;

        if (fromTerminal != null ? !fromTerminal.equals(line.fromTerminal) : line.fromTerminal != null)
            return false;
        if (toTerminal != null ? !toTerminal.equals(line.toTerminal) : line.toTerminal != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fromTerminal != null ? fromTerminal.hashCode() : 0;
        result = 31 * result + (toTerminal != null ? toTerminal.hashCode() : 0);
        return result;
    }
}
