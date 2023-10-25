package baseball;

import baseball.resource.GameValue;
import baseball.validator.InputValidation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public class GameTest {

    @DisplayName("게임 재시작 질문시 1 또는 2 이외에 값을 입력한 경우 exception 발생")
    @Test
    void 게임_재시작_예외처리_체크() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            InputValidation.reStartCheck("3");;
        });

    }

    @DisplayName("게임 재시작 질문 입력값을 1로 입력할 경우 true 반환")
    @Test
    void 게임_재시작_입력값에_대한_true_반환() {
        Assertions.assertTrue(Objects.equals(Integer.parseInt("1"), GameValue.RESTART_GAME_VALUE));
    }

    @DisplayName("게임 재시작 질문 입력값을 2로 입력할 경우 false 반환")
    @Test
    synchronized void 게임_재시작_입력값에_대한_false_반환() {
        Assertions.assertFalse(Objects.equals(Integer.parseInt("2"), GameValue.RESTART_GAME_VALUE));
    }
}
