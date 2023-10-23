package baseball.model;

import java.util.List;

public class Numbers {

    private Integer first;
    private Integer second;
    private Integer third;

    public Numbers from(List<Integer> numbers) {
        this.first = numbers.get(0);
        this.second = numbers.get(1);
        this.third = numbers.get(2);
        return this;
    }

    public Integer countIdentity(Numbers numbers) {
        return (this.first.equals(numbers.first) ? 1 : 0) +
                (this.second.equals(numbers.second) ? 1 : 0) +
                (this.third.equals(numbers.third) ? 1 : 0);
    }

    public Integer countEquality(Numbers numbers) {
        return (this.first.equals(numbers.second) || this.first.equals(numbers.third) ? 1 : 0) +
                (this.second.equals(numbers.first) || this.second.equals(numbers.third) ? 1 : 0) +
                (this.third.equals(numbers.first) || this.second.equals(numbers.second) ? 1 : 0);
    }
}
