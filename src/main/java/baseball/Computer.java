package baseball;

import java.util.List;

public class Computer {
    private List<Integer> answer;

    Computer() {
        initializeAnswer();
    }

    public void initializeAnswer() {
        this.answer = getNewAnswer();
    }

}
