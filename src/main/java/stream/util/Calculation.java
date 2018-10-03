package stream.util;

import stream.model.AverageTuple;
import stream.model.Tuple;

import java.util.HashMap;
import java.util.Map;

public class Calculation {
    static final int AGE_INTERVALS = 8;
    private  Map<Integer, Tuple> patients = new HashMap<Integer, Tuple>();
    private  AverageTuple[] data = FormatUtil.prepareData(new AverageTuple[AGE_INTERVALS]);


    public  AverageTuple[] calculateAverage(Integer[] info){
        Integer id = info[0];
        Integer age = info[1];
        Integer weight = info[2];
        if (patients.get(id) == null) {
            patients.put(id, new Tuple(age, weight));
            addData(age, weight, data);
        } else {
            if (patients.get(id).getAge() < age) {
                changeData(patients.get(id).getAge(), patients.get(id).getWeight(), data);
                addData(age, weight, data);
                patients.put(id, new Tuple(age, weight));
            }
        }
        return data;
    }

    private  void addData(Integer age, Integer weight, AverageTuple[] data) {
        Integer index = age / 10;
        data[index].setCount(data[index].getCount() + 1);
        data[index].setSum(data[index].getSum() + weight);
    }

    private  void changeData(Integer age, Integer weight, AverageTuple[] data) {
        Integer index = age / 10;
        data[index].setCount(data[index].getCount() - 1);
        data[index].setSum(data[index].getSum() - weight);
    }
}
