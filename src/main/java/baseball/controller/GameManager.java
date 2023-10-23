package baseball.controller;

import java.util.List;

public class GameManager {
    //인스턴스
    private Computer computer;

    //변수명
    private List<Integer> computerRandomNumbers;

    //생성자
    public GameManager(){
        computer = new Computer();
    };

    public void startGame(){
        computerRandomNumbers = computer.getRandomComputerNumber();
    }
}
