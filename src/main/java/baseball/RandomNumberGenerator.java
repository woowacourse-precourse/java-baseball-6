package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.stream.IntStream;

public class RandomNumberGenerator {

    private int[] computerAnswer;

    //서로 다른 3자리의 수(답)를 생성하는 메서드
    public int[] makeComputerAnswer() {
        computerAnswer = IntStream.generate(() -> Randoms.pickNumberInRange(1, 9))
                .distinct()
                .limit(3)
                .toArray();
        return computerAnswer;
    }
}
