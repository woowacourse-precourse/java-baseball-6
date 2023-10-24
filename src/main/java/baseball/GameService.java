package baseball;

import baseball.domain.Computer;

public class GameService {

    private static Computer computer;
    public GameService() {
        computer = new Computer();
    }

    public void executeGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        computer.generateNumber();
    }

}
