package baseball.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 게임 점수를 계산할 때 사용합니다.
 * */
public class Score {


    public int[] getResultScore(List<Integer> userNumbers,
                                List<Integer> computerNumbers){
        int strikeCnt = strikeCounter(userNumbers, computerNumbers);
        int ballCnt = ballCounter(userNumbers, computerNumbers);

        return new int[]{strikeCnt, ballCnt};
    }


    private int strikeCounter(List<Integer> userNumbers,
                              List<Integer> computerNumbers) {

        return (int) IntStream.range(0,3)
                .filter(i ->userNumbers.get(i).equals(computerNumbers.get(i))).count();
    }

    private int ballCounter(List<Integer> userNumbers,
                            List<Integer> computerNumbers) {

        return (int) IntStream.range(0,3)
                .filter(i -> !(userNumbers.get(i).equals(computerNumbers.get(i)))
                        && computerNumbers.contains(userNumbers.get(i)))
                .count();
    }


}
