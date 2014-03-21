package com.minimetro;

import com.google.common.collect.Sets;

import java.util.Arrays;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import static java.lang.Integer.MAX_VALUE;

public class Terminal {
    public enum Type {
        SQUARE, CIRCLE, HOUSE, PLUS, TRIANGLE, FAN, HEXAGON, STAR;

        static Type randomTerminal(Random random) {
            int index = random.nextInt(MAX_VALUE);
            int size = values().length;

            return values()[index % size];
        }
    }

    public enum Upgrade {
        TUNNEL, CAPACITY, SPEED;

        static Set<Upgrade> initialUpgrades() {
            return Sets.newHashSet(Arrays.asList(TUNNEL, CAPACITY));
        }
    }

    private static final Random random;
    static {
        random = new Random();
    }

    private final Type type;
    private final UUID uuid;
    private final Set<Upgrade> upgrades;

    public Terminal() {
        this(Type.randomTerminal(random));
    }

    public Terminal(Type type) {
        this.type = type;

        uuid = UUID.randomUUID();
        upgrades = Upgrade.initialUpgrades();
    }

    public Type getType() {
        return type;
    }

    public UUID getUuid() {
        return uuid;
    }

    public Set<Upgrade> getUpgrades() {
        return upgrades;
    }

    @Override
    public String toString() {
        return "Terminal{" +
            "type=" + type +
            ", uuid=" + uuid +
            ", upgrades=" + upgrades +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Terminal terminal = (Terminal) o;

        if (type != terminal.type) return false;
        if (upgrades != null ? !upgrades.equals(terminal.upgrades) : terminal.upgrades != null)
            return false;
        if (uuid != null ? !uuid.equals(terminal.uuid) : terminal.uuid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (uuid != null ? uuid.hashCode() : 0);
        result = 31 * result + (upgrades != null ? upgrades.hashCode() : 0);
        return result;
    }
}