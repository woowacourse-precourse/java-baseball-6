package baseball;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ValidatorTest {

    final Validator validator = new Validator();

    @Test
    void 범위_안에_있는_수가_맞는지_1_to_9() {

        // 1과 9 사이의 숫자여야 함
        List<String> input = Arrays.asList("123", "120", "1,2", "! 2", "\n");
        List<Boolean> result = Arrays.asList(true, false, false, false, false);

        for (int index = 0; index < input.size(); index++) {
            assertThat(validator.ensureRange(input.get(index), Constants.MIN_RANGE_NUM,
                Constants.MAX_RANGE_NUM)).isEqualTo(result.get(index));
        }
    }

    @Test
    void 범위_안에_있는_수가_맞는지_1_to_2() {

        // 1 또는 2여야 함 = 1과 2 사이에 있어야 함
        List<String> input = Arrays.asList("1", "2", " ", "\n", "3", "!!");
        List<Boolean> result = Arrays.asList(true, true, false, false, false, false);

        for (int index = 0; index < input.size(); index++) {
            assertThat(validator.ensureRange(input.get(index), Constants.RESTART,
                Constants.QUIT)).isEqualTo(result.get(index));
        }
    }

    @Test
    void 중복된_수가_있는지() {

        List<String> input = Arrays.asList("112", "456");
        List<Boolean> result = Arrays.asList(true, false);

        for (int index = 0; index < input.size(); index++) {
            assertThat(validator.existsDuplicateNumber(input.get(index))).isEqualTo(
                result.get(index));
        }
    }

    @Test
    void 예외_처리_확인_야구_숫자() {

        List<String> input = Arrays.asList("0", "\n", "45 ", "998", "   ");

        for (String user : input) {
            assertThatIllegalArgumentException().isThrownBy(
                () -> validator.validateUserInputNumber(user));
        }
    }

    @Test
    void 예외_처리_확인_재시작_종료() {

        List<String> input = Arrays.asList("\n", "3", " ", "00");

        for (String user : input) {
            assertThatIllegalArgumentException().isThrownBy(
                () -> validator.validateRestartOrQuit(user));
        }
    }

}
