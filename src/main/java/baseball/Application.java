package baseball;

import baseball.player.Computer;
import baseball.player.User;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            Computer computer = new Computer();
            User user = new User();
            while (true) {
                if (!computer.compare(user.inputNumbers())) {
                    break;
                }
            }
            if (!user.wantContinue()) {
                break;
            };
        };
    }
}
