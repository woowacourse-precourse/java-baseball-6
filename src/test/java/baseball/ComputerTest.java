package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ComputerTest {

    Computer computer = new Computer();

    @DisplayName("컴퓨터 숫자와 사용자의 숫자를 비교하여 결과를 생성할 수 있습니다.")
    @Test
    void createResult_after_generateNumber() {
        // given
        Function<Integer, List<Integer>> dummyGenerator = (Integer dummyNumber) -> List.of(1, 2, 3);
        computer.generateNumber(dummyGenerator);

        // when
        computer.addUserNumber("321");
        GameResult result = computer.createResult();

        // then
        assertAll(
                () -> assertThat(result.getStrike()).isEqualTo(1),
                () -> assertThat(result.getBall()).isEqualTo(2)
        );
    }

    @DisplayName("사용자는 숫자를 입력할 수 있습니다.")
    @Test
    void addUserNumber() {
        // given
        String userNumber = "123";

        // when
        Throwable throwable = catchThrowable(() -> computer.addUserNumber(userNumber));

        // then
        assertThat(throwable).doesNotThrowAnyException();
    }

    @DisplayName("사용자는 숫자가 아닌 수를 입력할 수 없습니다.")
    @ParameterizedTest
    @ValueSource(strings = {"12a", "12e", "aaa", "zzz"})
    void addUserNumber_exception_numberFormat(String invalidUserNumber) {

        // given & when & then
        assertThatIllegalArgumentException().isThrownBy(() -> computer.addUserNumber(invalidUserNumber))
                .withMessageContaining("숫자만 입력해야 합니다.");
    }

    @DisplayName("사용자는 3개의 숫자만 입력할 수 없습니다.")
    @ParameterizedTest
    @ValueSource(strings = {"1234", "12345", "12", "1"})
    void addUserNumber_exception_outOfLengthNumber(String invalidUserNumber) {

        // given & when & then
        assertThatIllegalArgumentException().isThrownBy(() -> computer.addUserNumber(invalidUserNumber))
                .withMessageContaining("3개의 숫자를 입력해야 합니다.");
    }

    @DisplayName("사용자는 같은 숫자를 입력할 수 없습니다.")
    @ParameterizedTest
    @ValueSource(strings = {"112", "121", "232", "333"})
    void addUserNumber_exception_duplicateNumber(String invalidUserNumber) {

        // given & when & then
        assertThatIllegalArgumentException().isThrownBy(() -> computer.addUserNumber(invalidUserNumber))
                .withMessageContaining("중복된 숫자를 입력할 수 없습니다.");
    }

    @DisplayName("사용자는 0을 입력할 수 없습니다.")
    @ParameterizedTest
    @ValueSource(strings = {"120", "012", "890", "150"})
    void addUserNumber_exception_inputZero(String invalidUserNumber) {

        // given & when & then
        assertThatIllegalArgumentException().isThrownBy(() -> computer.addUserNumber(invalidUserNumber))
                .withMessageContaining("숫자는 1~9 사이의 숫자만 입력할 수 있습니다.");
    }
}