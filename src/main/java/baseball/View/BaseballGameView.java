package baseball.View;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGameView {
    public void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void printResult(String result) {
        System.out.println(result);
        if (result.contains("3스트라이크")) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    public void printRestartOrQuitMessage() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public int getRestartOrQuitOption() {
        return Integer.parseInt(Console.readLine());
    }
}