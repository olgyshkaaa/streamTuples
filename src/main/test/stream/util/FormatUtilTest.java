package stream.util;

import org.junit.Test;
import stream.model.AverageTuple;

import static org.junit.Assert.*;



public class FormatUtilTest {

    @Test
    public void testPrepareData() {
        AverageTuple[] data = new AverageTuple[3];
        FormatUtil.prepareData(data);
        assertEquals(data[1].getCount(), (Integer) 0 );
        assertEquals(data[2].getSum(), (Integer) 0 );
    }

    @Test
    public void testFormatInputStream() {
        String tuple = "1|45|80\\n";
        Integer[] data = FormatUtil.formatInputStream(tuple);
        assertEquals(data[0], (Integer) 1);
        assertEquals(data[1], (Integer) 45);
        assertEquals(data[2], (Integer) 80);
    }

    @Test
    public void testFormatOutputStream() {
        AverageTuple[] data = FormatUtil.prepareData(new AverageTuple[3]);
        data[0] = new AverageTuple();
        data[1] = new AverageTuple(3,2);
        data[2] = new AverageTuple(10, 3);
        String str = FormatUtil.formatOutputStream(data);
        assertEquals(str, "|1|3|");
        data[0] = new AverageTuple(3,2);
        data[1] = new AverageTuple();
        data[2] = new AverageTuple(10, 3);
        str = FormatUtil.formatOutputStream(data);
        assertEquals(str, "1||3|");
        data[0] = new AverageTuple(3,2);
        data[1] = new AverageTuple(10, 3);
        data[2] = new AverageTuple();
        str = FormatUtil.formatOutputStream(data);
        assertEquals(str, "1|3||");
        data[0] =new AverageTuple();
        data[1] =new AverageTuple();
        data[2] = new AverageTuple();
        str = FormatUtil.formatOutputStream(data);
        assertEquals(str, "|||");
    }
}