package com.minimetro;

import junit.framework.TestCase;

import org.junit.Assert;

import static com.minimetro.Terminal.Type.CIRCLE;
import static com.minimetro.Terminal.Type.FAN;
import static com.minimetro.Terminal.Type.HEXAGON;
import static com.minimetro.Terminal.Type.HOUSE;
import static com.minimetro.Terminal.Type.PLUS;
import static com.minimetro.Terminal.Type.SQUARE;
import static com.minimetro.Terminal.Type.STAR;
import static com.minimetro.Terminal.Type.TRIANGLE;

public class TerminalTest extends TestCase {
    private Terminal terminal;

    public void setUp() throws Exception {
        terminal = new Terminal();
    }

    public void testTerminalHasType() {
        Assert.assertNotNull(terminal.getType());
    }

    public void testTerminalHasUuid() {
        Assert.assertNotNull(terminal.getUuid());
    }

    public void testTerminalHasUpgrades() {
        Assert.assertNotNull(terminal.getUpgrades());
    }

    public void testTerminalIsASquare() {
        Terminal squareTerminal = new Terminal(SQUARE);
        Assert.assertEquals(squareTerminal.getType(), SQUARE);
    }

    public void testTerminalIsACircle() {
        Terminal circleTerminal = new Terminal(CIRCLE);
        Assert.assertEquals(circleTerminal.getType(), CIRCLE);
    }

    public void testTerminalIsAHouse() {
        Terminal houseTerminal = new Terminal(HOUSE);
        Assert.assertEquals(houseTerminal.getType(), HOUSE);
    }

    public void testTerminalIsAPlus() {
        Terminal plusTerminal = new Terminal(PLUS);
        Assert.assertEquals(plusTerminal.getType(), PLUS);
    }

    public void testTerminalIsATriangle() {
        Terminal triangleTerminal = new Terminal(TRIANGLE);
        Assert.assertEquals(triangleTerminal.getType(), TRIANGLE);
    }

    public void testTerminalIsAFan() {
        Terminal fanTerminal = new Terminal(FAN);
        Assert.assertEquals(fanTerminal.getType(), FAN);
    }

    public void testTerminalIsAHexagon() {
        Terminal hexagonTerminal = new Terminal(HEXAGON);
        Assert.assertEquals(hexagonTerminal.getType(), HEXAGON);
    }

    public void testTerminalIsAStar() {
        Terminal starTerminal = new Terminal(STAR);
        Assert.assertEquals(starTerminal.getType(), STAR);
    }

    public void testANewTerminalIsUnique() {
        Terminal newTerminal = new Terminal();
        Assert.assertNotEquals(terminal, newTerminal);
    }

    public void testANewTerminalOfTheSameTypeIsUnique() {
        Terminal squareTerminal1 = new Terminal(SQUARE);
        Terminal squareTerminal2 = new Terminal(SQUARE);
        Assert.assertNotEquals(squareTerminal1, squareTerminal2);

        Terminal circleTerminal1 = new Terminal(CIRCLE);
        Terminal circleTerminal2 = new Terminal(CIRCLE);
        Assert.assertNotEquals(circleTerminal1, circleTerminal2);

        Terminal houseTerminal1 = new Terminal(HOUSE);
        Terminal houseTerminal2 = new Terminal(HOUSE);
        Assert.assertNotEquals(houseTerminal1, houseTerminal2);

        Terminal plusTerminal1 = new Terminal(PLUS);
        Terminal plusTerminal2 = new Terminal(PLUS);
        Assert.assertNotEquals(plusTerminal1, plusTerminal2);

        Terminal triangleTerminal1 = new Terminal(TRIANGLE);
        Terminal triangleTerminal2 = new Terminal(TRIANGLE);
        Assert.assertNotEquals(triangleTerminal1, triangleTerminal2);

        Terminal fanTerminal1 = new Terminal(FAN);
        Terminal fanTerminal2 = new Terminal(FAN);
        Assert.assertNotEquals(fanTerminal1, fanTerminal2);

        Terminal hexagonTerminal1 = new Terminal(HEXAGON);
        Terminal hexagonTerminal2 = new Terminal(HEXAGON);
        Assert.assertNotEquals(hexagonTerminal1, hexagonTerminal2);

        Terminal starTerminal1 = new Terminal(STAR);
        Terminal starTerminal2 = new Terminal(STAR);
        Assert.assertNotEquals(starTerminal1, starTerminal2);
    }
}
