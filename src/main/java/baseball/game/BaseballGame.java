package baseball.game;

import static baseball.io.Input.numberInput;

import baseball.domain.BaseballFactory;
import baseball.domain.ComputerBaseballs;
import baseball.domain.UserBaseballs;
import baseball.dto.Result;
import baseball.io.Output;

public class BaseballGame {
    private ComputerBaseballs computerBaseballs;
    private final BaseballReferee baseballReferee;

    public BaseballGame() {
        computerBaseballs = null;
        baseballReferee = new BaseballReferee();
    }

    public void play() {
        init();

        Result result;
        do {
            result = playOnce();
            Output.gameResultOutput(result);
        } while (!baseballReferee.isUserWin(result));

        Output.successAndExitOutput();
    }

    private void init() {
        computerBaseballs = BaseballFactory.createComputerBaseballs();
    }

    private Result playOnce() {
        String userInput = numberInput();
        UserBaseballs userBaseballs = BaseballFactory.createUserBaseballs(userInput);

        return baseballReferee.createResult(computerBaseballs, userBaseballs);
    }
}
