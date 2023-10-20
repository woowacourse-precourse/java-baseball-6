package baseball;

public class VisitedChecker {
    private boolean[] userVisited;
    private boolean[] answerVisited;

    public VisitedChecker (int numberLength) {
        this.userVisited = new boolean[numberLength];
        this.answerVisited = new boolean[numberLength];
    }

    public void checkVisited (int index) {
        this.userVisited[index] = true;
        this.answerVisited[index] = true;
    }
    public void checkVisitedForAnswer (int index) {
        this.answerVisited[index] = true;
    }

    public boolean isVisitedForAnswer (int index) {
        return this.answerVisited[index];
    }
}
