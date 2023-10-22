package baseball.domain;

public class SingleBaseBallGame implements BaseBallGame {

    private final MatchPlayer matchPlayer;


    public SingleBaseBallGame(MatchPlayer matchPlayer) {
        this.matchPlayer = matchPlayer;
    }

    @Override
    public BaseBallHint checkBaseBallNumber(BaseBallNumbers baseBallNumber) {
        return matchPlayer.getHintOf(baseBallNumber);
    }
}
