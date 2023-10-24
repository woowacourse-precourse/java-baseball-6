package baseball.game;

import baseball.common.Constants;
import baseball.player.ComputerPlayer;
import baseball.player.UserPlayer;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.ArrayList;

public class BaseballGameRound {

    private ComputerPlayer computerPlayer;
    private UserPlayer userPlayer;
    private OutputView outputView;
    private InputView inputView;

    public BaseballGameRound(ComputerPlayer computerPlayer, UserPlayer userPlayer) {
        this.computerPlayer = computerPlayer;
        this.userPlayer = userPlayer;
        this.outputView = new OutputView();
        this.inputView = new InputView();
    }

    public void start() {
        StrikeBall strikeBall;

        do {
            outputView.printBaseballGameStart();
            outputView.printUserNumberInput();
            ArrayList<Integer> numbers = inputView.nextIntArray();
            userPlayer.updateUserNumbers(numbers);
            strikeBall = computerPlayer.compareTo(userPlayer.getUserNumbers());

            outputView.println(strikeBall.makeStrikeBallMessage());

            if(strikeBall.isStrikeSuccess()) outputView.printThreeStrikeSuccess();
        } while (strikeBall.getStrike() < Constants.strikeTarget);
    }
}
