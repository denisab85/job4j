package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

public class PointTest {

    @Test
    public void whenPoint1x0y0AndPoint2x30y20ThenDistance36() {
        Point point1 = new Point(0, 0);
        Point point2 = new Point(30, 20);
        double result = point1.distanceTo(point2);
        assertThat(result, closeTo(36, 0.1));
    }

}
