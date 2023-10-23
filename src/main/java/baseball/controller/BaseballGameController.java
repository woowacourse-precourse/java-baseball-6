package baseball.controller;

import baseball.model.computer.Computer;
import baseball.model.player.Player;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameController {

    private static final String START_MSG = "숫자 야구 게임을 시작합니다.";

    private final Computer computer = new Computer();
    private final Player player = new Player();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void start() {
        printStartMessage();
        while (!player.continueGame()) {
            computer.makeAnswer();
            playOneRound();
            player.inputGameStateNumber();
        }
    }

    private void playOneRound() {
        computer.initScore();
        while (!computer.isScoreAllStrike()) {
            inputView.printSuggestNumberMessage();
            player.inputGuessNumber();
            computer.calculateScore(player.getGuessNumbers());
            outputView.printResult(computer.getScore());
        }
        inputView.printRestartOrExitMessage();
    }

    public void printStartMessage() {
        System.out.println(START_MSG);
    }
}