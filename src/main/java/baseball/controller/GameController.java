package baseball.controller;

import baseball.model.ComputerNumber;
import baseball.model.GameCommand;
import baseball.model.JudgeResult;
import baseball.model.NumberComparator;
import baseball.model.PlayerNumber;
import baseball.util.JudgeResultFormatter;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private GameCommand gameCommand;

    public GameController() {
        gameCommand = GameCommand.GAME_START;
    }

    public void startGame() {
        OutputView.printGameStart();
        while (gameCommand == GameCommand.GAME_START) {
            play();
            readRetryCommand();
        }
    }

    private void play() {
        ComputerNumber computerNumber = new ComputerNumber();
        playSingleRound(computerNumber);
    }

    private void playSingleRound(ComputerNumber computerNumber) {
        while (true) {
            PlayerNumber playerNumber = new PlayerNumber(InputView.readPlayerNumber());
            NumberComparator numberComparator = new NumberComparator(computerNumber, playerNumber);
            JudgeResult judgeResult = numberComparator.judgeBallCount();
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
