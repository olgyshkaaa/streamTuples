package stream.util;

import org.junit.Test;
import stream.model.OutgoingTuple;

import static org.junit.Assert.*;


/*
 * Utility data formatting class testing
 */
public class DataUtilTest {

    @Test
    public void testPrepareData() {
        OutgoingTuple[] data = new OutgoingTuple[3];
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
        OutgoingTuple[] data = DataUtil.prepareData(new OutgoingTuple[3]);
        data[0] = new OutgoingTuple();
        data[1] = new OutgoingTuple(3, 2);
        data[2] = new OutgoingTuple(10, 3);
        String str = DataUtil.formatOutputStream(data);
        assertEquals(str, "|1|3");
        data[0] = new OutgoingTuple(3, 2);
        data[1] = new OutgoingTuple();
        data[2] = new OutgoingTuple(10, 3);
        str = DataUtil.formatOutputStream(data);
        assertEquals(str, "1||3");
        data[0] = new OutgoingTuple(3, 2);
        data[1] = new OutgoingTuple(10, 3);
        data[2] = new OutgoingTuple();
        str = DataUtil.formatOutputStream(data);
        assertEquals(str, "1|3|");
        data[0] = new OutgoingTuple();
        data[1] = new OutgoingTuple();
        data[2] = new OutgoingTuple();
        str = DataUtil.formatOutputStream(data);
        assertEquals(str, "||");
    }
}