package baseball.gameutil;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberGeneratorBaseballTest {

    /*
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
    * */

    @Test
    void 랜덤_숫자_생성() {
        //given
        Integer start = 1;
        Integer end = 5;
        Integer count = 3;
        NumberGenerator numberGenerator = new NumberGeneratorBaseball();
        //when
        List<Integer> test = numberGenerator.generate(
            start,
            end,
            count
        );

        //then
        Assertions.assertEquals(count, test.size());
        Assertions.assertTrue(test.stream().allMatch(num -> start <= num && num <= end));
        Assertions.assertEquals(test.stream().distinct().toList().size(), test.size());
    }

}
