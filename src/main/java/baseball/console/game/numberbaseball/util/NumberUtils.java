package baseball.console.game.numberbaseball.util;

import baseball.console.game.numberbaseball.config.ExceptionMessage;

import java.util.stream.Collectors;

public class NumberUtils {
    public static boolean hasDuplicateDigits(int number) {
        String numberString = String.valueOf(number);
        return numberString.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet())
                .size() != numberString.length();
    }

    public static int getHundredDigit(int number) throws IllegalArgumentException{
        if (number < 100)
            throw new IllegalArgumentException(ExceptionMessage.INVALID_FOR_HUNDRED_DIGIT + number);
        return number % 1000 / 100;
    }

    public static int getTenDigit(int number) throws IllegalArgumentException{
        if (number < 10)
            throw new IllegalArgumentException(ExceptionMessage.INVALID_FOR_TEN_DIGIT + number);
        return number % 100 / 10;
    }

    public static int getOneDigit(int number) throws IllegalArgumentException{
        if (number < 0)
            throw new IllegalArgumentException(ExceptionMessage.INVALID_FOR_ONE_DIGIT + number);
        return number % 10;
    }
}
