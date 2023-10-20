package baseball.game;

import baseball.number.BaseballNumber;
import baseball.number.BaseballResult;
import camp.nextstep.edu.missionutils.Console;
import java.util.Objects;

public class Game {
    BaseballNumber computer = new BaseballNumber();

    public void start() {
        while (true) {
            BaseballResult result = this.input();
            result.print();
            if (result.isCorrect()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    private BaseballResult input() {
        System.out.print("숫자를 입력해주세요 : ");
        BaseballNumber input = new BaseballNumber(Console.readLine());
        return computer.compareTo(input);
    }

    public boolean end() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String restartCode = Console.readLine();
        if (Objects.equals(restartCode, "1")) {
            return false;
        }
        if (Objects.equals(restartCode, "2")) {
            return true;
        }
        throw new IllegalArgumentException();
    }
}
