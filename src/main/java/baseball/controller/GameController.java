package baseball.controller;

import baseball.dto.GameDecision;
import baseball.dto.GameNumber;
import camp.nextstep.edu.missionutils.Console;

public class GameController {

    public static final String RETRY_COMMAND = "1";
    public static final String END_COMMAND = "2";

    public GameNumber getInputGameNumber() {
        return GameNumber.makeGameNumberByInput(Console.readLine());
    }

    public GameDecision getGameDecision() {
        return GameDecision.makeGameDecisionByInput(Console.readLine());
    }
}
