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
