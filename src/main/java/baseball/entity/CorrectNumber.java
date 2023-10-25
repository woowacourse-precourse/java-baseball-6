package baseball.entity;

import baseball.util.RandomNumGenerator;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// CorrectNumber는 정답 생성, 관리, 비교
public class CorrectNumber {

    private List<Integer> correctNumbers;

    public void generateNewCorrectNum() {
        this.correctNumbers = RandomNumGenerator.generate();
    }

    public Result compareToInput(String input) {
        List<Integer> inputNumbers = parseInput(input);
        int strikeCount = countStrikes(inputNumbers);
        int ballCount = countBalls(inputNumbers);

        return new Result(strikeCount, ballCount);
    }

    private List<Integer> parseInput(String input) {
        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private int countStrikes(List<Integer> inputNumbers) {
        int strikeCount = 0;
        for (int i = 0; i < inputNumbers.size(); i++) {
            int inputNumber = inputNumbers.get(i);
            if (inputNumber == correctNumbers.get(i)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private int countBalls(List<Integer> inputNumbers) {
        int ballCount = 0;
        for (int i = 0; i < inputNumbers.size(); i++) {
            int inputNumber = inputNumbers.get(i);
            if (correctNumbers.contains(inputNumber) && inputNumber != correctNumbers.get(i)) {
                ballCount++;
            }
        }
        return ballCount;
    }


    public List<Integer> getCorrectNumbers() {
        return correctNumbers;
    }
}