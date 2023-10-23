package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.constants.BaseballGameConstants.*;

public class BaseballGame {

    private List<Integer> numbers = new ArrayList<>();

    public BaseballGame() {
    }

    public BaseballGame(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void init() {
        while (numbers.size() < GAME_NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(START_RANGE_NUMBER,END_RANGE_NUMBER);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        System.out.println("컴퓨터 숫자 : " + numbers.toString());
    }

    public GameResult compare(String inputNumbers) {
        String[] splitInputNumbers = inputNumbers.split("");
        GameResult result = new GameResult();
        for (int i = ZERO; i < GAME_NUMBER_SIZE; i++) {
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
    }
}
