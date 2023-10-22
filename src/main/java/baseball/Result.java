package baseball;

import java.util.List;

public class Result {
    private int ball;
    private int strike;

    public void calculate(List<Character> userNumbers, List<Character> randomNumbers) {
        for (int index = 0; index < userNumbers.size(); index++) {
            char number = userNumbers.get(index);

            if (isSameIndex(index, number, randomNumbers)) {
                strike++;
            }
        }
    }

    private boolean isSameIndex(int index, char number, List<Character> randomNumbers) {
        return index == randomNumbers.indexOf(number);
    }
}
