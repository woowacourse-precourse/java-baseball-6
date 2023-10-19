package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.User;
import baseball.service.BaseballService;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class BaseballController {
    static BaseballService baseballService;



    public static void run(){
        start();
    }
    private static void start(){
        OutputView.startGame();
        Computer computer = new Computer(createRandomNumber());
        baseballStart(computer);
    }

    private static void baseballStart(Computer computer) {
        boolean gameState = true;  //게임 진행 여부
        do{
            User user = new User(inputNumber());

        }
        while(gameState);
    }

    //컴퓨터가 생각하고 있는 3개의 수 생성
    private static List<Integer> createRandomNumber() {
        return baseballService.createRandomNumber();
    }


    //숫자 입력
    public static List<Integer> inputNumber(){
        return InputView.inputNumber();
    }
}
