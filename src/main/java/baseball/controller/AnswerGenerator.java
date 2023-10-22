package baseball.controller;

import static baseball.model.GameNumbers.GAME_NUMBERS_SIZE;

import baseball.model.Game;
import baseball.model.GameNumbers;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class AnswerGenerator {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;

    public GameNumbers generateAnswer() {
        List<Integer> list = new ArrayList<>(GAME_NUMBERS_SIZE);
        for (int i = 0; i < GAME_NUMBERS_SIZE; i++) {
            int randomNumber = getRandomValueNotInList(list, START_INCLUSIVE, END_INCLUSIVE);
            list.add(randomNumber);
        }
        return new GameNumbers(list);
    }

    private static int getRandomValueNotInList(List<Integer> list, final int startInclusive,
            final int endInclusive) {
        int randomNumber = Randoms.pickNumberInRange(startInclusive, endInclusive);
        while (list.contains(randomNumber)) {
            randomNumber = Randoms.pickNumberInRange(startInclusive, endInclusive);
        }
        return randomNumber;
    }
}
