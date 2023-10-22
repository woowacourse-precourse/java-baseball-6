package baseball.view;

import baseball.model.GameResult;

public class OutputView {

    public void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void printResult(final GameResult gameResult) {
        if (gameResult.isNothing()) {
            System.out.println("낫싱");
            return;
        }
        System.out.println(gameResult.toString());
    }

}

