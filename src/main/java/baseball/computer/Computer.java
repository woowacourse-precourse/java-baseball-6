package baseball.computer;

import baseball.computer.generator.RandomNumberGenerator;
import baseball.computer.judgement.JudgeResult;

import java.util.List;

public class Computer {
    private final JudgeResult judgeResult;
    private List<Integer> computerNumbers;


    public Computer() {
        this.judgeResult = new JudgeResult();
        this.computerNumbers = generateNumbers();
    }

    public String judgeGameResult(List<Integer> playerNumbers) {
        return judgeResult.getResult(playerNumbers, computerNumbers);
    }

    public void restartGame() {
        computerNumbers = generateNumbers();
    }

    private List<Integer> generateNumbers() {
        return new RandomNumberGenerator().getNumbers();
    }
}

