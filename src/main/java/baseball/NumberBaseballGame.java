package baseball;

import baseball.computer.NumberBaseballGameComputerPlayer;
import baseball.numbergenerator.NumberGenerator;
import baseball.user.UserIo;

public class NumberBaseballGame {

    private final BaseballGameRules gameRules;
    private final NumberGenerator numberGenerator;
    private final UserIo userIo;

    public NumberBaseballGame(BaseballGameRules gameRules, NumberGenerator numberGenerator, UserIo userIo) {
        this.gameRules = gameRules;
        this.numberGenerator = numberGenerator;
        this.userIo = userIo;
    }

    void run() {
        new NumberBaseballGameComputerPlayer(numberGenerator.generateUniqueNumbers(), gameRules);
    }
}
