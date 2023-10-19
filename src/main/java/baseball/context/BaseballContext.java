package baseball.context;

import baseball.game.dto.BaseballMatchResults;
import baseball.game.transform.BaseballMatchResultsStringTransformer;
import baseball.game.transform.Transformer;

public class BaseballContext {

    private GameState gameState;
    private final Answer answer;
    private final Transformer<BaseballMatchResults, String> transformer;

    public BaseballContext() {
        this(new Answer());
    }

    public BaseballContext(Answer answer) {
        this(GameState.RUNNING, answer);
    }

    public BaseballContext(GameState initialState, Answer answer) {
        this.gameState = initialState;
        this.answer = answer;
        this.transformer = new BaseballMatchResultsStringTransformer();
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

    public String transformer(BaseballMatchResults results) {
        return transformer.transform(results);
    }
}
