package baseball.game;

import baseball.util.NumberUtils;
import java.util.List;

public class BaseBall {

    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";

    private List<Integer> computerNumber;
    private boolean inProgress;

    public BaseBall(List<Integer> computerNumber) {
        this.computerNumber = computerNumber;
        this.inProgress = true;
    }

    public void playBaseBallGame() {
        while (inProgress) {
            Game.printInputMessage();
            List<Integer> input = NumberUtils.getUserNumber();
            int ballCount = checkBallCount(input, computerNumber);
            int strikeCount = checkStrikeCount(input, computerNumber);
            printScore(ballCount, strikeCount);
            inProgress = !isSuccess(strikeCount);
        }
    }

    public int checkBallCount(List<Integer> input, List<Integer> computerNumber) {
        int ballCount = 0;

        for (int i = 0; i < 3; i++) {
            if (!input.get(i).equals(computerNumber.get(i)) && computerNumber.contains(input.get(i))) {
                ballCount++;
            }
        }

        return ballCount;
    }

    public int checkStrikeCount(List<Integer> input, List<Integer> computerNumber) {
        int strikeCount = 0;

        for (int i = 0; i < 3; i++) {
            if (input.get(i).equals(computerNumber.get(i))) {
                strikeCount++;
            }
        }

        return strikeCount;
    }

    private static void printScore(int ball, int strike) {
        if (ball!=0 && strike!=0) {
            System.out.println(ball + BALL + " " + strike + STRIKE);
        } else if (ball!=0) {
            System.out.println(ball + BALL);
        } else if (strike!=0) {
            System.out.println(strike + STRIKE);
        } else {
            System.out.println(NOTHING);
        }
    }

    public boolean isSuccess(int strike) {
        if (strike==3) {
            return true;
        }
        return false;
    }
}
