package baseball;

import java.util.List;

public class Check {

    public static final int NUMBER_COUNT = 3;
    public static final int THREE_STRIKE = 3;
    public static final int ZERO_COUNT = 0;
    public static final String GAME_CLEAR = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String NOTHING = "낫싱";
    public static final String BALL = "볼";
    public static final String STRIKE = "스트라이크";
    private final List<Integer> computerNumber;
    private final List<Integer> playerNumber;
    private static boolean isThreeStrike;
    private int ballCount;
    private int strikeCount;

    public Check(List<Integer> computerNumber, List<Integer> playerNumber) {
        this.computerNumber = computerNumber;
        this.playerNumber = playerNumber;
    }

    public void countBallAndStrike() {
        for (int i = 0; i < NUMBER_COUNT; i++) {
            if (playerNumber.get(i).equals(computerNumber.get(i))) {
                strikeCount++;
            } else if (computerNumber.contains(playerNumber.get(i))) {
                ballCount++;
            }
        }
    }

    public void printResult() {
        if (ballCount == ZERO_COUNT && strikeCount == ZERO_COUNT) {
            System.out.println(NOTHING);
        } else if (strikeCount == ZERO_COUNT) {
            System.out.println(ballCount + BALL);
        } else if (ballCount == ZERO_COUNT) {
            System.out.println(strikeCount + STRIKE);
        } else if (strikeCount != ZERO_COUNT && ballCount != ZERO_COUNT) {
            System.out.println(ballCount + BALL + " " + strikeCount + STRIKE);
        }

        if (strikeCount == THREE_STRIKE) {
            isThreeStrike = true;
            System.out.println(GAME_CLEAR);
        }
    }

    public static boolean isThreeStrike() {
        return isThreeStrike;
    }

    public static void setIsThreeStrike(boolean isThreeStrike) {
        Check.isThreeStrike = isThreeStrike;
    }
}
