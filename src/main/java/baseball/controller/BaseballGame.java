package baseball.controller;

import static baseball.view.InputView.inputPlayerNumbers;

import baseball.model.Computer;
import baseball.model.GameResult;
import baseball.model.Numbers;
import baseball.model.Player;
import baseball.view.HintView;
import baseball.view.InputView;

public class BaseballGame {
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String END_GAME_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RETRY = "1";
    private static final String END_GAME = "2";
    private static final String INVALID_INPUT_MESSAGE = "올바른 수를 입력하세요.";

    public void play() {
        System.out.println(START_MESSAGE);
        do {
            start();
        } while (askRestartOrExit());
    }

    private void start() {
        Numbers computerNumbers = Computer.create().getNumbers();
        GameResult result;
        do {
            Player player = Player.from(inputPlayerNumbers());
            Numbers playerNumbers = player.getPlayerNumbers();
            result = computerNumbers.calculateResult(playerNumbers);
            new HintView(result).printHint();
        } while (!result.isThreeStrikes());
        System.out.println(END_GAME_MESSAGE);
    }

    private boolean askRestartOrExit() {
        String answer = InputView.promptContinueGame();
        if (answer.equals(RETRY)) {
            return true;
        }
        if (answer.equals(END_GAME)) {
            return false;
        }
        throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
    }
}