package baseball.gameutil.numbergenerator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberGeneratorBaseball implements NumberGenerator {

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
