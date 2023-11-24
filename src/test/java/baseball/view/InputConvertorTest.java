package baseball.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InputConvertorTest {

    InputConvertor convertor = new InputConvertor();

    @DisplayName("입력 값을 정수 리스트로 변환한다.")
    @Test
    void convertIntegerList() {
        List<Integer> result = convertor.convertIntegerList("123");
        assertThat(result).isEqualTo(List.of(1, 2, 3));
    }
}
