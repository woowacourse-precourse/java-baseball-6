package baseball.domain;

public class BaseballSingleGame implements BaseBallGame {

    private final MatchPlayer matchPlayer;


    public BaseballSingleGame(MatchPlayer matchPlayer) {
        this.matchPlayer = matchPlayer;
    }

    @Override
    public BaseBallHint checkBaseBallNumber(BaseBallNumbers baseBallNumber) {
        return matchPlayer.getHintOf(baseBallNumber);
    }
}
