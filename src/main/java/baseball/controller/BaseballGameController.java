package baseball.controller;

import baseball.model.TargetNumber;
import baseball.model.StopGameDecisionHelper;
import baseball.model.GameResult;
import baseball.view.ConsoleView;

public class BaseballGameController {
    private static final int BASEBALL_NUMBER_SIZE = 3;
    private static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    private static final String REQUEST_INPUT_NUMBER = "숫자를 입력해주세요";
    private static final String GOOD_GAME = BASEBALL_NUMBER_SIZE + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final ConsoleView consoleView;

    public BaseballGameController(ConsoleView consoleView) {
        this.consoleView = consoleView;
    }

    public void play() {
        consoleView.alert(GAME_START);

        while (true) {
            matchingNumber(TargetNumber.randomInstance(BASEBALL_NUMBER_SIZE));
            consoleView.alert(StopGameDecisionHelper.MORE_GAME_TEXT);
            int wantMoreGame = Integer.parseInt(consoleView.input());
            if (StopGameDecisionHelper.getDecision(wantMoreGame)) {
                break;
            }
        }
    }

    private void matchingNumber(TargetNumber computerNumber) {
        while (true) {
            consoleView.request(REQUEST_INPUT_NUMBER);
            String input = consoleView.input();
            verifyInputNumber(input);
            GameResult gameResult = computerNumber.calculateGameResult(input);

            consoleView.alert(gameResult.toString());

            if (gameResult.isPerfectGame(BASEBALL_NUMBER_SIZE)) {
                consoleView.alert(GOOD_GAME);
                break;
            }
        }
    }

    private void verifyInputNumber(String inputNumberText) {
        if (inputNumberText.length() != BASEBALL_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }
}
