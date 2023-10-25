package baseball;

import static baseball.ValidAnswer.DIGITS_LENGTH;

public class GameHint {

    private static String BALL = "볼 ";
    private static String STRIKE = "스트라이크";
    private static String NOTHING = "낫싱";

    public int strikeCount = 0;

    public int printGameHint(String computerNumber, String userNumber) {
        strikeCount = getStrikeCount(computerNumber, userNumber);
        int ballCount = getBallCount(computerNumber, userNumber);

        System.out.println(makeGameHint(strikeCount, ballCount));
        return strikeCount;
    }

    public boolean isGameOver() {
        return strikeCount == DIGITS_LENGTH;
    }

    private String makeGameHint(int strikeCount, int ballCount) {
        StringBuilder sb = new StringBuilder();
        if (strikeCount > 0) {
            if (ballCount > 0) {
                sb.append(ballCount).append(BALL).append(strikeCount).append(STRIKE);
                return sb.toString();
            }
            sb.append(strikeCount).append(STRIKE);
            return sb.toString();
        }
        if (ballCount > 0) {
            sb.append(ballCount).append(BALL);
            return sb.toString();
        }
        sb.append(NOTHING);
        return sb.toString();
    }

    private int getStrikeCount(String computerNumber, String userNumber) {
        int strikeCount = 0;
        for (int index = 0; index < DIGITS_LENGTH; index++) {
            if (computerNumber.charAt(index) == userNumber.charAt(index)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private int getBallCount(String computerNumber, String userNumber) {
        int ballCount = 0;
        for (int index = 0; index < DIGITS_LENGTH; index++) {
            if (!(computerNumber.charAt(index) == userNumber.charAt(index)) &&
                    (computerNumber.indexOf(userNumber.charAt(index)) != -1)) {
                ballCount++;
            }
        }
        return ballCount;
    }
}
