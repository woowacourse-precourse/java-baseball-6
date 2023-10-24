package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class GameView {

    public void startBaseball() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public String getStartInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        return input;
    }

    public void endBaseBall() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public String getEndInput() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        return input;
    }

    public void printHintMessage(String hintMessage) {
        System.out.println(hintMessage);
    }
}
