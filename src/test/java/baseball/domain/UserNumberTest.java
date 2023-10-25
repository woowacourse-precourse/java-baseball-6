package baseball.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

class UserNumberTest {

    @Test
    void 입력_값_정상_작동_테스트() {
        String input = "124";
        List<Integer> userNumbsList = List.of(1, 2, 4);
        List<Integer> userNumbs = new UserNumber(input).getUserNumber();

        assertEquals(userNumbsList, userNumbs);
    }

    @Test
    void 숫자_조건_범위_예외_테스트() {
        String input = "023";
        assertThrows(IllegalArgumentException.class, () -> {
            new UserNumber(input);
        });
    }

    @Test
    void 숫자_외_문자_예외_테스트() {
        String input = "1~4";
        assertThrows(IllegalArgumentException.class, () -> {
            new UserNumber(input);
        });
    }

    @Test
    void 입력_값_길이_초과_예외_테스트() {
        String input = "1234";
        assertThrows(IllegalArgumentException.class, () -> {
            new UserNumber(input);
        });
    }

    @Test
    void 숫자_중복_예외_테스트() {
        String input = "144";
        assertThrows(IllegalArgumentException.class, () -> {
            new UserNumber(input);
        });
    }
}
