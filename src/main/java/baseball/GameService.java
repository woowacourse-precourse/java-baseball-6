package baseball;

import baseball.domain.Computer;
import baseball.domain.User;

public class GameService {

    private static Computer computer;
    private static User user;
    public GameService() {
        computer = new Computer();
        user = new User();
    }

    public void executeGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        computer.generateNumber();
        user.inputUserNumber();
    }

}
