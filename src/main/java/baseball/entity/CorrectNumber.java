package baseball.entity;

import baseball.util.RandomNumGenerator;
import java.util.List;

// CorrectNumber는 정답 생성, 관리, 비교
public class CorrectNumber {

    private List<Integer> correctNumbers;

    public Result compareToInput(String input) {
        int strikeNumber = 0;
        int ballNumber = 0;
        String[] parsedString = input.split("");
        for (int i = 0; i < input.length(); i++) {
            int number = Integer.parseInt(parsedString[i]);
            if (correctNumbers.contains(number)) {
                if (number == correctNumbers.get(i)) {
                    strikeNumber++;
                } else {
                    ballNumber++;
                }
            }
        }
        return new Result(strikeNumber, ballNumber);
    }

    public void generateNewCorrectNum() {
        this.correctNumbers = RandomNumGenerator.generate();
    }

    public List<Integer> getCorrectNumbers() {
        return correctNumbers;
    }
}
