package baseball.util;

import baseball.dto.BattedBallsDTO;
import baseball.dto.Command;
import camp.nextstep.edu.missionutils.Console;

public class InputHandlerImpl implements InputHandler {

    @Override
    public BattedBallsDTO getBattedBallsInput() {
        return BattedBallsDTO.from(readLine());
    }

    @Override
    public Command getCommand() {
        return Command.from(readLine());
    }

    private String readLine() {
        return Console.readLine();
    }
}
