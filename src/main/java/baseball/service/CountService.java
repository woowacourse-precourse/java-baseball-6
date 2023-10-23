package baseball.service;

import baseball.domain.ComputerNumber;
import baseball.domain.PlayerNumber;
import baseball.dto.CountResultDto;

public class CountService {

    public CountResultDto getCountResult(ComputerNumber computerNumber, PlayerNumber playerNumber) {
        int strikeCount = calculateStrikeCount(computerNumber, playerNumber);
        int ballCount = calculateBallCount(computerNumber, playerNumber);
        return new CountResultDto(strikeCount, ballCount);
    }

    private int calculateStrikeCount(ComputerNumber computerNumber, PlayerNumber playerNumber) {
        int count = 0;
        for (int i = 0; i < computerNumber.size(); i++) {
            if (computerNumber.isSamePosition(playerNumber, i)) {
                count++;
            }
        }
        return count;
    }

    private int calculateBallCount(ComputerNumber computerNumber, PlayerNumber playerNumber) {
        int count = 0;
        for (int i = 0; i < computerNumber.size(); i++) {
            if (computerNumber.isContainNumber(playerNumber, i)) {
                count++;
            }
        }
        return count;
    }
}
