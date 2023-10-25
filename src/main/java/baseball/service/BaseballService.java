package baseball.service;

import baseball.vo.Score;
import java.util.List;

public class BaseballService {

    public Score calculateGameScore(String number, List<Integer> computerNumbers) {
        List<Integer> numbers = convertToList(number);

        int ballCnt = calculateBallCnt(computerNumbers, numbers);
        int strikeCnt = calculateStrikeCnt(computerNumbers, numbers);

        Score score = new Score(ballCnt);
        score.increaseStrike(strikeCnt);

        return score;
    }

    private List<Integer> convertToList(String number) {
        return number.chars()
            .mapToObj(Character::getNumericValue)
            .toList();
    }

    private int calculateBallCnt(List<Integer> computerNumbers, List<Integer> numbers) {
        return (int) numbers.stream()
            .filter(computerNumbers::contains)
            .count();
    }

    private int calculateStrikeCnt(List<Integer> computerNumbers, List<Integer> numbers) {
        int strikeCnt = 0;
        for (int idx = 0; idx < numbers.size(); idx++) {
            int target = numbers.get(idx);
            if (idx == computerNumbers.indexOf(target)) {
                strikeCnt++;
            }
        }
        return strikeCnt;
    }
}
