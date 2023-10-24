package baseball;

public class BullsAndCowsGame extends AbstractTurnBasedGame {
    @Override
    protected boolean hasNextRound() throws IllegalArgumentException {
        return false;
    }

    @Override
    protected boolean hasNextTurn() {
        return false;
    }
}
