package baseball.domain;


import baseball.domain.number.Numbers;

public class Human implements Player {

    private Numbers numbers;

    private Human() {
    }

    public Human create() {
        return new Human();
    }

    public void changeNumbers(Numbers numbers) {
        this.numbers = numbers;
    }

    @Override
    public Numbers getNumbers() {
        return numbers;
    }
}
