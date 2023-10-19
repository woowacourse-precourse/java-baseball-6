package baseball.dto.request;

public class GameRestartDto {

    private final int restartNumber;

    public GameRestartDto(int restartNumber) {
        this.restartNumber = restartNumber;
    }

    public int getGameRestartNumber() {
        return restartNumber;
    }

}
