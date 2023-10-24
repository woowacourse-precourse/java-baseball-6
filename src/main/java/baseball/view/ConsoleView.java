package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleView {
    private Console console;

    public String getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = console.readLine();
        return input;
    }

    public void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printResult(int[] result) {
        String resultContent = "";
        if (result[0]!= 0) {
            resultContent += result[0] +"볼 ";
        }
        if (result[1]!=0) {
            resultContent += result[1] + "스트라이크";
        }
        if (result[2]!=0) {
            resultContent = "낫싱";
        }
        System.out.println(resultContent);
    }

    public void printGameEnd() {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public String printAskAgain() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = console.readLine();
        return input;
    }
}
