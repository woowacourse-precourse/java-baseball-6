package baseball.model.numbers;

import static baseball.model.numbers.GameNumbers.GAME_NUMBERS_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomAnswerGenerator implements AnswerGenerator {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;

    public GameNumbers generateAnswer() {
        List<Integer> list = new ArrayList<>(GAME_NUMBERS_SIZE);
        for (int i = 0; i < GAME_NUMBERS_SIZE; i++) {
            int randomNumber = getRandomValueNotInList(list);
            list.add(randomNumber);
        }
        return new GameNumbers(list);
    }

    private int getRandomValueNotInList(List<Integer> list) {
        int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
        while (list.contains(randomNumber)) {
            randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
        }
        return randomNumber;
    }
}
