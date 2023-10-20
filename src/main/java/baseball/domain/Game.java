package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
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
        return 0;
    }

    public int countBall(GameNumber inputNumber) {
        return 0;
    }
}
