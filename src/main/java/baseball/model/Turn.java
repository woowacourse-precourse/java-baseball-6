package baseball.model;

import java.util.stream.IntStream;

public class Turn {
    private static final String BALL_STRING = "볼";
    private static final String STRIKE_STRING = "스트라이크";
    private static final String NOTHING_STRING = "낫싱";
    private static final String BLANK_STRING = " ";
    private static final int THREE_STRIKE = 3;
    private final int ballCount;
    private final int strikeCount;

    private Turn(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public static Turn fromPlayerAndComputerNumbers(String playerNumber, String computerNumber) {
        int ballCount = (int) IntStream.range(0, playerNumber.length())
                .filter(i -> playerNumber.charAt(i) != computerNumber.charAt(i))
                .filter(i -> computerNumber.contains(String.valueOf(playerNumber.charAt(i))))
                .count();
        int strikeCount = (int) IntStream.range(0, playerNumber.length())
                .filter(i -> playerNumber.charAt(i) == computerNumber.charAt(i))
                .count();

        return new Turn(ballCount, strikeCount);
    }

    public String generateResultMessage() {
        StringBuilder result = new StringBuilder();

        if (ballCount > 0) {
            result.append(ballCount);
            result.append(BALL_STRING);
        }
        if (ballCount > 0 && strikeCount > 0) {
            result.append(BLANK_STRING);
        }
        if (strikeCount > 0) {
            result.append(strikeCount);
            result.append(STRIKE_STRING);
        }
        if (result.isEmpty()) {
            result.append(NOTHING_STRING);
        }

        return result.toString().trim();
    }

    public boolean isThreeStrike() {
        return strikeCount == THREE_STRIKE;
    }
}
