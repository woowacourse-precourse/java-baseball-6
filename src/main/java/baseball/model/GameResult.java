package baseball.model;

public record GameResult(int perfectGameCount, int correctCount, int similarCount) {

    public boolean isPerfectGame() {
        return correctCount() == perfectGameCount();
    }
}
