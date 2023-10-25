package baseball.domain;

import static baseball.utils.GameSetting.NUMBER_SIZE;

import baseball.enums.CommandType;
import java.util.List;

public class GameManager {
    public boolean isGameSuccess;
    private final Player player;
    private final Computer computer;
    private final Referee referee;

    public GameManager() {
        isGameSuccess = false;
        player = new Player();
        computer = new Computer();
        referee = new Referee();
    }

    public void initGame() {
        isGameSuccess = false;
        computer.refreshNumbers();
    }

    public List<Integer> guessNumber(String playerNumber) throws IllegalArgumentException {
        player.setNumbers(playerNumber);
        List<Integer> result = referee.countBallAndStrike(computer.getNumbers(), player.getNumbers());
        if (result.get(1) == NUMBER_SIZE) {
            isGameSuccess = true;
        }
        return result;
    }

    public boolean isGameRetry(String commandCode) throws IllegalArgumentException {
        return CommandType.selectCommandTypeByCode(commandCode)
                .equals(CommandType.RETRY);
    }
}