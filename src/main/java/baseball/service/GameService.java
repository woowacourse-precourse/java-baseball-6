package baseball.service;

import baseball.model.dto.Score;
import baseball.model.entity.Baseball;
import baseball.model.entity.Computer;


public class GameService {
    private Computer computer;
    public void startGame() {
        computer = new Computer();
    }

    public Score calculateResult(Baseball inputNumbers) {

        Baseball computerNumber = computer.getBaseballNumber();

        int strike = inputNumbers.countStrike(computerNumber);
        int ball = inputNumbers.countBall(computerNumber);

        return new Score(strike, ball);
    }
}
