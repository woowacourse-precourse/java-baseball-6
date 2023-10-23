package baseball.controller;

import baseball.model.Computer;
import baseball.model.Player;
import baseball.model.Score;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class BaseballGameController {

    private static final String START_MSG = "숫자 야구 게임을 시작합니다.";
    private static final Integer EXIT = 2;
    private static final Integer INIT_STRIKE = 0;
    private static final Integer INIT_BALL = 0;

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
        while (player.getRestartOrExit() != EXIT) {
            playOneRound(computer.generateNumber(), new Score(INIT_STRIKE, INIT_BALL));
            player.inputRestartOrExit();
        }
    }

    private void playOneRound(List<Integer> answer, Score score) {
        while (!score.isAllStrike()) {
            inputView.printSuggestNumberMessage();
            player.inputNumbers();
            score = computer.getScore(player.getNumbers(), answer);
            outputView.printResult(score);
        }
        inputView.printRestartOrExitMessage();
    }

    public void printStartMessage() {
        System.out.println(START_MSG);
    }
}