package baseball.computer;

import baseball.computer.generator.RandomNumberGenerator;
import baseball.computer.judgement.JudgeResult;

import java.util.List;

public class Computer {
    private final JudgeResult judgeResult;
    private final RandomNumberGenerator randomNumberGenerator;
    private List<Integer> computerNumbers;


    public Computer(JudgeResult judgeResult, RandomNumberGenerator randomNumberGenerator) {
        this.judgeResult = judgeResult;
        this.randomNumberGenerator = randomNumberGenerator;
        this.computerNumbers = generateNumbers();
    }

    public String judgeGameResult(List<Integer> playerNumbers) {
        return judgeResult.getResult(playerNumbers, computerNumbers);
    }

    public void restartGame() {
        computerNumbers = randomNumberGenerator.generateNewNumbers();
    }

    private List<Integer> generateNumbers() {
        return randomNumberGenerator.getNumbers();
    }
}

