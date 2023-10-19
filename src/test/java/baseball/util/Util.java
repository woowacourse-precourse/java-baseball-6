package baseball.util;

import baseball.model.Ball;
import baseball.model.GameResult;
import baseball.model.TripleBalls;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Util {
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

    public static TripleBalls convertToTripleBalls(String inputNumbers) {
        List<Ball> convertedBalls = new ArrayList<>();
        int digit = 1;

        for (Character convertedChar : convertStringToCharList(inputNumbers)) {
            int convertedNumber = Integer.parseInt(String.valueOf(convertedChar));
            convertedBalls.add(new Ball(digit++, convertedNumber));
        }

        return new TripleBalls(convertedBalls);
    }

    public static List<Character> convertStringToCharList(String inputNumbers) {
        return inputNumbers.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
    }
}
