package baseball.service;

import baseball.dto.CountResultDto;
import java.util.List;

public class CountService {

    public CountResultDto calculateCount(String computerNumber, String playerNumber) {
        List<Integer> computerNumberList = ConversionService.stringToListOfInteger(computerNumber);
        List<Integer> playerNumberList = ConversionService.stringToListOfInteger(playerNumber);

        int strikeCount = calculateStrikeCount(computerNumberList, playerNumberList);
        int ballCount = calculateBallCount(computerNumberList, playerNumberList);

        return new CountResultDto(strikeCount, ballCount);
    }

    public int calculateStrikeCount(List<Integer> computerNumberList, List<Integer> playerNumberList) {
        int strikeCount = 0;
        for (int i = 0; i < computerNumberList.size(); i++) {
            if (computerNumberList.get(i).equals(playerNumberList.get(i))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public int calculateBallCount(List<Integer> computerNumberList, List<Integer> playerNumberList) {
        int ballCount = 0;
        for (int i = 0; i < computerNumberList.size(); i++) {
            if (computerNumberList.contains(playerNumberList.get(i))) {
                ballCount++;
            }
        }
        return ballCount;
    }
}
