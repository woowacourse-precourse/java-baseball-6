package baseball.model;

import java.util.StringJoiner;

public record GameResult(int correctCount, int similarCount) {

    public boolean isPerfectGame(final int gameNumberSize) {
        return correctCount() == gameNumberSize;
    }

    @Override
    public String toString() {
        if (correctCount() + similarCount() == 0) {
            return "낫싱";
        }

        StringJoiner stringJoiner = new StringJoiner(" ");

        if (0 < similarCount()) {
            stringJoiner.add(similarCount() + "볼");
        }

        if (0 < correctCount()) {
            stringJoiner.add(correctCount() + "스트라이크");
        }

        return stringJoiner.toString();
    }
}
