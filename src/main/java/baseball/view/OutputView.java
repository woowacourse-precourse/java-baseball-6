package baseball.view;

import baseball.model.Game;

public class OutputView {
    public void startMessage() {
        System.out.print("숫자 야구 게임을 시작합니다.");
    }

    public void printResult(Game game) {
        if (game.getBall() == 0 && game.getStrike() == 0) {
            System.out.print("낫싱\n");
        } else if (game.getBall() == 0) {
            System.out.printf("%d스트라이크\n", game.getStrike());
        } else if (game.getStrike() == 0) {
            System.out.printf("%d볼\n", game.getBall());
        } else {
            System.out.printf("%d볼 %d스트라이크\n", game.getBall(), game.getStrike());
        }
    }

    public void finishMessage() {
        System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
    }

}
