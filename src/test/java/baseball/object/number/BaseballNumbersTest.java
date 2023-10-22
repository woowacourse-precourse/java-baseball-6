package baseball.object.number;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BaseballNumbersTest {

    @Test
    void 야구숫자_생성시_입력한대로_제대로나와야함() {
        Integer[] expectedNumbers = {1, 2, 3};

        BaseballNumbers baseballNumbers =
                new BaseballNumbers(new OneTwoThreeOrFakeNumberGenerator());

        Assertions.assertThat(baseballNumbers.get()).containsExactly(expectedNumbers);
    }

}