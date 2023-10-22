package baseball.domain;


import baseball.domain.numbers.Numbers;

public class Hitter {

    private Numbers numbers;

    private Hitter() {
    }

    public static Hitter create(Numbers numbers) {
        Hitter hitter = new Hitter();
        hitter.setNumbers(numbers);

        return hitter;
    }

    private void setNumbers(Numbers numbers) {
        this.numbers = numbers;
    }


    public Result battleByNumbers(Numbers opponentNumbers) {
        return numbers.calculateResult(opponentNumbers);
    }

}
