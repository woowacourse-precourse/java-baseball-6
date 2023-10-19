package baseball.context;

public class BaseballContext {

    private GameState gameState;
    private final Answer answer;

    public BaseballContext() {
        this(new Answer());
    }

    public BaseballContext(Answer answer) {
        this(GameState.RUNNING, answer);
    }

    public BaseballContext(GameState initialState, Answer answer) {
        this.gameState = initialState;
        this.answer = answer;
    }

    public void finish() {
        this.gameState = GameState.FINISH;
    }

    public boolean isRunning() {
        return this.gameState == GameState.RUNNING;
    }

    public String getAnswer() {
        return answer.getAnswer();
    }

    public void regenerateAnswer() {
        answer.regenerateAnswer();
    }
}
