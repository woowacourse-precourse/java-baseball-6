package baseball.view;

import baseball.model.PlayResult;

public class OutputView {

    public static void printResult(PlayResult playResult) {
        System.out.println(playResult);
    }

    public static void printEndOfGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
