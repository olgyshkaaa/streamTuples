package stream.model;

/*
 * Model for average data calculation
 */
public class Tuple {
    private Integer age;
    private Integer weight;

    public Tuple(Integer age, Integer count) {
        this.age = age;
        this.weight = count;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
