package baseball.dto.request;

public class GameRestartDto {

    private final int commandNumber;

    public GameRestartDto(int commandNumber) {
        this.commandNumber = commandNumber;
    }

    public int getGameRestartNumber() {
        return commandNumber;
    }

}
