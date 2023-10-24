package baseball.controller;

import baseball.model.ComputerNumber;
import baseball.model.GameCommand;
import baseball.model.JudgeResult;
import baseball.model.PlayerNumber;
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
        ComputerNumber computerNumber = new ComputerNumber();
        playSingleRound(computerNumber);
        readRetryCommand();
    }

    private void playSingleRound(ComputerNumber computerNumber) {
        while (true) {
            PlayerNumber playerNumber = new PlayerNumber(InputView.readPlayerNumber());
            Referee referee = new Referee(computerNumber, playerNumber);
            JudgeResult judgeResult = referee.judgeBallCount();
            OutputView.printRoundResult(JudgeResultFormatter.format(judgeResult));
            if (judgeResult.isGameSuccess()) {
                OutputView.printGameSuccess();
                break;
            }
        }
    }

    private void readRetryCommand() {
        gameCommand = GameCommand.decideGameCommand(InputView.readRetryCommand());
    }

}
