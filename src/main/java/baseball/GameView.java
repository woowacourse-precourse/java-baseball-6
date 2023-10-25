package baseball;

import camp.nextstep.edu.missionutils.Console;
import baseball.Result;

public class GameView {
    public void displayMessage(String message) {
        System.out.println(message);
    }

    public String getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public void displayResult(Result result) {
        if (result.getStrikes() == 0 && result.getBalls() == 0) {
            displayMessage("낫싱");
        }
        else if (result.getStrikes() == 0) {
            displayMessage(result.getBalls() + "볼");
        }
        else if (result.getBalls() == 0) {
            displayMessage(result.getStrikes() + "스트라이크");
        }
        else {
            displayMessage(result.getBalls() + "볼 " + result.getStrikes() + "스트라이크");
        }
    }

    public void displayGameWon() {
        displayMessage("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void displayRestartOrExit() {
        displayMessage("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
