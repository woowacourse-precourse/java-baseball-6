package baseball.controller;

public final class Scoring {

    private final String answer;

    public Scoring(Integer answer) {
        this.answer = answer.toString();
    }

    public String getAnswer() {
        return answer;
    }
}
