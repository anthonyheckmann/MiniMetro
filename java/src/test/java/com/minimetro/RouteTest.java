package com.minimetro;

import junit.framework.TestCase;

import org.junit.Assert;

import static com.minimetro.Terminal.Type.CIRCLE;
import static com.minimetro.Terminal.Type.SQUARE;
import static com.minimetro.Terminal.Type.TRIANGLE;

public class RouteTest extends TestCase {
    private Route route;

    private Terminal terminal1;
    private Terminal terminal2;
    private Terminal terminal3;

    private Segment segment1;
    private Segment segment2;

    public void setUp() throws Exception {
        route = new Route();

        terminal1 = new Terminal(SQUARE);
        terminal2 = new Terminal(CIRCLE);
        terminal3 = new Terminal(TRIANGLE);

        segment1 = new Segment(terminal1, terminal2);
        segment2 = new Segment(terminal2, terminal3);
    }

    public void testRouteHasAListOfSegments() {
        route.addSegment(segment1);
        route.addSegment(segment2);

        Assert.assertNotNull(route.getSegments());
        Assert.assertTrue(!route.isEmpty());
        Assert.assertEquals(2, route.size());
    }

    public void testSegmentNotAlreadyExistInRoute() {
        Throwable thrown = null;

        try {
            route.addSegment(segment1);
            route.addSegment(segment2);
            route.addSegment(segment1);
        } catch(Throwable e) {
            thrown = e;
        }

        Assert.assertNotNull(thrown);
        Assert.assertTrue(thrown instanceof IllegalArgumentException);
    }

    public void testLineRemovedFromRoute() {
        Segment newSegment = new Segment(terminal1, terminal3);

        route.addSegment(newSegment);
        Assert.assertTrue(route.removeSegment(newSegment));
    }
}
