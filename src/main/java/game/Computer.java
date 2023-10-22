package game;

public class Computer {

    private String computerBall;
    private BallCount ballCount;

    public Computer() {
        computerBall = RandomNumberGenerator.generateRandomNumber();
    }

    public boolean catchBall(String playerBall) {
        ballCount = Referee.judge(playerBall, computerBall);
        System.out.println(ballCount.getBallCount());
        return ballCount.isThreeStrike();
    }
}
