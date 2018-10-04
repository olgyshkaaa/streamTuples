package stream.util;


import org.junit.Test;
import stream.model.OutgoingTuple;

import static org.junit.Assert.assertEquals;

/*
 * Average data calculation class testing
 */
public class CalculatorTest {

    @Test
    public void testCalculateAverage() {
        Calculator calculator = new Calculator();
        Integer[] data1 = {1, 45, 80};
        OutgoingTuple[] result1 = calculator.calculateAverage(data1);
        assertEquals((Integer) 80, result1[4].getSum());
        assertEquals((Integer) 1, result1[4].getCount());
        Integer[] data2 = {2, 40, 60};
        OutgoingTuple[] result2 = calculator.calculateAverage(data2);
        assertEquals((Integer) 140, result2[4].getSum());
        assertEquals((Integer) 2, result2[4].getCount());
        Integer[] data3 = {3, 69, 80};
        OutgoingTuple[] result3 = calculator.calculateAverage(data3);
        assertEquals((Integer) 80, result3[6].getSum());
        assertEquals((Integer) 1, result3[6].getCount());
        Integer[] data4 = {3, 70, 80};
        OutgoingTuple[] result4 = calculator.calculateAverage(data4);
        assertEquals((Integer) 0, result4[6].getSum());
        assertEquals((Integer) 0, result4[6].getCount());
        assertEquals((Integer) 80, result4[7].getSum());
        assertEquals((Integer) 1, result4[7].getCount());
    }

}