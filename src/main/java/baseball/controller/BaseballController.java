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

    private static void retryGame(Baseball baseball) {
        baseball.retryAndEnd(InputView.retryGame());
    }


    private static void gameStart( User user, Computer computer) {
        do{
            settingComputer(computer,user);
            playBall(user,computer);
        }
        while(user.retry());
    }

    private static void playBall(User user, Computer computer) {
        BallCount ballCount = new BallCount(true);
        do{
            user.setBaseball(inputNumber());
            ballCount.initBallCount();
            BaseballService.baseballGame(user,computer,ballCount);
            ballCount.strikeOut();
        }
        while(ballCount.isStrikeOut());
        user.endGame();
        OutputView.endGame();
    }

    //기본 값 설정
    private static void settingComputer(Computer computer,User user) {
        computer.setBaseball(createRandomNumber());
    }
    //컴퓨터가 생각하고 있는 3개의 수 생성
    private static List<Integer> createRandomNumber() {
        return BaseballService.createRandomNumber();
    }

    //숫자 입력
    public static List<Integer> inputNumber(){
        return InputView.inputNumber();
    }
}
