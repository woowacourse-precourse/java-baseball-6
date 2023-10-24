package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class PromptHandler {
    public static int readNextRoundResponseNumber() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(GameMessage.WRONG_INPUT.getMessage());
        }
    }

    public static int[] readThreeBallsNumber() {
        String input = Console.readLine();

        if (input.length() != GameConfig.BALLS_SIZE.getValue()) {
            throw new IllegalArgumentException(GameMessage.WRONG_INPUT.getMessage());
        }

        try {
            return Arrays.stream(input.split("")).mapToInt(Integer::parseInt).toArray();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(GameMessage.WRONG_INPUT.getMessage());
        }
    }

    public static void displayScore(int strikeCount, int ballCount) {
        if (strikeCount == GameConfig.ZERO.getValue() && ballCount == GameConfig.ZERO.getValue()) {
            System.out.println(GameMessage.NOTHING.getMessage());
        } else if (strikeCount == GameConfig.ZERO.getValue()) {
            System.out.printf("%d%s%n", ballCount, GameMessage.BALL.getMessage());
        } else if (ballCount == GameConfig.ZERO.getValue()) {
            System.out.printf("%d%s%n", strikeCount, GameMessage.STRIKE.getMessage());
        } else {
            System.out.printf("%d%s %d%s%n", ballCount, GameMessage.BALL.getMessage(), strikeCount, GameMessage.STRIKE.getMessage());
        }
    }
}
