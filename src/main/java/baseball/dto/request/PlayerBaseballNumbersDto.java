package baseball.dto.request;

import java.util.List;

public class PlayerBaseballNumbersDto {

    private final List<Integer> playerNumbers;

    public PlayerBaseballNumbersDto(List<Integer> playerNumbers) {
        this.playerNumbers = playerNumbers;
    }

    public List<Integer> getPlayerNumbers() {
        return playerNumbers;
    }

}
