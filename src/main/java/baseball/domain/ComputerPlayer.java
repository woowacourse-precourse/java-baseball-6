package baseball.domain;

public class ComputerPlayer implements MatchPlayer {

    private final BaseBallNumbers baseBallNumbers;

    public ComputerPlayer(BaseBallNumberGenerator numberGenerator) {
        this.baseBallNumbers = numberGenerator.create();
    }
}
