package baseball.domain;

public class SingleBaseBallGame implements BaseBallGame {

    private final MatchPlayer matchPlayer;


    public SingleBaseBallGame(MatchPlayer matchPlayer) {
        this.matchPlayer = matchPlayer;
    }
}
