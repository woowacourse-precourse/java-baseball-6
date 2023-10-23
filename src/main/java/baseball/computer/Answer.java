package baseball.computer;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Answer {
    private static final int VALID_LENGTH = 3;
    private static final int MIN_VALID_DIGIT = 1;
    private static final int MAX_VALID_DIGIT = 9;
    private static final int FIRST_CHARACTER_INDEX = 0;

    private final List<Character> answerAsChars = new ArrayList<>();

    public Answer() {
        while (answerAsChars.size() < VALID_LENGTH) {
            addUniqueRandomNumber(generateRandomNumber());
        }
    }

    private char generateRandomNumber() {
        int randomIntNumber = Randoms.pickNumberInRange(MIN_VALID_DIGIT, MAX_VALID_DIGIT);
        return (char) ('0' + randomIntNumber);
    }

    private void addUniqueRandomNumber(char randomNumber) {
        if (!answerAsChars.contains(randomNumber)) {
            answerAsChars.add(randomNumber);
        }
    }
}
