package baseball.View;

import baseball.Model.Computer;

public class OutputView {
    private StringBuilder result;

    public void showResult(final Computer computer) {
        result = new StringBuilder();
        checkNothing(computer);
        checkBall(computer);
        checkStrike(computer);
        System.out.println(result);
    }

    private void checkStrike(final Computer computer) {
        if (computer.getStrike() != 0) {
            result.append(computer.getStrike()).append("스트라이크 ");
        }
    }

    private void checkBall(final Computer computer) {
        if (computer.getBall() != 0) {
            result.append(computer.getBall()).append("볼 ");
        }
    }

    private void checkNothing(final Computer computer) {
        if (computer.isNothing()) {
            result.append("낫싱 ");
        }
    }

    public void showGameOver() {
        System.out.println("숫자를 모두 맞히셨습니다! 게임 종료");
    }
}