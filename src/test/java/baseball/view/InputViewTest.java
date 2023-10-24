package baseball.view;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    @Test
    void 생성_확인() {
        String input = "123";
        Integer[] result = InputView.convertStrToIntArr(input);
        Integer[] expect = {1, 2, 3};

        assertArrayEquals(expect, result);
    }

}