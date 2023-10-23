package baseball.core;

import baseball.dto.GameResult;

import java.util.List;

public class ThreeStrikeEndGameRule implements GameRule {

    @Override
    public GameResult apply(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int ballCount = getBallCount(computerNumbers, userNumbers);
        int strikeCount = getStrikeCount(computerNumbers, userNumbers);
        return new GameResult(ballCount, strikeCount);
    }

    private int getStrikeCount(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int strikeCount = 0;
        for(int i = 0; i < computerNumbers.size(); i++) {
            if(computerNumbers.get(i) == userNumbers.get(i)) strikeCount++;
        }
        return strikeCount;
    }

    private int getBallCount(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int ballCount = 0;
        for(int i = 0; i < computerNumbers.size(); i++) {
            for(int j = 0; j < userNumbers.size(); j++) {
                if(i == j) continue;
                if(computerNumbers.get(i) == userNumbers.get(j)) ballCount++;
            }
        }
        return ballCount;
    }
}
