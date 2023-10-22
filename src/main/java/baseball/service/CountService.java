package baseball.service;

import baseball.dto.CountResultDto;
import java.util.List;

public class CountService {

    private CountService() {
    }

    public static CountResultDto calculateCount(List<Integer> computerNumber, List<Integer> playerNumber) {
        int strikeCount = calculateStrikeCount(computerNumber, playerNumber);
        int ballCount = calculateBallCount(computerNumber, playerNumber);
        return new CountResultDto(strikeCount, ballCount);
    }

    private static int calculateStrikeCount(List<Integer> computerNumberList, List<Integer> playerNumberList) {
        int strikeCount = 0;
        for (int i = 0; i < computerNumberList.size(); i++) {
            if (computerNumberList.get(i).equals(playerNumberList.get(i))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private static int calculateBallCount(List<Integer> computerNumberList, List<Integer> playerNumberList) {
        int ballCount = 0;
        for (int i = 0; i < computerNumberList.size(); i++) {
            if (computerNumberList.contains(playerNumberList.get(i))) {
                ballCount++;
            }
        }
        return ballCount;
    }
}
