package baseball.Controller;

import baseball.DTO.Computer;

public class GameController {

    private final Computer computer;
    public GameController(){
        computer = new Computer();
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

}
