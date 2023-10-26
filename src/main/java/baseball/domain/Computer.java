package baseball.domain;

import baseball.domain.generator.BaseballNumbersGenerator;
import baseball.domain.generator.BaseballRandomNumbersGenerator;

import java.util.List;

public class Computer {
    private final BaseballNumbersGenerator baseballNumbersGenerator;
    private List<Integer> answerNumbers;

    public Computer() {
        this.baseballNumbersGenerator = new BaseballRandomNumbersGenerator();
    }

    public Computer(BaseballNumbersGenerator baseballNumbersGenerator) {
        this.baseballNumbersGenerator = baseballNumbersGenerator;
    }

    public void generateAnswerNumbers() {
        this.answerNumbers = baseballNumbersGenerator.generate();
    }

    public List<Integer> getAnswerNumbers() {
        return answerNumbers;
    }

}
