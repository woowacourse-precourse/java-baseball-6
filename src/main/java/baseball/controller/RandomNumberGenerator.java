package baseball.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {

    private static final int BASEBALL_GAME_NUMBER_LENGTH = BaseBallConstants.BASEBALL_GAME_NUMBER_LENGTH;
    private static final int MIN_NUMBER = (int) BaseBallConstants.MIN_DIGIT - '0';
    private static final int MAX_NUMBER = (int) BaseBallConstants.MAX_DIGIT - '0';

    public List<Integer> GenerateRandomNumber() {
        List<Integer> generatedNumbers = new ArrayList<>();
        while (generatedNumbers.size() < BASEBALL_GAME_NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!generatedNumbers.contains(randomNumber)) {
                generatedNumbers.add(randomNumber);
            }
        }
        return generatedNumbers;
    }
}
