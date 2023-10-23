package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class GameView {
    public void showGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public String getUserNumber() {
        System.out.print("숫자를 입력해주세요 :");
        return Console.readLine();
    }
}
