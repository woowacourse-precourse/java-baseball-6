package baseball.Player;

import java.util.List;

public abstract class Player {
    protected List<Integer> answer;
    protected static final int ANSWER_SIZE = 3;

    public void setAnswer() {
        this.answer = generateAnswer();
    }

    abstract List<Integer> generateAnswer();
}
