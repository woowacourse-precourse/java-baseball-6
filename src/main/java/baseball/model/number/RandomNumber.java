package baseball.model.number;

import camp.nextstep.edu.missionutils.Randoms;

import static baseball.Constant.PLAY_NUMBER_DIGIT;

public class RandomNumber {

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 9;

    public static PlayNumber pickNumber() {
        StringBuilder numberBuilder = new StringBuilder();

        while (!isBuilderEnoughPicked(numberBuilder)) {
            saveNewNumber(numberBuilder);
        }

        String selectNumber = numberBuilder.toString();
        return PlayNumber.from(selectNumber);
    }

    private static boolean isBuilderEnoughPicked(final StringBuilder numberBuilder) {
        return numberBuilder.length() == PLAY_NUMBER_DIGIT.getValue();
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
