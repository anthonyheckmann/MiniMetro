package com.minimetro;

import java.util.Random;
import java.util.UUID;

import static java.lang.Integer.MAX_VALUE;

public class Terminal {
    public enum Type {
        SQUARE, CIRCLE, HOUSE, PLUS, TRIANGLE, FAN, HEXAGON, STAR;

        static Type randomTerminal() {
            int index = random.nextInt(MAX_VALUE);
            int size = values().length;

            return values()[index % size];
        }
    }

    static {
        random = new Random();
    }

    private final Type type;
    private final UUID uuid;

    private static final Random random;

    public Terminal() {
        this(Type.randomTerminal());
    }

    public Terminal(Type type) {
        this.type = type;

        uuid = UUID.randomUUID();
    }

    public Type getType() {
        return type;
    }

    public UUID getUuid() {
        return uuid;
    }

    @Override
    public String toString() {
        return "Terminal{" +
            "type=" + type +
            ", uuid=" + uuid +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Terminal terminal = (Terminal) o;

        if (type != terminal.type) return false;
        if (uuid != null ? !uuid.equals(terminal.uuid) : terminal.uuid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (uuid != null ? uuid.hashCode() : 0);
        return result;
    }
}