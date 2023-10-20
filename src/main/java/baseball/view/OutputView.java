package baseball.view;

import baseball.domain.Result;

public class OutputView {
    public void startMention() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printResult(Result result) {
        if (result.isNothing()) {
            System.out.println("낫싱");
            return;
        } else if (result.isAllStrike()) {
            System.out.println("3스트라이크");
            return;
        }
        System.out.printf("%d볼 %d스트라이크%n", result.getBallCount(), result.getStrikeCount());
    }

    public void gameOverMention() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
