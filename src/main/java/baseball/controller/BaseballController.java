package baseball.controller;

import baseball.domain.BallCount;
import baseball.domain.Baseball;
import baseball.domain.Computer;
import baseball.domain.User;
import baseball.service.BaseballService;
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
            gameStart(user,computer);
            retryGame(baseball);
        }
        while(baseball.isState());
        }

    private static void gameStart( User user, Computer computer) {
        do{
            computer.createComputerBall();
            playBall(user,computer);
        }
        while(user.retry());
    }

    private static void playBall(User user, Computer computer) {
        BallCount ballCount = new BallCount(true);
        do{
            user.setBaseball(inputNumber());
            ballCount.initBallCount();
            ballCount.baseballGame(computer.getBaseball(), user.getBaseball());
            ballCount.strikeOut();
        }
        while(ballCount.isStrikeOut());
        user.endGame();
        OutputView.endGame();
    }




    private static void retryGame(Baseball baseball) {
        baseball.retryAndEnd(InputView.retryGame());
    }
    //숫자 입력
    public static List<Integer> inputNumber(){
        return InputView.inputNumber();
    }
}
