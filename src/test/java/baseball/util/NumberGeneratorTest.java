package baseball.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberGeneratorTest {

    @Test
    void 올바른_번호생성() {
        //given
        NumberGenerator numberGenerator = new NumberGenerator();

        //when
        for (int i = 0; i < 1000; i++) {
            List<Integer> generatedNumber = numberGenerator.generate();
            Set<Integer> numberSet = new HashSet<>(generatedNumber);
            //then
            Assertions.assertEquals(generatedNumber.size(), numberSet.size());
        }
    }

    @Test
    void 번호생성시_항상_새로운_번호생성() {
        //given
        NumberGenerator numberGenerator = new NumberGenerator();
        List<Integer> generatedNumber1 = numberGenerator.generate();
        List<Integer> generatedNumber2 = numberGenerator.generate();
        //then
        Assertions.assertNotEquals(generatedNumber1, generatedNumber2);
    }

}
