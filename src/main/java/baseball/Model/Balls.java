package baseball.Model;

import java.util.List;

public class Balls {

    private List<Integer> numbers;

    public Balls(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int countSameNumber(Balls computerBalls) {
        int count = 0;
        List<Integer> computerNumbers = computerBalls.getNumbers();
        for (int number : numbers) {
            if (computerNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public int countSameIndexAndNumber(Balls computerBalls) {
        int count = 0;
        List<Integer> computerNumbers = computerBalls.getNumbers();
        for (int index = 0; index <= 2; index++) {
            if (numbers.get(index) == computerNumbers.get(index)) {
                count++;
            }
        }
        return count;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
