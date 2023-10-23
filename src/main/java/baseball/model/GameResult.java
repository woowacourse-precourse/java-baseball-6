package baseball.model;

public record GameResult(int correctCount, int similarCount) {

    public boolean isPerfectGame(final int gameNumberSize) {
        return correctCount() == gameNumberSize;
    }
}
