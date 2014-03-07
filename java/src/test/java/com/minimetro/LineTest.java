package com.minimetro;

import junit.framework.TestCase;

import org.junit.Assert;

import static com.minimetro.Terminal.Type.CIRCLE;
import static com.minimetro.Terminal.Type.HOUSE;
import static com.minimetro.Terminal.Type.SQUARE;

public class LineTest extends TestCase {
    private Terminal squareTerminal;
    private Terminal houseTerminal;
    private Terminal circleTerminal;

    private Line line1;
    private Line line2;

    public void setUp() throws Exception {
        squareTerminal = new Terminal(SQUARE);
        houseTerminal = new Terminal(HOUSE);
        circleTerminal = new Terminal(CIRCLE);

        line1 = new Line(squareTerminal, houseTerminal);
        line2 = new Line(circleTerminal, houseTerminal);
    }

    public void testLineHasFromTerminal() {
        Assert.assertNotNull(line1.getFromTerminal());
        Assert.assertNotNull(line2.getFromTerminal());
    }

    public void testLineHasToTerminal() {
        Assert.assertNotNull(line1.getToTerminal());
        Assert.assertNotNull(line2.getToTerminal());
    }

    public void testLineMustHaveUniqueFromAndToTerminals() {
        Throwable thrown = null;

        try {
            new Line(squareTerminal, squareTerminal);
        } catch(Throwable e) {
            thrown = e;
        }

        Assert.assertNotNull(thrown);
        Assert.assertTrue(thrown instanceof IllegalArgumentException);
    }
}
