package baseball.controller;

import baseball.model.Computer;
import baseball.model.User;
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

}
