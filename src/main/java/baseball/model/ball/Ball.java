package baseball.model.ball;

import java.util.List;

public class Ball {

    private final List<Integer> numbers;

    public Ball(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean hasNumber(int number) {
        return this.numbers.contains(number);
    }

    public boolean isNumberMatchExactlyInPlaceNo(int placeNo, int number) {
        return this.numbers.get(placeNo) == number;
    }

    public int getNumberOfPlace(int placeNo) {
        return this.numbers.get(placeNo);
    }

}
