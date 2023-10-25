package baseball.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class NumberBaseballTest {

    @Test
    void createBaseball_stringValue() {
        String stringValue = "123";

        NumberBaseball baseball = NumberBaseball.createBaseball(stringValue);

        assertNotNull(baseball);
        assertEquals(3, baseball.getValueSize());
    }

    @Test
    void createBaseball_Invalid_stringValue() {
        assertThrows(IllegalArgumentException.class, () -> NumberBaseball.createBaseball("112"));
        assertThrows(IllegalArgumentException.class, () -> NumberBaseball.createBaseball("1234"));
        assertThrows(IllegalArgumentException.class, () -> NumberBaseball.createBaseball("abc"));
        assertThrows(IllegalArgumentException.class, () -> NumberBaseball.createBaseball("0"));
    }

    @Test
    void createBaseball_ListValues() {
        List<Integer> values = new ArrayList<>() {{
            add(1);
            add(2);
            add(3);
        }};

        NumberBaseball baseball = NumberBaseball.createBaseball(values);

        assertNotNull(baseball);
        assertEquals(3, baseball.getValueSize());
    }

    @Test
    void createRandomBaseball() {
        NumberBaseball baseball = NumberBaseball.createRandomBaseball();

        assertNotNull(baseball);
        assertEquals(3, baseball.getValueSize());
    }

    @Test
    void getValues() {
        NumberBaseball baseball = NumberBaseball.createBaseball("123");

        List<Integer> values = baseball.getValues();

        assertNotNull(values);
        assertEquals(3, values.size());
        assertEquals(1, values.get(0));
        assertEquals(2, values.get(1));
        assertEquals(3, values.get(2));
    }

    @Test
    void getSize() {
        NumberBaseball baseball = NumberBaseball.createBaseball("123");

        int size = baseball.getValueSize();

        assertEquals(3, size);
    }


}
