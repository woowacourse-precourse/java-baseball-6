package baseball.model;

public record GameResult(int tryCount, int correctAnswerCount, int similarAnswerCount) {
    public GameResult {
        if (isOverTryCount(tryCount, correctAnswerCount, similarAnswerCount)
                || isOneSimilarAllOthersCorrect(tryCount, correctAnswerCount, similarAnswerCount)) {
            throw new IllegalArgumentException("존재할 수 없는 게임 결과입니다.");
        }
    }

    private boolean isOverTryCount(int tryCount, int correctAnswerCount, int similarAnswerCount) {
        return tryCount < correctAnswerCount + similarAnswerCount;
    }

    private boolean isOneSimilarAllOthersCorrect(int tryCount, int correctAnswerCount, int similarAnswerCount) {
        return tryCount == correctAnswerCount + similarAnswerCount && similarAnswerCount == 1;
    }

    public boolean isPerfectGame() {
        return correctAnswerCount() == tryCount();
    }
}
