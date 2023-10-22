package baseball;

public class Computer {

    private String computerBall;
    private BallCount ballCount;

    Computer() {
        computerBall = RandomNumberGenerator.generateRandomNumber();
    }

    public boolean catchBall(String playerBall) {
        ballCount = Referee.checkBallCount(playerBall, computerBall);
        System.out.println(ballCount.getBallCount());
        return ballCount.isThreeStrike();
    }
}
