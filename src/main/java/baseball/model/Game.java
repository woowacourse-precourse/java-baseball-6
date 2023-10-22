package baseball.model;


import static baseball.model.GameNumbers.NUMBERS_SIZE;
import static baseball.model.GameNumbers.createRandomGameNumbers;

import java.util.Objects;

public class Game {

    private GameNumbers userGameNumbers;
    private final GameNumbers computerGameNumbers = createRandomGameNumbers();
    private final Result result = new Result();

    public void updateUserNumbers(GameNumbers userGameNumbers) {
        this.userGameNumbers = userGameNumbers;
    }

    public void play() {
        for (int i = 0; i < NUMBERS_SIZE; i++) {
            judgeNumberAt(i);
        }
    }

    private void judgeNumberAt(int index) { // FIXME
        if (Objects.equals(userGameNumbers.getNumbers().get(index), computerGameNumbers.getNumbers().get(index))) {
            result.strike();
        } else if (userGameNumbers.getNumbers().contains(computerGameNumbers.getNumbers().get(index))) {
            result.ball();
        }
    }

    public void resetResult() {
        this.result.reset();
    }

    public boolean isRunning() {
        return this.result.isRunning();
    }

    public Result getResult() {
        return this.result;
    }
}
