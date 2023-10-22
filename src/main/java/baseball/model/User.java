package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    List<Integer> answer = new ArrayList<>();

    public void setAnswer(List<Integer> answer) {
        this.answer = answer;
    }

    public List<Integer> getAnswer() {
        return answer;
    }

    public void resetAnswer() {
        answer.clear();
    }
}
