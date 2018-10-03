package stream.model;

/*
 * Model for information about one person
 */
public class Tuple {
    private Integer age;
    private Integer weight;

    public Tuple(Integer age, Integer weight) {
        this.age = age;
        this.weight = weight;
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
