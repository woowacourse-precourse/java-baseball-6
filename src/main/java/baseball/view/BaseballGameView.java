package baseball.view;

import java.util.HashMap;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BaseballGameView {

    public void displayStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public String getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        return readLine();
    }

    public void displayResult(HashMap<String, Integer> result) {
        int ballCount = result.getOrDefault("ball", 0);
        int strikeCount = result.getOrDefault("strike", 0);

        if (ballCount > 0 && strikeCount > 0) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        } else if (ballCount > 0) {
            System.out.println(ballCount + "볼");
        } else if (strikeCount > 0) {
            System.out.println(strikeCount + "스트라이크");

            if (strikeCount == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            }
        } else {
            System.out.println("낫싱");
        }

    }

    public String getUserRestartInput() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return readLine();
    }

}
