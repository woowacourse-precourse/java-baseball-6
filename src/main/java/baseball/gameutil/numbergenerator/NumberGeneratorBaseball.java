package baseball.gameutil.numbergenerator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 이 클래스는 야구 게임에 사용되는 NumberGenerator를 구현하는 클래스다.
 */
public class NumberGeneratorBaseball implements NumberGenerator {

    /**
     * 이 메서드는 start와 end 사이의 숫자 중 count개의 숫자를 랜덤하게 생성하여 반환한다.
     * @param start 생성할 숫자의 최소값
     * @param end 생성할 숫자의 최대값
     * @param count 생성할 숫자의 개수
     * @return 생성된 숫자들의 리스트
     */
    @Override
    public List<Integer> generate(
        int start,
        int end,
        int count
    ) {
        Set<Integer> ret = new HashSet<>();
        while(ret.size() < count){
            ret.add(Randoms.pickNumberInRange(start, end));
        }
        return new ArrayList<>(ret);
    }
}
