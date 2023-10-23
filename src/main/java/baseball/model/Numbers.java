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
}
