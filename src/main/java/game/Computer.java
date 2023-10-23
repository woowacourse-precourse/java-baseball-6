package game;

public class Computer {

    private Ball computerBall;
    private BallCount ballCount;

    public Computer() {
        computerBall = new Ball(RandomNumberGenerator.generateRandomNumber());
    }

    public boolean catchBall(Ball playerBall) {
        ballCount = Referee.judge(playerBall, computerBall);
        System.out.println(ballCount.getBallCount());
        return ballCount.isThreeStrike();
    }
}
