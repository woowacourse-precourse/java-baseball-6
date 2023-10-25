package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class BaseballView {

    public void printGameStartMessage(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printUserInputGuideMessage(){
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void printGameOverMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void printWhetherRestartOrExitMessage() {
        printGameOverMessage();
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void printResultGameMessage(int ballCount, int strikeCount) {

        String message = "";

        if (ballCount != 0) {
            message = ballCount + "볼 ";
        }

        if (strikeCount != 0) {
            message += strikeCount + "스트라이크";
        }

        if (ballCount == 0 && strikeCount == 0) {
            message = "낫싱";
        }

        System.out.println(message);
    }

    public String getUserInput() {
        printUserInputGuideMessage();
        return Console.readLine();
    }

    public String getGameMenu() {
        return Console.readLine();
    }
}
