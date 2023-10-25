package baseball.player;

import baseball.number.Numbers;

public class Player {
    private Numbers numbers;

    public void inputNumbers(Numbers numbers) {
        this.numbers = numbers;
    }

    public Numbers getNumbers() {
        return numbers;
    }
}
