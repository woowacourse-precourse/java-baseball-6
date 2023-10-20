package baseball;

import baseball.domain.BallAndStrikeCount;
import baseball.domain.Computer;
import baseball.domain.Restart;
import baseball.domain.User;

public class Application {
    public static void main(String[] args) {
        User user = new User();
        Computer computer = new Computer();
        BallAndStrikeCount ballAndStrikeCount = new BallAndStrikeCount();
        Restart restart = new Restart();

        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            user.inputUserNumber();

            ballAndStrikeCount.compare(computer.getRandomNumbers(), user.getUserNumber());
            ballAndStrikeCount.showStatus();

            if (ballAndStrikeCount.checkStrike()) {
                if (!restart.checkRestartNumber(restart.inputRestartNumber())) break;
                computer = new Computer();
            }
        }
    }
}
