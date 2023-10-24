package baseball.model;

import java.util.List;

public class Computer {

    private List<Integer> numbers;
    private GameStatus gameStatus;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setRandomNumbers(List<Integer> randomNumbers) {
        this.numbers = randomNumbers;
    }

    public void setGameStatusStart() {
        this.gameStatus = GameStatus.START;
    }

    public void setGameStatusStop() {
        this.gameStatus = GameStatus.STOP;
    }

}
