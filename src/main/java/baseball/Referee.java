package baseball;

import static baseball.NumberBaseballGameConfig.BASEBALL_NUMBER_LENGTH;

import java.util.List;
import java.util.stream.IntStream;


public class Referee {

    // ballCount 와 StrikeCount 계산 및 반환 (Score)
    public Score judge(List<Integer> userInput, List<Integer> answer) {

        int sameCount = countSameNumber(userInput, answer);
        int strikeCount = countStrike(userInput, answer);
        int ballCount = sameCount - strikeCount;
        return new Score(ballCount, strikeCount);
    }

    // 순서 상관 없이 같은 숫자가 몇개 있는지 계산 (Strike 포함)
    private int countSameNumber(List<Integer> userInput, List<Integer> answer) {
        return (int) userInput.stream()
                .filter(num -> answer.contains(num))
                .count();
    }

    // 순서 고려, Strike 개수 계산
    private int countStrike(List<Integer> userInput, List<Integer> answer) {
        return (int) IntStream.range(0, BASEBALL_NUMBER_LENGTH)
                .filter(i -> answer.get(i).equals(userInput.get(i)))
                .count();
    }

}
