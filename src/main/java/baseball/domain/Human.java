package baseball.domain;


import baseball.domain.number.Numbers;

public class Human implements Player {

    private Numbers numbers;

    private Human() {
    }

    public static Human create() {
        return new Human();
    }

    @Override
    public Numbers getNumbers() {
        return numbers;
    }

    @Override
    public void changeNumbers(Numbers numbers) {
        this.numbers = numbers;
    }

    @Override
    public void reset() {
        this.numbers = null;
    }

}
