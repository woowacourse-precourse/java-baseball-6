package baseball.domain;

import baseball.resource.GameMessage;
import baseball.resource.GameValue;
import baseball.validator.InputValidation;
import baseball.view.OutPutView;
import camp.nextstep.edu.missionutils.Console;

import java.util.Objects;

public class GameManager {

    public boolean reStartGame() {
        OutPutView.printReStartMessage();
        String reStartPlayerNumber = Console.readLine();
        InputValidation.reStartCheck(reStartPlayerNumber);
        return Objects.equals(Integer.parseInt(reStartPlayerNumber), GameValue.RESTART_GAME_VALUE);
    }

    public BallAndStrikeCount ballAndStrikeComparison(Numbers systemNumbers, Numbers playerNumbers) {
        return systemNumbers.ballAndStrikeCount(playerNumbers);
    }
}