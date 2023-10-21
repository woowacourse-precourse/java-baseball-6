package baseball.console.game.numberbaseball.util;

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
            throw new IllegalArgumentException("백의 자리 수를 구하기에 유효하지 않은 숫자가 전달되었습니다: " + number);
        return number % 1000 / 100;
    }

    public static int getTenDigit(int number) throws IllegalArgumentException{
        if (number < 10)
            throw new IllegalArgumentException("십의 자리 수를 구하기에 유효하지 않은 숫자가 전달되었습니다: " + number);
        return number % 100 / 10;
    }

    public static int getOneDigit(int number) throws IllegalArgumentException{
        if (number < 0)
            throw new IllegalArgumentException("일의 자리 수를 구하기에 유효하지 않은 숫자가 전달되었습니다: " + number);
        return number % 10;
    }
}
