package baseball.service;

import baseball.vo.Score;
import java.util.List;
import java.util.stream.IntStream;

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
        return (int) IntStream.range(0, numbers.size())
            .filter(idx -> numbers.get(idx).equals(computerNumbers.get(idx)))
            .count();
    }
}
