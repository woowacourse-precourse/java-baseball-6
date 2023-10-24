package baseball.console;

import baseball.game.GameStatus;

public class Output {

    public static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void showResult(GameStatus gameStatus) {
        System.out.println(gameStatus.gameResultString());
    }
}
