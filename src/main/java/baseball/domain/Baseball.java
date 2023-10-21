package baseball.domain;

import baseball.util.BaseballValidator;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Baseball {

    private List<Integer> numbers;

    public Baseball() {
        numbers = new ArrayList<>();
    }

    public Baseball(List<Integer> numbers) {
        BaseballValidator.validate(numbers);
        this.numbers = numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        BaseballValidator.validate(numbers);
        this.numbers = numbers;
    }

    public int countSameNumbers(Baseball compare) {
        return (int) compare.numbers.stream()
                .filter(number -> numbers.contains(number))
                .count();
    }

    public int countSameNumbersByIndex(Baseball compare) {
        return (int) IntStream.range(0, numbers.size())
                .filter(index -> numbers.get(index).equals(compare.numbers.get(index)))
                .count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Baseball baseBall = (Baseball) o;
        return Objects.equals(numbers, baseBall.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
