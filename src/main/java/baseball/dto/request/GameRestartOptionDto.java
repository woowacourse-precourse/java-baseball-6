package baseball.dto.request;

public class GameRestartOptionDto {

    private final int optionNumber;

    public GameRestartOptionDto(int optionNumber) {
        this.optionNumber = optionNumber;
    }

    public int getRestartOptionNumber() {
        return optionNumber;
    }

}
