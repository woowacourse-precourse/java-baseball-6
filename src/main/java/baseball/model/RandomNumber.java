package baseball.model;

import static baseball.Constants.PLAY_NUMBER_DIGIT;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 9;

    public static int pickNumber() {
        StringBuilder numberBuilder = new StringBuilder();

        while (!isEnoughPicked(numberBuilder)) {
            saveNewNumber(numberBuilder);
        }

        String selectNumber = numberBuilder.toString();
        return Integer.parseInt(selectNumber);
    }

    private static boolean isEnoughPicked(final StringBuilder numberBuilder) {
        return numberBuilder.length() == PLAY_NUMBER_DIGIT;
    }

    private static void saveNewNumber(final StringBuilder numberBuilder) {
        int randomNumber = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
        String randomValue = String.valueOf(randomNumber);
        String pickedNumber = numberBuilder.toString();

        if (pickedNumber.contains(randomValue)) {
            return;
        }

        numberBuilder.append(randomNumber);
    }
}
