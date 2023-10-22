package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    List<Integer> answer = new ArrayList<>();

    public void createAnswer(int size) {
        int randomNumber;
        int i = 0;

        while (i < size) {
            randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
                i++;
            }
        }
    }

    public Boolean isEqueal(List<Integer> userAnswer) {
        return answer.equals(userAnswer);
    }

    public Boolean isContain(Integer userAnswer) {
        return answer.contains(userAnswer);
    }

    public Boolean isSameDigit(Integer index, Integer userAnswer) {
        int digit;

        digit = answer.get(index);
        return userAnswer.equals(digit);
    }

    public void resetAnswer() {
        answer.clear();
    }
}
