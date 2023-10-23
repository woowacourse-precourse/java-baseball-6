package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    List<Integer> answer = new ArrayList<>();

    public Computer(List<Integer> answer) {
        this.answer = answer;
    }

    public Boolean isEqueal(List<Integer> userAnswer) {
        return answer.equals(userAnswer);
    }

    public Boolean isContain(int userAnswer) {
        return answer.contains(userAnswer);
    }

    public Boolean isSameDigit(int index, int userAnswer) {
        int digit = answer.get(index);
        return userAnswer == digit;
    }

    public void resetAnswer() {
        answer.clear();
    }
}
