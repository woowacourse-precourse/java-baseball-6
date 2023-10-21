package baseball.factory;

import static baseball.Constants.PLAY_NUMBER_DIGIT;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberFactory {

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 9;

    public static int createNumber() {
        StringBuilder numberBuilder = new StringBuilder();

        while (isBuilderLengthLowerThanLength(numberBuilder, PLAY_NUMBER_DIGIT)) {
            saveNewNumber(numberBuilder);
        }

        return convertBuilderToNumber(numberBuilder);
    }

    private static boolean isBuilderLengthLowerThanLength(final StringBuilder builder, final int length) {
        return builder.length() < length;
    }

    private static void saveNewNumber(final StringBuilder numberBuilder) {
        int randomNumber = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
        if (isBuilderContainsNumber(numberBuilder, randomNumber)) {
            return;
        }
        addNumber(numberBuilder, randomNumber);
    }

    private static boolean isBuilderContainsNumber(final StringBuilder builder, final int number) {
        return isInputContainsNumber(builder.toString(), number);
    }

    private static boolean isInputContainsNumber(final String input, final int number) {
        return input.contains(String.valueOf(number));
    }

    private static void addNumber(final StringBuilder builder, final int number) {
        builder.append(number);
    }

    private static int convertBuilderToNumber(final StringBuilder builder) {
        return Integer.parseInt(builder.toString());
    }
}
