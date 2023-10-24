package baseball.validate;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumbersValidateTest {
    List<Integer> computersRandomNumbers;
    @BeforeEach
    void setUp(){
        computersRandomNumbers = Arrays.asList(1,2,3);
    }
    @Test
    @DisplayName("3 자리의 숫자 인지 확인한다. 숫자가 3개인 경우")
    public void numbersSizeTest() {
        assertThat(NumbersValidate.isCorrectSize(computersRandomNumbers)).isTrue();
    }
    @Test
    @DisplayName("3 자리의 숫자 인지 확인한다. 숫자가 1개인 경우")
    public void numbersSizeTestError() {
        computersRandomNumbers = List.of(1);
        assertThat(NumbersValidate.isCorrectSize(computersRandomNumbers)).isFalse();
    }
    @Test
    @DisplayName("중복을 확인한다")
    public void pick3AllDifferentNumberTest() {
        assertThat(NumbersValidate.isNumberNotDuplicate(computersRandomNumbers)).isTrue();

    }
    @Test
    @DisplayName("숫자의 한 자리수의 범위가 1~9 인지 확인한다.")
    public void pick3NumberRangeTest() {
        assertThat(NumbersValidate.isNumberInRange(computersRandomNumbers)).isTrue();
    }
}
