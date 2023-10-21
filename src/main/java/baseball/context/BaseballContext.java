package baseball.context;

import baseball.game.Answer;

public class BaseballContext {

    private final GameLifeCycle gameLifeCycle;
    private final Answer answer;

    public BaseballContext() {
        this(new Answer());
    }

    public BaseballContext(Answer answer) {
        this(new GameLifeCycle(GameState.RUNNING), answer);
    }

    public BaseballContext(GameLifeCycle initialState, Answer answer) {
        this.gameLifeCycle = initialState;
        this.answer = answer;
    }

    public GameLifeCycle getGameLifeCycle() {
        return gameLifeCycle;
    }

    public String getAnswer() {
        return answer.getAnswer();
    }

    public void regenerateAnswer() {
        answer.regenerateAnswer();
    }
}
