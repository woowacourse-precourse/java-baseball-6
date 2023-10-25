package baseball.controller;

import baseball.dto.GameDecision;
import baseball.dto.GameNumber;
import camp.nextstep.edu.missionutils.Console;

public class GameController {

    public GameNumber getInputGameNumber() {
        return new GameNumber(Console.readLine());
    }

    public GameDecision getGameDecision() {
        return new GameDecision(Console.readLine());
    }
}
