package baseball.controller;

import static baseball.view.InputView.inputPlayerNumbers;
import static baseball.view.InputView.shouldContinue;

import baseball.model.Computer;
import baseball.model.GameResult;
import baseball.model.Numbers;
import baseball.model.Player;
import baseball.view.HintView;

public class BaseballGame {
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String END_GAME_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void play() {
        System.out.println(START_MESSAGE);
        do {
            start();
        } while (shouldContinue());
    }

    private void start() {
        Numbers computerNumbers = new Computer().getNumbers();
        GameResult result;
        do {
            Player player = new Player(inputPlayerNumbers());
            Numbers playerNumbers = player.getPlayerNumbers();
            result = computerNumbers.calculateResult(playerNumbers);
            printHint(result);
        } while (!result.isThreeStrikes());
        System.out.println(END_GAME_MESSAGE);
    }

    private void printHint(GameResult result) {
        HintView hintView = new HintView(result);
        hintView.printHint();
    }
}