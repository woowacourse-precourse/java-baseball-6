package baseball;

import baseball.enums.BaseBallType;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Computer {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int PICK_SIZE = 3;

    private List<Integer> numbers;

    public Computer() {
        numbers = new ArrayList<>();
    }

    private void init() {
        numbers.clear();
    }

    public void generateNumbers() {
        this.init();
        while (numbers.size() < PICK_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }

    public Map<BaseBallType, Integer> compareNumbers(String input) {
        int ballCount = 0, strikeCount = 0;

        for (int i = 0; i < PICK_SIZE; i++) {
            int inputNumber = input.charAt(i) - '0';
            if (numbers.get(i) == inputNumber) {
                strikeCount++;
            } else if (numbers.contains(inputNumber)) {
                ballCount++;
            }
        }
        return Map.of(BaseBallType.BALL, ballCount, BaseBallType.STRIKE, strikeCount);
    }

    public String getNumbers() {
        return numbers.toString();
    }
}
