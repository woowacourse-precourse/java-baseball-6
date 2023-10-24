package baseball;

import baseball.player.Computer;
import baseball.player.User;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        playGame();
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean flag = true;
        while (flag) {
            Computer computer = new Computer();
            User user = new User();
            user.inputNumbers();

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            flag = user.wantContinue();
        };
    }
}
