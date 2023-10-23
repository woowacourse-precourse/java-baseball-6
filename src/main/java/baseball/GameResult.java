package baseball;

public record GameResult(int strikes, int balls) {

    public boolean isGameEnd() {
        return strikes == 3;
    }
}
