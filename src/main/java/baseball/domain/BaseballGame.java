package baseball.domain;

public class BaseballGame {
    private final BaseballNumbers answer;

    private BaseballGame(BaseballNumbers answer) {
        this.answer = answer;
    }
    public static BaseballGame of(BaseballNumbers answer){
        return new BaseballGame(answer);
    }

    public GameResult judge(BaseballNumbers userNumber) {
        return null;
    }
}
