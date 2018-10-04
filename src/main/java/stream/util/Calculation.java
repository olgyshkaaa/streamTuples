package stream.util;

import stream.model.AverageTuple;
import stream.model.Tuple;

import java.util.HashMap;
import java.util.Map;

/*
 * Average data calculation class
 */
public class Calculation {
    private static final int AGE_INTERVALS = 8;
    private  Map<Integer, Tuple> patients = new HashMap<Integer, Tuple>();
    private  AverageTuple[] data = DataUtil.prepareData(new AverageTuple[AGE_INTERVALS]);

    /**
     * Average patients information calculation
     * @param info information about one patient
     * @return array of average patients information
     */
    AverageTuple[] calculateAverage(Integer[] info){
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

    /**
     * Add new information about patient to the average value
     * @param age new patient age
     * @param weight new patient weight
     * @param data average patients information array
     */
    private  void addData(Integer age, Integer weight, AverageTuple[] data) {
        Integer index = age / 10;
        data[index].setCount(data[index].getCount() + 1);
        data[index].setSum(data[index].getSum() + weight);
    }

    /**
     * Delete incorrect information from the average value
     * @param age previous patient age
     * @param weight previous patient weight
     * @param data average patients information array
     */
    private  void changeData(Integer age, Integer weight, AverageTuple[] data) {
        Integer index = age / 10;
        data[index].setCount(data[index].getCount() - 1);
        data[index].setSum(data[index].getSum() - weight);
    }
}
