package baseball.controller;

import baseball.util.Exception;
import baseball.model.Computer;
import baseball.model.User;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Game {

    private Computer computer;
    private User user;

    //생성자
    private Game(){
        computer = Computer.create(); //computer 객체 생성
        user = User.create(); //user 객체 생성
        OutputView.start(); //게임 시작
    }

    //Game 생성
    public static Game create(){
        return new Game();
    }

    //computer 난수 생성
    public void createComputerNums(){
        computer.createRandomNums();
    }

    //user 수 입력 받기
    public void userInput(){
        String input = InputView.input();
        Exception.validate(input); //입력 값 검증
        user.convertInput(input); //입력 값 int 형으로 변환
    }

}
