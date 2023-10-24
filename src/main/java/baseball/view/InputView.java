package baseball.view;

import baseball.domain.ball.BallNumber;
import baseball.domain.game.GameStatus;
import baseball.parser.InputParser;
import camp.nextstep.edu.missionutils.Console;
import collection.Triple;

public final class InputView {
    private final InputParser inputParser;
    private boolean isFirstInput = true;

    public InputView(final InputParser inputParser) {
        this.inputParser = inputParser;
    }

    public Triple<BallNumber> inputBallNumbers() {
        printInputBallNumbersMessage();
        return inputParser.parseBallNumbersInput(readLine());
    }

    public GameStatus inputNextGameStatus() {
        System.out.println("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return inputParser.parseGameStatusInput(readLine());
    }

    private void printInputBallNumbersMessage() {
        if (isFirstInput) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            isFirstInput = false;
        }
        System.out.print("숫자를 입력해주세요 : ");
    }

    private String readLine() {
        return Console.readLine().trim();
    }

}
