package baseball.model;

import java.util.List;

public class User {
    List<Integer> answer;

    public User(List<Integer> answer) {
        this.answer = answer;
    }

    public List<Integer> getAnswer() {
        return answer;
    }

    public void resetAnswer() {
        answer.clear();
    }
}
