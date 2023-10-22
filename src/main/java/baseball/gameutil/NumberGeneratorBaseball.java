package baseball.gameutil;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class NumberGeneratorBaseball implements NumberGenerator {

    @Override
    public List<Integer> generate(
        Integer start,
        Integer end,
        Integer count
    ) {
        List<Integer> ret = new ArrayList<>();
        while(ret.size() < count){
            addUniqueNumbers(ret, start, end);
        }
        return ret;
    }

    private void addUniqueNumbers(
        List<Integer> ret,
        Integer start,
        Integer end
    ) {
        Integer digit = Randoms.pickNumberInRange(start, end);
        if (!ret.contains(digit)) {
            ret.add(digit);
        }
    }
}
