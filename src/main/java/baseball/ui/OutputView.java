package baseball.ui;

import static baseball.global.constant.GameMessage.GAME_START_MESSAGE;
import static baseball.global.constant.GameMessage.NUMBER_INPUT_MESSAGE;

import baseball.domain.GameResult;

public class OutputView {

    public void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void printNumberInputMessage() {
        System.out.print(NUMBER_INPUT_MESSAGE);
    }

    public void printGameResultMessage(GameResult result) {
        System.out.println(result.resultToString());
    }

    public void printRestartSelectMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    }

    public void printGameFinishMessage() {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }


}
