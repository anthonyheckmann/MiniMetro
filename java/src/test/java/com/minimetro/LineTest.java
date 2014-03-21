package com.minimetro;

import junit.framework.TestCase;

import org.junit.Assert;

import static com.minimetro.Line.Color.RED;
import static com.minimetro.Terminal.Type.CIRCLE;
import static com.minimetro.Terminal.Type.SQUARE;
import static com.minimetro.Terminal.Type.TRIANGLE;

public class LineTest extends TestCase {
    private Route route;

    private Terminal terminal1;
    private Terminal terminal2;
    private Terminal terminal3;

    private Segment segment1;
    private Segment segment2;

    private Line line;

    public void setUp() throws Exception {
        route = new Route();

        terminal1 = new Terminal(SQUARE);
        terminal2 = new Terminal(CIRCLE);
        terminal3 = new Terminal(TRIANGLE);

        segment1 = new Segment(terminal1, terminal2);
        segment2 = new Segment(terminal2, terminal3);

        route.addSegment(segment1);
        route.addSegment(segment2);

        line = new Line(RED, route);

        System.out.println(line);
    }

    public void testLineHasAColor() {
        Assert.assertNotNull(line.getColor());
    }

    public void testLineHasARoute() {
        Assert.assertNotNull(line.getRoute());
    }

    public void testLineAddedAnExtraSegmentToRoute() {
        Segment newSegment = new Segment(terminal1, terminal3);

        route.addSegment(newSegment);
        Assert.assertEquals(3, line.getRoute().size());
    }
}
