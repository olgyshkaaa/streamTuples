package stream.util;

import stream.model.AverageTuple;
import stream.model.Tuple;

import java.util.Map;
import java.util.regex.Pattern;

public class FormatUtil {

    public static AverageTuple[] prepareData(AverageTuple[] data) {
        for (int i = 0; i < data.length; i++) {
            data[i] = new AverageTuple();
        }
        return data;
    }

    public static void formatInputStream(String tuple, Map<Integer, Tuple> patients, AverageTuple[] data) {
        String[] tupleSplit = tuple.split(Pattern.quote("|"));
        Integer id = Integer.parseInt(tupleSplit[0]);
        Integer age = Integer.parseInt(tupleSplit[1]);
        Integer weight = Integer.parseInt(tupleSplit[2].trim());

        if (patients.get(id) == null) {
            patients.put(id, new Tuple(age, weight));
            CalculateUtil.addData(age, weight, data);
        } else {
            if (patients.get(id).getAge() > age) {
                patients.put(id, new Tuple(age, weight));
                CalculateUtil.changeData(age, weight, data);
                CalculateUtil.addData(age, weight, data);
            }
        }
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
