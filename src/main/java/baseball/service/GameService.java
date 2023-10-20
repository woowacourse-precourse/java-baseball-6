package baseball.service;

import java.util.List;

import baseball.domain.GameInfo;

import camp.nextstep.edu.missionutils.Randoms;

/**
 * 야구 게임의 비즈니스 로직을 처리하는 서비스
 */
public class GameService {

    public List<Integer> generateRandomDistinctThreeDigit() {
        return Randoms.pickUniqueNumbersInRange(1, 9, 3);
    }

    public void countStrikeOrBall(GameInfo gameInfo, String userInput) {
        int ballCount = 0;
        int strikeCount = 0;
        List<Integer> randomNumbers = gameInfo.getRandomNumbers();
        List<Integer> integers = userInput.chars()
                .mapToObj(Character::getNumericValue)
                .toList();
        for (int i = 0; i < randomNumbers.size(); i++) {
            for (int j = 0; j < integers.size(); j++) {
                if (i == j && randomNumbers.get(i).equals(integers.get(j))) {
                    strikeCount++;
                }
                if (i != j && randomNumbers.get(i).equals(integers.get(j))) {
                    ballCount++;
                }
            }
        }
        gameInfo.updateBall(ballCount);
        gameInfo.updateStrike(strikeCount);
    }
}
