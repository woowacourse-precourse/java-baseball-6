package baseball.controller;

import baseball.model.Computer;
import baseball.model.JudgeResult;
import baseball.model.Player;
import baseball.model.Referee;
import baseball.util.JudgeResultFormatter;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    public GameController() {

    }

    public void play() {
        OutputView.printGameStart();
        initializeGame();
    }

    public void initializeGame() {
        Computer computer = new Computer();
        playSingleRound(computer);
        readRetryCommand();
    }

    private void playSingleRound(Computer computer) {
        while (true) {
            Player player = new Player(InputView.readPlayerNumber());
            Referee referee = new Referee(computer, player);
            JudgeResult judgeResult = referee.judgeBallCount();
            OutputView.printRoundResult(JudgeResultFormatter.format(judgeResult));
            if (isGameSuccess(judgeResult)) {
                OutputView.printGameSuccess();
                break;
            }
        }
    }

    private void readRetryCommand() {

    }

    private boolean isGameSuccess(JudgeResult judgeResult) {
        return judgeResult.isGameSuccess();
    }

}
