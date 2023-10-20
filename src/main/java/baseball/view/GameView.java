package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class GameView {
    public String getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }
    public void displayResult(String result) {
        System.out.println(result);
    }

    public void displayGameEndMessage(boolean isGameWon) {
        if (isGameWon) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }
    public void displayGameExitMessage() {
        System.out.println("게임 종료");
    }
}