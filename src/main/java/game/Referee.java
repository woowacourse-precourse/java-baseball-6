package game;

public class Referee {

    private static Ball playerBall;
    private static Ball computerBall;
    private static BallCount ballCount;

    public static BallCount judge(Ball player, Ball computer) {
        playerBall = player;
        computerBall = computer;
        ballCount = new BallCount();
        countBall();
        countStrike();
        return ballCount;
    }

    private static boolean isNothing(String playNumber) {
        return !computerBall.ballContains(playNumber);
    }

    private static void countStrike() {
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            String playerNumber = playerBall.ballSubString(i);
            String computerNumber = computerBall.ballSubString(i);
            if (!isNothing(playerNumber) && computerNumber.equals(playerNumber)) {
                strike++;
            }
        }
        ballCount.addStrike(strike);
    }

    private static void countBall() {
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            String playerNumber = playerBall.ballSubString(i);
            String computerNumber = computerBall.ballSubString(i);
            if (!isNothing(playerNumber) && computerNumber.equals(playerNumber)) {
                ball++;
            }
        }
        ballCount.addBall(ball);
    }
}
