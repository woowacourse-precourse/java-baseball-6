package baseball.service;

import baseball.dto.PlayResult;
import baseball.model.Computer;
import baseball.model.PlayerBalls;

import java.util.List;

public class GameService {

    private final Computer computer;

    public GameService() {
        this.computer = new Computer();
    }

    public PlayResult attack(List<Integer> guessingNumbers) {
        PlayerBalls playerBalls = new PlayerBalls(guessingNumbers);

        return playerBalls.attackComputer(computer);
    }
}
