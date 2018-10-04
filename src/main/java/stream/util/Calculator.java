package stream.util;

import stream.model.OutgoingTuple;
import stream.model.IncomingTuple;

import java.util.HashMap;
import java.util.Map;

/*
 * Average data calculation class
 */
public class Calculator {
    private static final int AGE_INTERVALS = 8;
    private Map<Integer, IncomingTuple> patients = new HashMap<Integer, IncomingTuple>();
    private OutgoingTuple[] data = DataUtil.prepareData(new OutgoingTuple[AGE_INTERVALS]);

    /**
     * Average patients information calculation
     * @param info information about one patient
     * @return array of average patients information
     */
    public OutgoingTuple[] calculateAverage(Integer[] info) {
        Integer id = info[0];
        Integer age = info[1];
        Integer weight = info[2];
        if (patients.get(id) == null) {
            patients.put(id, new IncomingTuple(age, weight));
            addData(age, weight, data);
        } else {
            if (patients.get(id).getAge() < age) {
                deleteOldData(patients.get(id).getAge(), patients.get(id).getWeight(), data);
                addData(age, weight, data);
                patients.put(id, new IncomingTuple(age, weight));
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
    private void addData(Integer age, Integer weight, OutgoingTuple[] data) {
        Integer index = age / 10;
        data[index].setCount(data[index].getCount() + 1);
        data[index].setSum(data[index].getSum() + weight);
    }

    /**
     * Delete irrelevant information from the average value
     * @param age previous patient age
     * @param weight previous patient weight
     * @param data average patients information array
     */
    private void deleteOldData(Integer age, Integer weight, OutgoingTuple[] data) {
        Integer index = age / 10;
        data[index].setCount(data[index].getCount() - 1);
        data[index].setSum(data[index].getSum() - weight);
    }
}
