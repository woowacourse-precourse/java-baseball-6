package baseball.computer;


import baseball.number.Numbers;
import baseball.utils.generator.BaseballRandomNumbersGenerator;
import baseball.utils.match.MatchResults;

public class Computer {
    private Numbers numbers;


    private final BaseballRandomNumbersGenerator numberGenerator;

    public Computer(BaseballRandomNumbersGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void generateNumbers() {
        this.numbers = numberGenerator.generateNumbers();
    }

    public MatchResults compare(Numbers otherNumbers) {
        return numbers.compare(otherNumbers);
    }
}
