package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class GameView {

    public void startBaseballGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public String getInput() {
        System.out.print("숫자 입력하세요 : ");
        String input = Console.readLine();
        return input;
    }
}
