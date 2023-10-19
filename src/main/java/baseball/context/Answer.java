package baseball.context;

import baseball.utils.Randoms;

public class Answer {

    private String answer;

    public Answer() {
        this(Randoms.generateBaseballNumbers());
    }

    public Answer(String initialAnswer) {
        this.answer = initialAnswer;
    }

    public String getAnswer() {
        return answer;
    }

    public void regenerateAnswer() {
        this.answer = Randoms.generateBaseballNumbers();
    }
}
