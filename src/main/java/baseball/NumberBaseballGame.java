package baseball;

import baseball.computer.NumberBaseballGameComputerPlayer;
import baseball.user.UserIo;

public class NumberBaseballGame {

    private final BaseballGameRules gameRules;
    private final NumberBaseballGameComputerPlayer computerPlayer;
    private final UserIo userIo;

    public NumberBaseballGame(BaseballGameRules gameRules, NumberBaseballGameComputerPlayer computerPlayer,
            UserIo userIo) {
        this.gameRules = gameRules;
        this.computerPlayer = computerPlayer;
        this.userIo = userIo;
    }

    void run() {
        
    }
}
