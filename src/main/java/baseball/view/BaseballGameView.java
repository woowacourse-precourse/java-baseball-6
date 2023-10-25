package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGameView {

    public void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public String getUserNumberInput() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public void printResult(String result) {
        System.out.println(result);
    }

    public boolean askForNewGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String response = Console.readLine().trim();

        if ("1".equals(response)) {
            return true;
        } else if ("2".equals(response)) {
            return false;
        } else {
            throw new IllegalArgumentException("잘못된 입력입니다. 입력은 1 또는 2여야 합니다.");
        }
    }

    public void printEndGameMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
