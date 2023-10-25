package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.util.InputConvertor;
import java.util.List;
import org.junit.jupiter.api.Test;

public class InputConvertorTest {

    @Test
    void convertBalls는_문자열을_숫자리스트로_변환한다() {
        List<Integer> list = List.of(1, 2, 3);
        assertEquals(InputConvertor.convertBalls("123"), list);
    }
}
