package baseball;

import java.util.List;

public class Game {

    public void start() {
        User userObj = new User();
        Computer computerObj = new Computer();

        List<Integer> computer = new GenerateRandomNumber().generateNumber();
        while (true) {
            List<Integer> user = userObj.inputNumber();
            if (computerObj.compareNumber(computer, user)) {
                System.out.println(
                        "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                break;
            }
        }
    }

}
