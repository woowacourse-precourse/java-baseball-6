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
        User user= new User(true);
        Computer computer = new Computer();
        do{
            gameStartRequest(user,computer);
            whetherRetryGame(baseball);
        }
        while(baseball.isState());
        }

    private static void gameStartRequest( User user, Computer computer) {
        do{
            computer.createComputerBall();
            playBaseball(user,computer);
        }
        while(user.retry());
    }

    private static void playBaseball(User user, Computer computer) {
        BallCount ballCount = new BallCount(true);
        do{
            user.setBaseball(inputUserNumber());
            ballCount.initBallCount();
            ballCount.baseballGame(computer.getBaseball(), user.getBaseball());
            ballCount.strikeOut();
        }
        while(ballCount.isStrikeOut());
        user.endGame();
        OutputView.endGame();
    }
    private static void whetherRetryGame(Baseball baseball) {
        baseball.retryAndEnd(InputView.retryGame());
    }

    public static List<Integer> inputUserNumber(){
        return InputView.inputNumber();
    }
}
