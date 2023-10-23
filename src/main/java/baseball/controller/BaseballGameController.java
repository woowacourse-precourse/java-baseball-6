package baseball.controller;

import baseball.model.computer.Computer;
import baseball.model.player.Player;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameController {

    private static final String START_MSG = "숫자 야구 게임을 시작합니다.";

    private final Computer computer;
    private final Player player;
    private final InputView inputView;
    private final OutputView outputView;

    public BaseballGameController() {
        this.computer = new Computer();
        this.player = new Player();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        printStartMessage();
        while (!player.continueGame()) {
            computer.makeAnswer();
            playOneRound();
            player.inputGameStateNumber();
        }
    }

    private void playOneRound() {
        while (!computer.getScore().isAllStrike()) {
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