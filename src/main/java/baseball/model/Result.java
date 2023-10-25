package baseball.model;

public class Result {
    private int strikeCount;
    private int ballCount;
    private String message;

    public Result(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;

        String message = "";

        if (ballCount > 0) message += String.format("%d볼 ", this.ballCount);
        if (strikeCount > 0) message += String.format("%d스트라이크", this.strikeCount);
        if (message.isEmpty()) message += "낫싱";

        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}