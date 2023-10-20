package baseball.domain;

public class Game {

    private final NumbersGenerator numbersGenerator;

    private Numbers computerNumbers;

    public Game(final NumbersGenerator numbersGenerator) {
        this.numbersGenerator = numbersGenerator;
    }

    public void initialize() {
        this.computerNumbers = numbersGenerator.generate();
    }

    public Judgement play(final String numberString) {
        final Numbers playerNumbers = Numbers.ofString(numberString);
        return computerNumbers.judge(playerNumbers);
    }
}
