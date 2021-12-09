package ru.stqa.jft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {
    @Test
    public void testDistancePoint() {
        Point a = new Point(5.5,5.5);
        Point b = new Point(10.0,10.0);
        Assert.assertEquals(a.distance(a, b), 6.363961030678928);
    }
}
