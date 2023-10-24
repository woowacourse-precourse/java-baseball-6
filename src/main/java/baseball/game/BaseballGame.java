package baseball.game;

import baseball.common.Constants;
import baseball.game.status.BaseballGameStatus;
import baseball.player.ComputerPlayer;
import baseball.player.UserPlayer;
import baseball.view.InputView;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    public static BaseballGame instance;

    public static BaseballGame getInstance() {
        if(instance == null) {
            instance = new BaseballGame();
        }
        return instance;
    }

    private ComputerPlayer computerPlayer;
    private UserPlayer userPlayer;
    private BaseballGameStatus gameStatus;
    private InputView inputView;


    public void init() {
        this.computerPlayer = new ComputerPlayer();
        this.userPlayer = new UserPlayer();
        this.gameStatus = BaseballGameStatus.CONTINUE;
        this.inputView = new InputView();
    }

    public void process() {
        BaseballGameRound baseballGameRound;

        do {
            init();
            baseballGameRound = new BaseballGameRound(computerPlayer, userPlayer);
            baseballGameRound.start();

            int mode = inputView.nextInt();
            if(mode == Constants.gameExit) gameStatus = BaseballGameStatus.EXIT;
        } while (gameStatus.equals(BaseballGameStatus.CONTINUE));
    }
}
