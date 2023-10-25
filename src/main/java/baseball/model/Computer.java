package baseball.model;

import baseball.counter.CountResult;
import baseball.counter.Counter;

public class Computer {
    private final Numbers numbers;

    public Computer(Numbers numbers) {
        this.numbers = numbers;
    }

    public static Computer generateComputerAsRandomNumbers() {
        return new Computer(Numbers.createRandomNumbers());
    }

    public CountResult getGameResult(Player player) {
        return Counter.countStrikeAndBall(this.numbers.getNumbers(), player.getNumbers());
    }
}
