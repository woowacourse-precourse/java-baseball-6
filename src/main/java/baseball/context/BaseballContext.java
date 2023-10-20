package baseball.context;

import baseball.game.dto.BaseballScore;
import baseball.game.transform.BaseballScoreToStringTransformer;
import baseball.game.transform.Transformer;

public class BaseballContext {

    private final GameLifeCycle gameLifeCycle;
    private final Answer answer;
    private final Transformer<BaseballScore, String> transformer;

    public BaseballContext() {
        this(new Answer());
    }

    public BaseballContext(Answer answer) {
        this(new GameLifeCycle(GameState.RUNNING), answer);
    }

    public BaseballContext(GameLifeCycle initialState, Answer answer) {
        this.gameLifeCycle = initialState;
        this.answer = answer;
        this.transformer = new BaseballScoreToStringTransformer();
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

    public String transformer(BaseballScore results) {
        return transformer.transform(results);
    }
}
