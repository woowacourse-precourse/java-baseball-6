package baseball.entity;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class CorrectNumber {

    private List<Integer> correctNumbers = new ArrayList<>();
    private int strikeNumber = 0;
    private int ballNumber = 0;

    public boolean isCorrect(String input) {
        strikeNumber = 0;
        ballNumber = 0;
        // 입력값 정답과 비교
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

        // 결과 출력
        if (strikeNumber != 0) {
            System.out.print(strikeNumber + "스트라이크 ");
        }
        if (strikeNumber == 3) {
            System.out.println();
            return true;
        }
        if (ballNumber != 0) {
            System.out.print(ballNumber + "볼 ");
        }
        if (ballNumber == 0 && strikeNumber == 0) {
            System.out.print("낫싱 ");
        }
        System.out.println();

        return false;
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
