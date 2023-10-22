package baseball.core;

import baseball.dto.GameResult;

import java.util.List;

public class Referee {
    public GameResult judge(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int strikeCount = 0;
        for(int i = 0; i < computerNumbers.size(); i++) {
            if(computerNumbers.get(i) == userNumbers.get(i)) strikeCount++;
        }

        int ballCount = 0;
        for(int i = 0; i < computerNumbers.size(); i++) {
            for(int j = 0; j < userNumbers.size(); j++) {
                if(i == j) continue;
                if(computerNumbers.get(i) == userNumbers.get(j)) ballCount++;
            }
        }

        return new GameResult(ballCount, strikeCount);
    }
}
