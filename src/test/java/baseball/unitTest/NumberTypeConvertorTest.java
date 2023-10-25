package baseball.unitTest;

import baseball.model.convertor.NumberTypeConvertor;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberTypeConvertorTest {

    private NumberTypeConvertor numberTypeConvertor;

    @BeforeEach
    void setUp() {
        numberTypeConvertor = new NumberTypeConvertor();
    }

    @Test
    @DisplayName("문자열 수를 넣고_List 형식이면_통과한다")
    void inputStringNumber_isListType_true() {
        Assertions.assertThat(numberTypeConvertor.toListInteger("123"))
                .isInstanceOf(List.class);
    }
}
