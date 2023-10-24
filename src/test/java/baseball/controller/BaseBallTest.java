package baseball.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseBallTest {
    @Test
    @DisplayName("플레이어 수가 정상적으로 들어옴")
    void 플레이어_수_입력_테스트_참() {
        String validInput = "456";
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(4);
        expected.add(5);
        expected.add(6);
        ArrayList<Integer> result = BaseBall.getPlayerInputNumber(validInput);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("플레어 수가 비정상적으로 들어옴")
    void 플레이어_수_입력_테스트_거짓() {
        String invalidInput = "4567";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> BaseBall.getPlayerInputNumber(invalidInput))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
