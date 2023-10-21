package baseball.game;

import baseball.number.BaseballNumber;
import baseball.number.BaseballResult;
import camp.nextstep.edu.missionutils.Console;
import java.util.Objects;

/**
 * 야구게임 생성을 위한 클래스입니다.
 * 게임을 생성하면 자동으로 컴퓨터의 수가 정해집니다.
 * 생성된 게임을 시작하거나 종료할 수 있습니다.
 */
public class Game {
    BaseballNumber computer = new BaseballNumber();

    /**
     * 생성된 게임을 시작합니다.
     * 3개의 숫자를 모두 맞히기 전까지 사용자의 입력을 반복하여 받습니다.
     */
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

    /**
     * 사용자의 야구게임 입력을 받고, 이 입력을 정해진 정답과 비교한 결과를 반환합니다.
     * @return BaseballResult 클래스
     */
    private BaseballResult input() {
        System.out.print("숫자를 입력해주세요 : ");
        BaseballNumber input = new BaseballNumber(Console.readLine());
        return computer.compareTo(input);
    }

    /**
     * 게임을 종료할지 묻고, 게임 종료 여부를 반환합니다.
     * @return true: 종료, false: 재시작
     */
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
