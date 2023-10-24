package baseball;

import baseball.controller.BaseballGame;
import camp.nextstep.edu.missionutils.Console;
import java.util.Objects;

public class Application {
    public static boolean continueGame(String s) {
        if (Objects.equals(s, "1")) {
            return true;
        }
        
        if (Objects.equals(s, "2")) {
            return false;
        }

        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            //숫자 야구 게임 시작
            BaseballGame baseballGame = new BaseballGame();
            baseballGame.startGame();

            //사용자 입력에 따라 게임을 시작할지 종료할지 결정
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String s = Console.readLine();

            if (!continueGame(s)) {
                break;
            }
        }
    }
}
