package com.minimetro;

import junit.framework.TestCase;

import org.junit.Assert;

import static com.minimetro.Terminal.Type.CIRCLE;
import static com.minimetro.Terminal.Type.HOUSE;
import static com.minimetro.Terminal.Type.SQUARE;

public class SegmentTest extends TestCase {
    private Terminal squareTerminal;
    private Terminal houseTerminal;
    private Terminal circleTerminal;

    private Segment segment1;
    private Segment segment2;

    public void setUp() throws Exception {
        squareTerminal = new Terminal(SQUARE);
        houseTerminal = new Terminal(HOUSE);
        circleTerminal = new Terminal(CIRCLE);

        segment1 = new Segment(squareTerminal, houseTerminal);
        segment2 = new Segment(circleTerminal, houseTerminal);
    }

    public void testSegmentHasFromTerminal() {
        Assert.assertNotNull(segment1.getFromTerminal());
        Assert.assertNotNull(segment2.getFromTerminal());
    }

    public void testSegmentHasToTerminal() {
        Assert.assertNotNull(segment1.getToTerminal());
        Assert.assertNotNull(segment2.getToTerminal());
    }

    public void testSegmentMustHaveUniqueFromAndToTerminals() {
        Throwable thrown = null;

        try {
            new Segment(squareTerminal, squareTerminal);
        } catch(Throwable e) {
            thrown = e;
        }

        Assert.assertNotNull(thrown);
        Assert.assertTrue(thrown instanceof IllegalArgumentException);
    }
}
