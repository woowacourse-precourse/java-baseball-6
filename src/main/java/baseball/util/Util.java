package baseball.util;

import baseball.model.Ball;
import baseball.model.GameResult;
import baseball.model.TripleBalls;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Util {
    public static final int THREE_BALLS = 3;
    public static final int VALUE_START_INCLUSIVE = 1;
    public static final int VALUE_END_INCLUSIVE = 9;

    public static String appendGameResult(long ballTotal, long strikeTotal) {
        StringBuilder gameResultBuilder = new StringBuilder();

        if (ballTotal == 0 && strikeTotal == 0) {
            gameResultBuilder.append(GameResult.NOTHING.getResultMessage());
            return gameResultBuilder.toString();
        }

        if (ballTotal > 0) {
            gameResultBuilder.append(ballTotal + GameResult.BALL.getResultMessage() + " ");
        }

        if (strikeTotal > 0) {
            gameResultBuilder.append(strikeTotal + GameResult.STRIKE.getResultMessage());
        }

        return gameResultBuilder.toString();
    }

    public static List<Character> convertStringToCharList(String inputNumbers) {
        return inputNumbers.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
    }

    public static TripleBalls generateComputerTripleBalls() {
        return convertStringToTripleBalls(convertNumbersToString(generateRandomNumbers()));
    }

    public static TripleBalls convertStringToTripleBalls(String inputNumbers) {
        List<Ball> convertedBalls = new ArrayList<>();
        int digit = 1;

        for (Character convertedChar : convertStringToCharList(inputNumbers)) {
            int convertedNumber = Integer.parseInt(String.valueOf(convertedChar));
            convertedBalls.add(new Ball(digit++, convertedNumber));
        }

        return new TripleBalls(convertedBalls);
    }

    public static List<Integer> generateRandomNumbers() {
        List<Integer> computerGeneratedNumbers = new ArrayList<>();

        while (computerGeneratedNumbers.size() != THREE_BALLS) {
            int randomNumber = Randoms.pickNumberInRange(VALUE_START_INCLUSIVE, VALUE_END_INCLUSIVE); // Verifiaction 적용한 구간
            if (!computerGeneratedNumbers.contains(randomNumber)) {
                computerGeneratedNumbers.add(randomNumber);
            }
        }
        return computerGeneratedNumbers;
    }

    public static boolean hasSameInput(String src, String input) {
        return src.equals(input);
    }

    private static String convertNumbersToString(List<Integer> numbers) {
        StringBuilder stringBuilder = new StringBuilder();
        numbers.stream()
                .forEach(num -> stringBuilder.append(num));
        return stringBuilder.toString();
    }
}
