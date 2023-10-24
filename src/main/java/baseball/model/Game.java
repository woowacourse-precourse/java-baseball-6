package baseball.model;


import static baseball.model.GameNumbers.NUMBERS_SIZE;
import static baseball.model.GameNumbers.createRandomGameNumbers;

import java.util.List;
import java.util.Objects;

public class Game {

    private final GameNumbers computerGameNumbers = createRandomGameNumbers();
    private GameNumbers userGameNumbers;
    private Result result = new Result();

    public void play() {
        for (int i = 0; i < NUMBERS_SIZE; i++) {
            judgeNumberAt(i);
        }
    }

    private void judgeNumberAt(int index) {
        int userNumber = userGameNumbers.getNumberAt(index);
        int computerNumber = computerGameNumbers.getNumberAt(index);
        if (Objects.equals(userNumber, computerNumber)) {
            result.countUpStrike();
        } else if (userGameNumbers.contains(computerNumber)) {
            result.countUpBall();
        }
    }

    public boolean isRunning() {
        return this.result.getStrike() < NUMBERS_SIZE;
    }

    public GameNumbers getComputerGameNumbers() {
        return this.computerGameNumbers;
    }

    public Result getResult() {
        return this.result;
    }

    public void setUserNumbers(List<Integer> userNumbers) {
        this.userGameNumbers = new GameNumbers(userNumbers);
    }

    public void setResult() {
        this.result = new Result();
    }
}
