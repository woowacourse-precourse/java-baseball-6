package baseball.controller;

import baseball.domain.BallCount;
import baseball.domain.Baseball;
import baseball.domain.Computer;
import baseball.domain.User;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class BaseballController {
    public static void run(){
        start();
    }

    private static void start(){
        OutputView.startGame();
        Baseball baseball =new Baseball(true);
        User user= new User();
        Computer computer = new Computer();
        gameStartRequest(baseball, user, computer);
    }

    private static void gameStartRequest(Baseball baseball,User user,Computer computer){
        do{
            repeatGame(user,computer);
            restartAndShutdown(baseball);
        }
        while(baseball.restart());
    }

    private static void repeatGame( User user, Computer computer) {
        computer.createComputerBall();
        playBaseball(user,computer);
        gameComplete();
    }

    private static void playBaseball(User user, Computer computer) {
        BallCount ballCount = new BallCount(true);
        do{
            user.setUserBall(userEnterNumber());
            compareRequest(ballCount,user,computer);
        }
        while(ballCount.isStrikeOut());
    }

    private static void compareRequest(BallCount ballCount, User user, Computer computer){
        ballCount.initializeBallCount();
        ballCount.ballCountResponse(computer.getComputerBall(), user.getUserBall());
        OutputView.printBallCount(ballCount.printBallCount());

    }

    private static void gameComplete(){
        OutputView.gameComplete();
    }
    private static void restartAndShutdown(Baseball baseball) {
        baseball.restartAndShutdown(InputView.retryGame());
    }

    public static List<Integer> userEnterNumber(){
        return InputView.inputNumber();
    }
}
