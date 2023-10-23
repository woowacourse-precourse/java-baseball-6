package baseball.domain;

import java.util.List;

public record Computer(List<Integer> numbers) {
    public Computer {
        System.out.println(numbers);
    }

}
