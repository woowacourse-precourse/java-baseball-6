package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import baseball.model.BaseballNumber;
import baseball.model.BaseballNumbersFactory;
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

    @Test
    void getBaseballNumbers_테스트() {
        //given
        String baseballNumbersString = "123";
        //when
        List<BaseballNumber> baseballNumbers = BaseballNumbersFactory.getBaseballNumbers(baseballNumbersString);
        List<Integer> result = new ArrayList<>();
        for (BaseballNumber baseballNumber : baseballNumbers) {
            int baseballNumberValue = BaseballNumber.getBaseballNumberValue(baseballNumber);
            result.add(baseballNumberValue);
        }
        //then
        assertThat(result).containsExactly(1, 2, 3);
    }

    @Test
    void getBaseballNumbers_예외처리_테스트() {
        //given
        String baseballNumbersString = "12a";
        //when
        Throwable thrown = catchThrowable(() -> BaseballNumbersFactory.getBaseballNumbers(baseballNumbersString));
        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("[ERROR]");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
