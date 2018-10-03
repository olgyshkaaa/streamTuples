package stream.model;

/*
 * Model for average data calculation
 */
public class AverageTuple {
    private Integer sum;
    private Integer count;

    public AverageTuple() {
        this.sum = 0;
        this.count = 0;
    }

    public AverageTuple(Integer sum, Integer count) {
        this.sum = sum;
        this.count = count;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
