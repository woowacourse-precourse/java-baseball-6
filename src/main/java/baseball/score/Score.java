package baseball.score;

import baseball.game.Game;

import java.util.List;

public class Score {

    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";

    public static boolean checkScore(List<Integer> input, List<Integer> randomNumber) {
        int ballCount = 0;
        int strikeCount = 0;

        for (int i = 0; i < 3; i++) {
            if (input.get(i) == randomNumber.get(i)) {
                strikeCount++;
            } else if (randomNumber.contains(input.get(i))) {
                ballCount++;
            }
        }

        printScore(ballCount, strikeCount);

        if (strikeCount == 3) {
            Game.successGame();
            return true;
        }

        return false;
    }

    private static void printScore(int ball, int strike) {
        if (ball != 0 && strike != 0) {
            System.out.println(ball + BALL + " " + strike + STRIKE);
        } else if (ball != 0) {
            System.out.println(ball + BALL);
        } else if (strike != 0) {
            System.out.println(strike + STRIKE);
        } else {
            System.out.println(NOTHING);
        }
    }

}
