package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    private static final int START_RANGE_NUMBER = 1;
    private static final int END_RANGE_NUMBER = 9;
    private List<Integer> numbers = new ArrayList<>();

    public BaseballGame(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void init() {
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(START_RANGE_NUMBER,END_RANGE_NUMBER);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }

    public GameResult compare(String inputNumbers) {
        String[] splitInputNumbers = inputNumbers.split("");
        GameResult result = new GameResult();
        for (int i = 0; i < 3; i++) {
            if (numbers.get(i) == toInt(splitInputNumbers[i])) {
                result.strike();
                continue;
            }
            if (numbers.contains(toInt(splitInputNumbers[i]))) {
                result.ball();
            }
        }
        return result;
    }

    private int toInt(String str) {
        return Integer.parseInt(str);
    }

    public void resetNumbers() {
        numbers.clear();
        init();
    }
}
