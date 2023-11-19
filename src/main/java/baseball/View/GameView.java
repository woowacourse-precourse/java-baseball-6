package baseball.View;

import camp.nextstep.edu.missionutils.Console;

public class GameView {
    private final static String GAME_START = "숫자 야구 게임을 시작합니다.";
    private final static String INPUT_NUMBERS = "숫자를 입력해주세요 : ";
    private final static String GAME_END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final static String INPUT_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void showGameStart() {
        System.out.println(GAME_START);
    }

    public void showInputNumbers() {
        System.out.print(INPUT_NUMBERS);
    }

    public void showGameEnd() {
        System.out.println(GAME_END);
    }

    public void showInputRestart() {
        System.out.println(INPUT_RESTART);
    }

    public void showString(String string) {
        System.out.println(string);
    }

    public String getInput() {
        return Console.readLine();
    }
}
