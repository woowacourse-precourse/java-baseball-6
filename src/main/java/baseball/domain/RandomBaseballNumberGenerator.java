package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RandomBaseballNumberGenerator {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;

    // 게임 조건의 자릿수에 따른 난수 생성 기능
    public static BaseballNumber generateRandomBaseballNumber(int size){
        Set<Integer> randomBaseballNumbers = new HashSet<>();
        while (randomBaseballNumbers.size() < size){
            randomBaseballNumbers.add(Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE));
        }
        return new BaseballNumber(List.copyOf(randomBaseballNumbers));
    }
}
