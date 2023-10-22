package baseball.computer;

import baseball.numbergenerator.NumberGenerator;
import java.util.List;

public class NumberBaseballGameComputerPlayer {

    private final NumberGenerator numberGenerator;
    private List<Integer> numbers;

    public NumberBaseballGameComputerPlayer(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void generateNumber() {
        this.numbers = numberGenerator.generateUniqueNumbers();
    }
}
