package baseball.domain;

public class Computer {
    private RandomNumbers randomNumbers;

    public Computer() {
        this.randomNumbers = new RandomNumbers();
    }

    public void regenerateRandomNumbers() {
        this.randomNumbers = new RandomNumbers();
    }
}
