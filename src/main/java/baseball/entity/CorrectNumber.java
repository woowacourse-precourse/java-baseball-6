package baseball.entity;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

// CorrectNumber는 정답 생성, 관리, 비교
public class CorrectNumber {

    private List<Integer> correctNumbers = new ArrayList<>();

    public Result compareTo(String input) {
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
        return new Result(strikeNumber,ballNumber);
    }

    public void generateCorrectNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        this.correctNumbers = computer;
    }

    public List<Integer> getCorrectNumbers() {
        return correctNumbers;
    }
}
