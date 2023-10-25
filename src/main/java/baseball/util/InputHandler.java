package baseball.util;

import baseball.dto.BattedBallsDTO;
import baseball.dto.Command;

public interface InputHandler {

    BattedBallsDTO getBattedBallsInput();

    Command getCommand();
}
