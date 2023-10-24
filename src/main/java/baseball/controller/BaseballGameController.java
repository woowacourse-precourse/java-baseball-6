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

    public BaseballGameController(Computer computer, Player player, InputView inputView, OutputView outputView) {
        this.computer = computer;
        this.player = player;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        printStartMessage();
        while (player.continueGame()) {
            computer.makeAnswer();
            playOneRound();
            player.inputGameStateNumber();
        }
    }

    private void playOneRound() {
        computer.initScore();
        while (!computer.isScoreAllStrike()) {
            inputView.printGuessNumberInputMessage();
            player.inputGuessNumbers();
            computer.calculateScore(player.getGuessNumbers());
            outputView.printResult(computer.getScore());
        }
        inputView.printRestartOrExitInputMessage();
    }

    public void printStartMessage() {
        System.out.println(START_MSG);
    }
}