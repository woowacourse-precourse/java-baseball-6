package baseball.utils;

import camp.nextstep.edu.missionutils.Console;

import java.util.Scanner;

import static baseball.utils.ErrorCode.*;
import static baseball.utils.Message.*;

public abstract class InputUtil {

    public static final String RESTART_NUMBER = "1";
    public static final String END_NUMBER = "2";

    private InputUtil() {}

    public static String requireGuessNumber() {
        System.out.println(REQUIRE_NUMBER_MESSAGE.getMessage());
        String guessNumber = Console.readLine();
        checkGuessNumberValid(guessNumber);
        return guessNumber;
    }

    private static void checkGuessNumberValid(String guessNumber) {
        checkGuessNumberDigit(guessNumber);
        checkGuessNumberLengthThree(guessNumber);
        checkGuessNumberDuplicate(guessNumber);
    }

    private static void checkGuessNumberDuplicate(String guessNumber) {
        if (isGuessNumberDuplicate(guessNumber)) {
            throw new IllegalArgumentException(GUESS_NUMBER_DUPLICATED.getErrorMessage());
        }
    }

    private static boolean isGuessNumberDuplicate(String guessNumber) {
        char firstNumber = guessNumber.charAt(0);
        char secondNumber = guessNumber.charAt(1);
        char thirdNumber = guessNumber.charAt(2);

        return firstNumber == secondNumber || secondNumber == thirdNumber || firstNumber == thirdNumber;
    }

    private static void checkGuessNumberLengthThree(String guessNumber) {
        if (guessNumber.length() != 3) {
            throw new IllegalArgumentException(GUESS_NUMBER_IS_NOT_THREE_LENGTH.getErrorMessage());
        }
    }


    private static void checkGuessNumberDigit(String value) {
        if (!isStringDigit(value)) {
            throw new IllegalArgumentException(GUESS_NUMBER_IS_NOT_DIGIT.getErrorMessage());
        }
    }

    private static boolean isStringDigit(String value) {
        return value.chars()
                .allMatch(Character::isDigit);
    }


    public static String requireRestartNumber() {
        String inputNumber = Console.readLine();
        checkRestartNumberValid(inputNumber);
        return inputNumber;
    }

    private static void checkRestartNumberValid(String inputNumber) {
        if (!isRestartNumberValid(inputNumber)) {
            throw new IllegalArgumentException(RESTART_NUMBER_IS_NOT_VALID.getErrorMessage());
        }
    }

    private static boolean isRestartNumberValid(String value) {
        return value.equals(RESTART_NUMBER) || value.equals(END_NUMBER);
    }
}
