package baseball.model;

import java.util.List;

public class Numbers {

    private Integer first;
    private Integer second;
    private Integer third;

    public Numbers() {
    }

    public Numbers(Integer first, Integer second, Integer third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public static Numbers from(List<Integer> numbers) {
        return new Numbers(numbers.get(0), numbers.get(1), numbers.get(2));
    }

    public Integer countIdentity(Numbers numbers) {
        return (this.first.equals(numbers.first) ? 1 : 0) +
                (this.second.equals(numbers.second) ? 1 : 0) +
                (this.third.equals(numbers.third) ? 1 : 0);
    }

    public Integer countEquality(Numbers numbers) {
        return (this.first.equals(numbers.second) || this.first.equals(numbers.third) ? 1 : 0) +
                (this.second.equals(numbers.first) || this.second.equals(numbers.third) ? 1 : 0) +
                (this.third.equals(numbers.first) || this.third.equals(numbers.second) ? 1 : 0);
    }
}
