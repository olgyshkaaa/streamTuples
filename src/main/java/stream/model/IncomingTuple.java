package stream.model;

/*
 * Model for information about one person
 */
public class IncomingTuple {
    private Integer age;
    private Integer weight;

    public IncomingTuple(Integer age, Integer weight) {
        this.age = age;
        this.weight = weight;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getWeight() {
        return weight;
    }

}
