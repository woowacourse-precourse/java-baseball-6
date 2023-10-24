package baseball.controller;

import baseball.model.Computer;
import baseball.model.GameCommand;
import baseball.model.Player;
import baseball.model.Result;
import baseball.model.UserComputerCompare;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private boolean selectedRetry = true;
    private boolean isThreeStrike;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        try {
            outputView.printGameStart();
            while (selectedRetry) {
                Computer computer = Computer.createByNumber(Computer.createRandomNumbers());
                List<Integer> computerNumber = computer.getComputerNumber();
                outputView.printComputerNumber(computerNumber);
                while (isThreeStrike) {
                    Player player = Player.createNyNumber(inputView.readPlayerNumber());
                    UserComputerCompare userComputerCompare = UserComputerCompare.judge(computer, player);
                    Result result = userComputerCompare.ResultgetBallCountJudgement();
                    outputView.printGameResult(result);
                    isThreeStrike = result.isThreeStrike();
                }
                outputView.printThreeStrike();
                selectedRetry = GameCommand.selectedRetry(inputView.readGameCommand());
                if (selectedRetry) {
                    isThreeStrike = false;
                }

            }
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
            throw exception;
        }
    }
}
