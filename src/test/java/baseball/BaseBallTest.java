package baseball;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import baseball.domain.answer.Answer;
import baseball.domain.number.Number;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BaseBallTest {
    @Test
    @DisplayName("서로 다른 세자리의 수를 생성한다.")
    void createAnswer() {
        Answer answer = new Answer();
        List<Integer> numberList = answer.toIntList();
        assertThat(numberList.stream().distinct().count() == numberList.size());
    }

    @ParameterizedTest
    @ValueSource(strings = {"356", "452", "198"})
    @DisplayName("1~9 까지의 각각 다른 세자리 수를 입력받았을 경우 성공")
    void numberValidSuccess(String argument) {
        assertDoesNotThrow(() -> new Number(argument));
    }

    @ParameterizedTest
    @ValueSource(strings = {"000", "141", "224"})
    @DisplayName("입력받은 값이 서로 같을경우 에러반환")
    void ifDuplicateReturnNumberValidFail(String argument) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Number(argument));
        assertThat(e.getMessage()).isEqualTo("서로 다른 세자리 수를 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"ㄹㅈㅅ", "우테코"})
    @DisplayName("입력받은 값이 숫자가 아닐 경우 에러반환")
    void ifMissRangeReturnNumberValidFail(String argument) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Number(argument));
        assertThat(e.getMessage()).isEqualTo("숫자만 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"3", "45", ""})
    @DisplayName("입력받은 값이 세자리 이하 이거나 공백일 경우 에러반환")
    void ifNullOrMissLengthReturnNumberValidFail(String argument) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Number(argument));
        assertThat(e.getMessage()).isEqualTo("세자리 숫자를 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"3567", "45281", "245738"})
    @DisplayName("입력받은 값이 세자리 이상일 경우 에러반환")
    void ifOverLengthReturnNumberValidFail(String argument) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Number(argument));
        assertThat(e.getMessage()).isEqualTo("세자리 숫자를 입력해주세요.");
    }
}
