package baseball.controller.dto;

public record Result(int strikeCount, int ballCount) {

    public boolean clearedGame(int numberCount) {
        return strikeCount == numberCount;
    }

}
