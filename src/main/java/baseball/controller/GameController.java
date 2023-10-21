package baseball.controller;

import baseball.model.Computer;
import baseball.model.GameCommand;
import baseball.model.JudgeResult;
import baseball.model.Player;
import baseball.model.Referee;
import baseball.util.JudgeResultFormatter;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private GameCommand gameCommand;

    public GameController() {
        gameCommand = GameCommand.GAME_START;
    }

    public void play() {
        OutputView.printGameStart();
        while (gameCommand == GameCommand.GAME_START) {
            initializeGame();
        }
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
        gameCommand = GameCommand.decideGameCommand(InputView.readRetryCommand());
    }

    private boolean isGameSuccess(JudgeResult judgeResult) {
        return judgeResult.isGameSuccess();
    }

}
