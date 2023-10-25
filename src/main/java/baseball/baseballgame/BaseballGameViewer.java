package baseball.baseballgame;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballGameViewer {
    private Console console;

    void startGameMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    String getUserGuess() {
        System.out.print("숫자를 입력해주세요: ");
        return console.readLine();
    }

    void displayResult(int strikes, int balls) {
        if (strikes == 0 && balls == 0) {
            System.out.println("낫싱");
        } else if (strikes > 0 && balls == 0) {
            System.out.println(strikes + "스트라이크");
        } else if (strikes == 0 && balls > 0) {
            System.out.println(balls + "볼");
        } else {
            System.out.println(balls + "볼 " + strikes + "스트라이크");
        }
    }

    boolean hasNewGameMessage() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
        String restart = console.readLine();

        if (restart.equals("2")) {
            System.out.println("게임 종료");
            return false;
        } else if (restart.equals("1")) {
            return true;
        } else {
            throw new IllegalArgumentException("1 혹은 2를 입력하셔야 합니다.");
        }
    }
}
