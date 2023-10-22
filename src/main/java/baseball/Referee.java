package baseball;

public class Referee {

    public static BallCount checkBallCount(String playerBall, String computerBall) {
        BallCount ballCount = new BallCount();
        for (int i = 0; i < 3; i++) {
            String playerNum = playerBall.substring(i, i + 1);
            if (computerBall.contains(playerNum)) {
                String computerNum = computerBall.substring(i, i + 1);
                if (computerNum.equals(playerNum)) {
                    ballCount.addStrikeCount();
                }
                if (!computerNum.equals(playerNum)) {
                    ballCount.addBallCount();
                }
            }
        }
        return ballCount;
    }
}
