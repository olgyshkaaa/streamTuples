package stream.util;

import stream.model.AverageTuple;

public class CalculateUtil {

    public static void addData(Integer age, Integer weight, AverageTuple[] data) {
        Integer index = new Integer(age / 10);
        data[index].setCount(data[index].getCount() + 1);
        data[index].setSum(data[index].getSum() + weight);
    }

    public static void changeData(Integer age, Integer weight, AverageTuple[] data) {
        Integer index = new Integer(age / 10);
        data[index].setCount(data[index].getCount() - 1);
        data[index].setSum(data[index].getSum() - weight);
    }
}
