package stream.util;

import stream.model.AverageTuple;

import java.util.regex.Pattern;

public class FormatUtil {

    public static AverageTuple[] prepareData(AverageTuple[] data) {
        for (int i = 0; i < data.length; i++) {
            data[i] = new AverageTuple();
        }
        return data;
    }

    public static Integer[] formatInputStream(String tuple) {
        String[] tupleSplit = tuple.split(Pattern.quote("|"));
        Integer[] tupleInt = new Integer[3];
        tupleInt[0] = Integer.parseInt(tupleSplit[0]);
        tupleInt[1] = Integer.parseInt(tupleSplit[1]);
        tupleInt[2] = Integer.parseInt(tupleSplit[2].replace("\\n",""));
        return tupleInt;
    }

    public static String formatOutputStream(AverageTuple[] tuples) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < tuples.length; i++) {
            output.append(tuples[i].getCount() == 0 ?
                    "|" : String.valueOf(tuples[i].getSum() / tuples[i].getCount()) + "|");
        }
        return output.toString();
    }


}
