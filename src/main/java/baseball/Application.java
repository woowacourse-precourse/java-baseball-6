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
            user.inputUserNumber();

            count.countAndShow(computer.getRandomNumbers(), user.getUserNumbers());

            if (count.checkStrike() && restart.doRestart()) {
                computer = new Computer();
            } else if (count.checkStrike()) {
                break;
            }
        }
    }
}
