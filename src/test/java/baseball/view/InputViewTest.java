package baseball.view;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    @Test
    void 정수_배열_반환_테스트() {
        Integer[] expect = {1, 2, 3};
        Integer[] result = InputView.convertStrToIntArr("123");
        Assertions.assertArrayEquals(expect, result);
    }

}