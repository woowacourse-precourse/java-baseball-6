package baseball.model;

import baseball.service.BaseballGame;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final List<Integer> numbers = new ArrayList<>();

    public void generateNumber() {
        numbers.clear();
        while (numbers.size() < BaseballGame.NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(BaseballGame.NUMBER_RANGE_START,
                    BaseballGame.NUMBER_RANGE_END);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }

    public GameResult compareWithInput(List<Integer> input, int numberSize) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < numberSize; i++) {
            if (numbers.get(i).equals(input.get(i))) {
                strike++;
            } else {
                if (numbers.contains(input.get(i))) {
                    ball++;
                }
            }
        }
        return GameResult.from(strike, ball);
    }
}
