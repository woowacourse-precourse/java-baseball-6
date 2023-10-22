package baseball.domain;

public class GameResultDTO {
    int ballCount;
    int strikeCount;

    public GameResultDTO(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public StringBuilder getResult(StringBuilder messageBuilder) {
        if (strikeCount == 0 && ballCount == 0) {
            messageBuilder.append("낫싱");
        }

        if (ballCount != 0) {
            messageBuilder.append(ballCount).append("볼 ");
        }

        if (strikeCount != 0) {
            messageBuilder.append(strikeCount).append("스트라이크");
        }

        return messageBuilder;
    }

    public boolean getIsGameFinished() {
        return strikeCount == 3;
    }
}
