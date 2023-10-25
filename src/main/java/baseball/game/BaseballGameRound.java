package baseball.game;

import baseball.common.Constants;
import baseball.game.status.BaseballGameRoundStatus;
import baseball.player.ComputerPlayer;
import baseball.player.UserPlayer;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameRound {

    private ComputerPlayer computerPlayer;
    private UserPlayer userPlayer;
    private BaseballGameRoundStatus baseballGameRoundStatus;
    private InputView inputView;
    private OutputView outputView;

    public BaseballGameRound(ComputerPlayer computerPlayer, UserPlayer userPlayer) {
        this.computerPlayer = computerPlayer;
        this.userPlayer = userPlayer;
        this.baseballGameRoundStatus = BaseballGameRoundStatus.CONTINUE;
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        StrikeBall strikeBall;

        outputView.printBaseballGameStart();
        do {
            outputView.printUserNumberInput();
            userPlayer.updateUserNumbers(inputView.nextIntArray());
            strikeBall = computerPlayer.compareTo(userPlayer.getUserNumbers());

            outputView.printStrikeBallResult(strikeBall);

            if(strikeBall.isStrikeSuccess()) outputView.printThreeStrikeSuccess();
        } while (strikeBall.getStrike() < Constants.strikeTarget);
    }
}
