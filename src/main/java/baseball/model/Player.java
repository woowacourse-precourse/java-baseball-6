package baseball.model;

import java.util.List;

public class Player {
    private List<Integer> numbers;
    private int strikeCount = 0;
    private int ballCount = 0;


    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void addStrikeCount() {
        this.strikeCount++;
    }

    public void addBallCount() {
        this.ballCount++;
    }


    public String createHintMessage() {
        StringBuilder gameResult = new StringBuilder();

        if (isNothing()) {
            return "낫싱";
        }

        if (isStrike()) {
            return strikeCount + "스트라이크";
        }

        if (isBall()) {
            gameResult.append(ballCount + "볼");
        }
        if (isStrikeWithBall()) {
            gameResult.append(" " + strikeCount + "스트라이크");
        }

        return gameResult.toString();
    }

    public boolean isCompleted() {
        return strikeCount == Rule.MAX_LENGTH;
    }

    public boolean isNothing() {
        return ballCount + strikeCount == 0;
    }

    public boolean isStrike() {
        return isCompleted() || strikeCount > 0 && ballCount == 0;
    }

    public boolean isStrikeWithBall() {
        return strikeCount > 0 && ballCount > 0;
    }

    public boolean isBall() {
        return ballCount > 0;
    }
}

