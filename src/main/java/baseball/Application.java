package baseball;

import baseball.controller.BaseballGame;
import camp.nextstep.edu.missionutils.Console;
import java.util.Objects;

public class Application {
    public static boolean continueGame(String s) {
        if (Objects.equals(s, "2")) {
            return false;
        } else if (Objects.equals(s, "1")) {
            return true;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            BaseballGame baseballGame = new BaseballGame();
            baseballGame.startGame();

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String s = Console.readLine();

            if (!continueGame(s)) {
                break;
            }
        }
    }
}
