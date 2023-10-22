package baseball.controller;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;

public class RandomUtility {
    private static final int ANSWER_LENGTH = 3;
    private static final int RANDOM_NUMBER_START = 1;
    private static final int RANDOM_NUMBER_END = 9;
    int[] answerNumbers = new int[ANSWER_LENGTH];

    public int[] generateAnswerNumbers() {
        for (int i = 0; i < answerNumbers.length; i++) {
            answerNumbers[i] = generateRandomNumber();
        }
        return answerNumbers;
    }

    private int generateRandomNumber() {
        while (true) {
            int randomNumber = Randoms.pickNumberInRange(RANDOM_NUMBER_START, RANDOM_NUMBER_END);
            if (isNotDuplicatedNumber(answerNumbers, randomNumber)) {
                return randomNumber;
            }

        }
    }

    private boolean isNotDuplicatedNumber(int[] answerNumbers, int randomNumber) {
        for (int i = 0; i < answerNumbers.length; i++) {
            if (answerNumbers[i] == randomNumber) {
                return false;
            }
        }
        return true;
    }
}
