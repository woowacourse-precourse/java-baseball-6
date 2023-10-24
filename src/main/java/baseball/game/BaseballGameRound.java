package baseball.game;

import baseball.game.status.BaseballGameRoundStatus;
import baseball.player.ComputerPlayer;
import baseball.player.UserPlayer;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameRound {

    private final ComputerPlayer computerPlayer;
    private final UserPlayer userPlayer;
    private BaseballGameRoundStatus baseballGameRoundStatus;
    private final InputView inputView;
    private final OutputView outputView;

    public BaseballGameRound(ComputerPlayer computerPlayer, UserPlayer userPlayer) {
        this.computerPlayer = computerPlayer;
        this.userPlayer = userPlayer;
        this.baseballGameRoundStatus = BaseballGameRoundStatus.CONTINUE;
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        StrikeBall strikeBall;

        do {
            outputView.printBaseballGameStart();
            outputView.printUserNumberInput();
            userPlayer.updateUserNumbers(inputView.nextIntArray());
            strikeBall = computerPlayer.compareTo(userPlayer.getUserNumbers());
            outputView.printStrikeBallResult(strikeBall);

            if(strikeBall.isStrikeSuccess()) {
                outputView.printThreeStrikeSuccess();
                baseballGameRoundStatus = BaseballGameRoundStatus.EXIT;
            }
        } while (baseballGameRoundStatus.equals(BaseballGameRoundStatus.EXIT));
    }
}
