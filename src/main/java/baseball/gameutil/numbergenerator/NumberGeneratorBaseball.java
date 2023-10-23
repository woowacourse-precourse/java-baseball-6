package baseball.gameutil.numbergenerator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class NumberGeneratorBaseball implements NumberGenerator {

    @Override
    public List<Integer> generate(
        int start,
        int end,
        int count
    ) {
        List<Integer> ret = new ArrayList<>();
        while(ret.size() < count){
            addUniqueNumbers(ret, start, end);
        }
        return ret;
    }

    private void addUniqueNumbers(
        List<Integer> ret,
        int start,
        int end
    ) {
        Integer digit = Randoms.pickNumberInRange(start, end);
        if (!ret.contains(digit)) {
            ret.add(digit);
        }
    }
}
