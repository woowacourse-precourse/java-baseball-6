package game;

public class Referee {

    private static String playerBall;
    private static String computerBall;
    private static BallCount ballCount;

    public static BallCount judge(String player, String computer) {
        playerBall = player;
        computerBall = computer;
        ballCount = new BallCount();
        countBall();
        countStrike();
        return ballCount;
    }

    private static boolean isNothing(String playNumber) {
        return !computerBall.contains(playNumber);
    }

    private static void countStrike() {
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            String playerNumber = playerBall.substring(i, i + 1);
            String computerNumber = computerBall.substring(i, i + 1);
            if (!isNothing(playerNumber) && computerNumber.equals(playerNumber)) {
                strike++;
            }
        }
        ballCount.addStrike(strike);
    }

    private static void countBall() {
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            String playerNumber = playerBall.substring(i, i + 1);
            String computerNumber = computerBall.substring(i, i + 1);
            if (!isNothing(playerNumber) && computerNumber.equals(playerNumber)) {
                ball++;
            }
        }
        ballCount.addBall(ball);
    }
}
