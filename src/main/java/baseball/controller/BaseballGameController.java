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
    private final Computer computer = new Computer();
    private final Player player = new Player();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void start() {
        printStartMessage();
        while (player.getRestartOrExit() != EXIT) {
            playOneRound(computer.generateNumber());
            player.inputRestartOrExit();
        }
    }

    private void playOneRound(List<Integer> answer) {
        while (true) {
            inputView.printSuggestNumberMessage();
            player.inputNumbers();
            Score score = computer.calculateScore(player.getNumbers(), answer);
            outputView.printResult(score);
            if (score.isAllStrike()) {
                break;
            }
        }
        inputView.printRestartOrExitMessage();
    }

    public void printStartMessage() {
        System.out.println(START_MSG);
    }
}