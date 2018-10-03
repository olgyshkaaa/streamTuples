package stream.util;


import org.junit.Test;
import stream.model.AverageTuple;

import static org.junit.Assert.assertEquals;

public class CalculationTest {

    @Test
    public void testCalculateAverage() {
        Calculation calculation = new Calculation();
        Integer[] data1 = {1, 45, 80};
        AverageTuple[] result1 = calculation.calculateAverage(data1);
        assertEquals((Integer) 80, result1[4].getSum());
        assertEquals((Integer) 1, result1[4].getCount());
        Integer[] data2 = {2, 40, 60};
        AverageTuple[] result2 = calculation.calculateAverage(data2);
        assertEquals((Integer) 140, result2[4].getSum());
        assertEquals((Integer) 2, result2[4].getCount());
        Integer[] data3 = {3, 63, 80};
        AverageTuple[] result3 = calculation.calculateAverage(data3);
        assertEquals((Integer) 80, result3[6].getSum());
        assertEquals((Integer) 1, result3[6].getCount());
        Integer[] data4 = {3, 73, 80};
        AverageTuple[] result4 = calculation.calculateAverage(data4);
        assertEquals((Integer) 0, result4[6].getSum());
        assertEquals((Integer) 0, result4[6].getCount());
        assertEquals((Integer) 80, result4[7].getSum());
        assertEquals((Integer) 1, result4[7].getCount());
    }

}