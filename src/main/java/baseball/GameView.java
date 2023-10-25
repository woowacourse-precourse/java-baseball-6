package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class GameView {
    public void displayMessage(String msg) {
        System.out.println(msg);
    }

    public List<String> getPlayerInput() {
        System.out.print("숫자를 입력해주세요 : ");
        return Arrays.asList(
                Console.readLine()
                        .split(""));
    }

    public String askReplayOrExit() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userChoice = Console.readLine();
        if (!userChoice.equals("1") && !userChoice.equals("2")) {
            throw new IllegalArgumentException("1또는 2를 입력하지 않았습니다. 게임이 종료됩니다.");
        }
        return userChoice;
    }
}

