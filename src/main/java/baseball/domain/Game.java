package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {
    private static final int START = 1;
    private static final int END = 9;

    private final GameNumber answerNumber;

    public Game() {
        answerNumber = createAnswerNumber();
    }

    private GameNumber createAnswerNumber() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < 3) {
            numbers.add(Randoms.pickNumberInRange(START, END));
        }
        return new GameNumber(numbers);
    }

    public int countStrike(GameNumber inputNumber) {
        int strike = 0;
        List<Integer> inputNumberList = inputNumber.getNumbers();
        List<Integer> answerNumberList = answerNumber.getNumbers();

        for (int idx = 0; idx < inputNumberList.size(); idx++) {
            strike += isStrike(inputNumberList.get(idx), answerNumberList.get(idx));
        }
        return strike;
    }

    private int isStrike(int number1, int number2) {
        if (number1 != number2) {
            return 0;
        }
        return 1;
    }

    public int countBall(GameNumber inputNumber) {
        return 0;
    }
}
