package baseball.dto.request;

import java.util.List;

public class PlayerNumberDto {

    private final List<Integer> playerNumbers;

    public PlayerNumberDto(List<Integer> playerNumbers) {
        this.playerNumbers = playerNumbers;
    }

    public List<Integer> getPlayerNumbers() {
        return playerNumbers;
    }

}
