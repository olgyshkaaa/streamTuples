package stream.util;

import stream.Main;
import stream.model.AverageTuple;

import java.io.IOException;
import java.io.InputStream;
import java.rmi.AccessException;
import java.util.Properties;
import java.util.regex.Pattern;

/*
 * Utility data formatting class
 */
public class DataUtil {

    DataUtil(){
        throw new IllegalStateException("Utility class");
    }

    /**
     * Preparing average data array
     * zero value installation
     * @param data average data array
     * @return zero value array
     */
    static AverageTuple[] prepareData(AverageTuple[] data) {
        for (int i = 0; i < data.length; i++) {
            data[i] = new AverageTuple();
        }
        return data;
    }

    /**
     * Input stream formatting class
     * @param tuple string tuple patients information
     * @return array of integer  with patients information
     */
    static Integer[] formatInputStream(String tuple) {
        String[] tupleSplit = tuple.split(Pattern.quote("|"));
        Integer[] tupleInt = new Integer[3];
        tupleInt[0] = Integer.parseInt(tupleSplit[0]);
        tupleInt[1] = Integer.parseInt(tupleSplit[1]);
        tupleInt[2] = Integer.parseInt(tupleSplit[2].replace("\\n", ""));
        return tupleInt;
    }

    /**
     * Output stream formatting class
     * @param tuples  array of average patients information
     * @return string tuple average patients information
     */
    static String formatOutputStream(AverageTuple[] tuples) {
        StringBuilder output = new StringBuilder();
        for (AverageTuple tuple : tuples) {
            output.append(tuple.getCount() == 0 ?
                    "|" : String.valueOf(tuple.getSum() / tuple.getCount()) + "|");
        }
        return output.substring(0, output.length() - 1);
    }


}
