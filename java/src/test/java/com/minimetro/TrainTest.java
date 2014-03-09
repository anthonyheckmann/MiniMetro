package com.minimetro;

import junit.framework.TestCase;

import org.junit.Assert;

import com.minimetro.Train.Speed;

import static com.minimetro.Line.Color.RED;
import static com.minimetro.Terminal.Type.CIRCLE;
import static com.minimetro.Terminal.Type.SQUARE;
import static com.minimetro.Terminal.Type.TRIANGLE;
import static com.minimetro.Train.Speed.FAST;

public class TrainTest extends TestCase {
    private Route route;

    private Terminal terminal1;
    private Terminal terminal2;
    private Terminal terminal3;

    private Segment segment1;
    private Segment segment2;

    private Line line;

    private Train train;

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

        train = new Train(line);
    }

    public void testTrainHasACapacity() {
        Assert.assertEquals(8, train.getCapacity());
    }

    public void testTrainHasASpeed() {
        Assert.assertNotNull(train.getSpeed());
    }

    public void testTrainHasALine() {
        Assert.assertNotNull(train.getLine());
    }

    public void testAdjustingTrainCapacity() {
        int newCapacity = 10;

        train.setCapacity(newCapacity);
        Assert.assertEquals(newCapacity, train.getCapacity());
        Assert.assertEquals(10, train.getCapacity());
    }

    public void testAdjustingTrainSpeed() {
        Speed newSpeed = FAST;

        train.setSpeed(newSpeed);
        Assert.assertEquals(newSpeed, train.getSpeed());
        Assert.assertEquals(FAST, train.getSpeed());
    }
}
