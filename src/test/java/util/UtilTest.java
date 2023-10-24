package util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.util.Util;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UtilTest {

    @Test
    @DisplayName("사용자 입력값을 List<Integer>로 변환해 반환한다.")
    void toIntegerArray() {
        String input = "123";
        List<Integer> expect = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            expect.add(i);
        }
        assertEquals(expect, Util.toIntegerArray(input));
    }
}
