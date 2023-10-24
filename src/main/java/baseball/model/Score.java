package baseball.model;

public record Score(int strikes, int balls) {

    public boolean isGameWon() {
        return strikes == 3;
    }
}
