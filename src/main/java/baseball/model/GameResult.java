package baseball.model;

public record GameResult(int perfectGameCount, int correctCount, int similarCount) {
    public GameResult {
        if (perfectGameCount < correctCount + similarCount) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isPerfectGame() {
        return correctCount() == perfectGameCount();
    }
}
