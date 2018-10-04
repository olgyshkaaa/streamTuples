package stream.util;

import org.junit.Test;
import stream.model.AverageTuple;

import static org.junit.Assert.*;


/*
 * Utility data formatting class testing
 */
public class DataUtilTest {

    @Test
    public void testPrepareData() {
        AverageTuple[] data = new AverageTuple[3];
        DataUtil.prepareData(data);
        assertEquals(data[1].getCount(), (Integer) 0 );
        assertEquals(data[2].getSum(), (Integer) 0 );
    }

    @Test
    public void testFormatInputStream() {
        String tuple = "1|45|80\\n";
        Integer[] data = DataUtil.formatInputStream(tuple);
        assertEquals(data[0], (Integer) 1);
        assertEquals(data[1], (Integer) 45);
        assertEquals(data[2], (Integer) 80);
    }

    @Test
    public void testFormatOutputStream() {
        AverageTuple[] data = DataUtil.prepareData(new AverageTuple[3]);
        data[0] = new AverageTuple();
        data[1] = new AverageTuple(3,2);
        data[2] = new AverageTuple(10, 3);
        String str = DataUtil.formatOutputStream(data);
        assertEquals(str, "|1|3");
        data[0] = new AverageTuple(3,2);
        data[1] = new AverageTuple();
        data[2] = new AverageTuple(10, 3);
        str = DataUtil.formatOutputStream(data);
        assertEquals(str, "1||3");
        data[0] = new AverageTuple(3,2);
        data[1] = new AverageTuple(10, 3);
        data[2] = new AverageTuple();
        str = DataUtil.formatOutputStream(data);
        assertEquals(str, "1|3|");
        data[0] =new AverageTuple();
        data[1] =new AverageTuple();
        data[2] = new AverageTuple();
        str = DataUtil.formatOutputStream(data);
        assertEquals(str, "||");
    }
}