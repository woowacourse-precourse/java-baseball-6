package baseball.controller;

import camp.nextstep.edu.missionutils.Randoms;


public class RandomUtility {
    private static final int ANSWER_LENGTH = 3;
    private static final int RANDOM_NUMBER_START = 1;
    private static final int RANDOM_NUMBER_END = 9;

    public int[] generateAnswerNumbers() {
        int[] answerNumbers = new int[ANSWER_LENGTH];
        for (int i = 0; i < answerNumbers.length; i++) {
            answerNumbers[i] = generateRandomNumber(answerNumbers);
        }
        return answerNumbers;
    }

    private int generateRandomNumber(int[] answerNumbers) {
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
