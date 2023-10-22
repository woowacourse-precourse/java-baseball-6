package baseball;

import baseball.domain.Count;
import baseball.domain.Computer;
import baseball.domain.Restart;
import baseball.domain.User;

public class Application {
    public static void main(String[] args) {
        User user = new User();
        Computer computer = new Computer();
        Count count = new Count();
        Restart restart = new Restart();

        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            user.inputUserNumber();

            count.compare(computer.getRandomNumbers(), user.getUserNumber());
            count.showStatus();

            if (count.checkStrike() && !restart.checkRestartNumber(restart.inputRestartNumber())) {
                break;
            } else if (count.checkStrike()) {
                computer = new Computer();
            }
        }
    }
}
