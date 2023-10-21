package baseball.constant;

import static baseball.constant.ExceptionMessage.LENGTH;
import static baseball.constant.ExceptionMessage.TYPE;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ExceptionMessageTest {

    @Test
    void 메세지_내용_일치() {
        // given
        String length = "입력한 수의 길이가 길거나 짧습니다.";
        String type = "잘못된 입력 형식입니다.";

        // then
        assertAll(
                () -> assertEquals(LENGTH.getValue(), length),
                () -> assertEquals(TYPE.getValue(), type)
        );
    }
}
