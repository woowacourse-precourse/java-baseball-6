package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class GameView {
    public String guessInputView() {
        System.out.println("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public String restartInputView() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }

    public void gameStartView() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void hintView(StringBuilder resultStatement) {
        System.out.println(resultStatement);
    }
}
