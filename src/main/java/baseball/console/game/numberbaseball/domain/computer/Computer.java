package baseball.console.game.numberbaseball.domain.computer;

import baseball.console.game.numberbaseball.domain.system.GameHint;
import baseball.console.game.numberbaseball.domain.system.GameNumber;
import baseball.console.game.numberbaseball.domain.system.GameResult;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private GameNumber number;
    private GameHint hint;
    private GameResult result;

    public Computer() {
    }

    public void generate() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber))
                computer.add(randomNumber);
        }
        number = new GameNumber(computer);
    }

    public String result() {
        result = new GameResult(hint);
        return result.exportMessage();
    }

    public void compute(GameNumber userNumber) {
        hint = new GameHint();
        for (int i = 0; i < 3; i++) {
            determineStrikeOrBall(userNumber.getNumberList().get(i), i);
        }
    }

    private void determineStrikeOrBall(int digit, int index) {
        if (isStrike(digit, index)) {
            hint.addStrike();
            return;
        }
        if (isBall(digit))
            hint.addBall();
    }

    private boolean isStrike(int digit, int index) {
        return digit == number.getNumberList().get(index);
    }

    private boolean isBall(int digit) {
        return number.getNumberList().contains(digit);
    }

    public boolean answer() {
        return hint.getStrike() == 3;
    }
}
