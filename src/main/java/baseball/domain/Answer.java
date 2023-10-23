package baseball.domain;

public class Answer {
    private final int[] answer;
    private final boolean[] visit;

    protected Answer(int[] answer, boolean[] visit){
        this.answer = answer;
        this.visit = visit;
    }


    public int[] getAnswers() {
        return answer;
    }

    public boolean[] getVisit() {
        return visit;
    }
}
