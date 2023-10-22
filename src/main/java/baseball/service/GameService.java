package baseball.service;

import baseball.model.dto.Score;
import baseball.model.entity.BaseballNumber;
import baseball.model.entity.Computer;


public class GameService {
    private Computer computer;
    public void startGame() {
        computer = new Computer();
    }

    public Score calculateResult(BaseballNumber inputNumbers) {
        int strike = 0, ball = 0;
        for(int i = 0; i < 3; i++) {
            Integer resultNumber = inputNumbers.getNumbers().get(i);
            if(resultNumber.equals(computer.getBaseballNumber().getNumbers().get(i))) {
                strike++;
            } else if(computer.getBaseballNumber().getNumbers().contains(resultNumber)) {
                ball++;
            }
        }
        return new Score(strike, ball);
    }
}
