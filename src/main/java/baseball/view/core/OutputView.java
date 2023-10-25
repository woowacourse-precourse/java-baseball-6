package baseball.view.core;

public final class OutputView extends ConsoleWriter {

    public void printGameStartMessage() {
        this.println("숫자 야구 게임을 시작합니다.");
    }

    public void printScore(String scoreResult) {
        this.println(scoreResult);
    }

    public void printGameEnd() {
        this.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
