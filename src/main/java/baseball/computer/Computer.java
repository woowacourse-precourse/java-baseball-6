package baseball.computer;

import baseball.computer.generator.NumberGenerator;
import baseball.domain.number.NumberConstants;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private NumberGenerator numberGenerator;
    private List<Integer> gameNumbers;

    public Computer(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
        this.gameNumbers = generateNumbers();
    }

    public Computer(List<Integer> gameNumbers) {
        this.gameNumbers = gameNumbers;
    }

    public void changeNumbers() {
        this.gameNumbers = generateNumbers();
    }

    public List<Integer> getGameNumbers() {
        return gameNumbers;
    }

    private List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < NumberConstants.NUMBERS_LENGTH) {
            int randomNumber = numberGenerator.generate(NumberConstants.MIN_NUMBER, NumberConstants.MAX_NUMBER);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }
}
