package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballView {
    public void displayGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void displayInputPrompt() {
    	System.out.print("숫자를 입력해주세요: ");
    }

    public String getUserInput() {
        return Console.readLine();
    }

    public void displayResult(String result) {
    	System.out.println(result);
    }

    public void displayGameEndMessage() {
    	System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void displayGameRestartMessage() {
    	System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
    }

    public void displayErrorMessage(String errorMessage) {
    	System.out.println(errorMessage);
    }
}
