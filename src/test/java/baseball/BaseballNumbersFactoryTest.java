package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class BaseballNumbersFactoryTest extends NsTest {
    @Test
    void getRandomBaseballNumbers_테스트() {
        //given
        //when
        List<BaseballNumber> randomBaseballNumbers = BaseballNumbersFactory.getRandomBaseballNumbers();
        List<Integer> result = new ArrayList<>();
        for (BaseballNumber baseballNumber : randomBaseballNumbers) {
            int baseballNumberValue = BaseballNumber.getBaseballNumberValue(baseballNumber);
            result.add(baseballNumberValue);
        }
        //then
        assertThat(result).doesNotHaveDuplicates().hasSize(3).allMatch(i -> i >= 1 && i <= 9);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
