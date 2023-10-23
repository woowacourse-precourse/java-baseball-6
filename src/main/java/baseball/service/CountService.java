package baseball.service;

import baseball.domain.ComputerNumber;
import baseball.domain.PlayerNumber;
import baseball.dto.CountResultDto;
import java.util.stream.IntStream;

public class CountService {

    public CountResultDto getCountResult(ComputerNumber computerNumber, PlayerNumber playerNumber) {
        int strikeCount = calculateStrikeCount(computerNumber, playerNumber);
        int ballCount = calculateBallCount(computerNumber, playerNumber);
        return new CountResultDto(strikeCount, ballCount);
    }

    private int calculateStrikeCount(ComputerNumber computerNumber, PlayerNumber playerNumber) {
        return (int) IntStream.range(0, computerNumber.size())
                .filter(i -> computerNumber.isSamePosition(playerNumber, i))
                .count();
    }

    private int calculateBallCount(ComputerNumber computerNumber, PlayerNumber playerNumber) {
        return (int) IntStream.range(0, computerNumber.size())
                .filter(i -> computerNumber.isContainNumber(playerNumber, i))
                .filter(i -> !computerNumber.isSamePosition(playerNumber, i))
                .count();
    }
}
