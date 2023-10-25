package baseball.model;

public record GameResult(int tryCount, int correctAnswerCount, int similarAnswerCount) {
    public GameResult {
        if (tryCount < correctAnswerCount + similarAnswerCount) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isPerfectGame() {
        return correctAnswerCount() == tryCount();
    }
}
