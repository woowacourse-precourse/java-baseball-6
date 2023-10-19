package baseball.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class ToListTest {

    @Test
    void 숫자문자열을_숫자리스트로변환() {
        String s = "123";
        List<Integer> numberList = ToList.toIntegerList(s);
        assertEquals(1, numberList.get(0));
        assertEquals(2, numberList.get(1));
        assertEquals(3, numberList.get(2));
    }

}