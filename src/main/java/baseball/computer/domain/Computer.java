package baseball.computer.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> randomAnswer;

    public Computer() {
        this.randomAnswer = new ArrayList<>();
    }

    public List<Integer> createRandomAnswer() {
        while (randomAnswer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomAnswer.contains(randomNumber)) {
                randomAnswer.add(randomNumber);
            }
        }
        return randomAnswer;
    }

    public void validateInput(String input) {

        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력받을 수 있습니다.");
        }

        if (input.length() != 3) {
            throw new IllegalArgumentException("3자리의 수를 입력해야합니다.");
        }

        for (int i = 0; i < 3; i++) {
            if (input.indexOf(input.charAt(i)) != i) {
                throw new IllegalArgumentException("각 자리의 수가 서로 달라야합니다.");
            }
        }
    }



}
