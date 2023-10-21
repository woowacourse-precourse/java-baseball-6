package baseball;

public class BaseBall {
    private Ball userBall = new Ball();
    private Ball comBall = new Ball();
    private Referee referee = new Referee();
    public void startService(){
        do {
            startGame();
            OutputPrint.printEnd(Ball.getMaximumBallSize());
        }while(InputPrint.isEndOfGame());
    }
    public void startGame(){
        comBall.createRandBall();

        do {
            userBall.createUserBall(InputPrint.ballInput(Ball.getMaximumBallSize(), Ball.getMinimumNum(), Ball.getMaximumNum()));
            referee.judge(userBall, comBall);
            OutputPrint.printResult(referee.strike, referee.ball);
        }while(referee.getStrike() < Ball.getMaximumBallSize());
    }
}
