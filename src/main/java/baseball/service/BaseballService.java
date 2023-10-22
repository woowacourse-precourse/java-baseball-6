package baseball.service;

import baseball.vo.Score;
import java.util.List;

public class BaseballService {

    public Score calculateGameScore(String number, List<Integer> computerNumbers) {
        List<Integer> numbers = number.chars()
            .map(c -> c - '0')
            .boxed()
            .toList();

        int ballCnt = (int) numbers.stream()
            .filter(computerNumbers::contains)
            .count();

        Score score = new Score(ballCnt);

        int strikeCnt = 0;
        for (int idx = 0; idx < numbers.size(); idx++) {
            int target = numbers.get(idx);
            if (idx == computerNumbers.indexOf(target)) {
                strikeCnt++;
            }
        }
        score.increaseStrike(strikeCnt);
        return score;
    }
}
