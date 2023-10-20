package baseball.domain;

import baseball.resource.GameMessage;
import baseball.resource.GameValue;
import baseball.validator.InputValidation;
import camp.nextstep.edu.missionutils.Console;

import java.util.Objects;

public class GameManager {

    public boolean reStartGame() {
        System.out.println(GameMessage.RESTART_QUESTION_MESSAGE);
        String reStartPlayerNumber = Console.readLine();
        InputValidation.reStartCheck(reStartPlayerNumber);
        return Objects.equals(reStartPlayerNumber, GameValue.RESTART_GAME_VALUE);
    }
}