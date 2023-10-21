package baseball;

import baseball.Controller.Validator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidatorTest {
    Validator validator = new Validator();

    @Test
    void 사용자_입력_검증_3개초과() {
        String playerInput1 = "1234";
        assertThrows(IllegalArgumentException.class, () ->
            validator.validatePlayerInput(playerInput1));
    }
    @Test
    void 사용자_입력_검증_숫자외() {
        String playerInput2 = "12a";
        assertThrows(IllegalArgumentException.class, () ->
            validator.validatePlayerInput(playerInput2));
    }
    @Test
    void 사용자_입력_검증_중복() {
        String playerInput3 = "112";
        assertThrows(IllegalArgumentException.class, () ->
            validator.validatePlayerInput(playerInput3));
    }
    @Test
    void 사용자_입력_검증_공백() {
        String playerInput4 = "12 3";
        assertDoesNotThrow(() ->
            validator.validatePlayerInput(playerInput4));
    }
    @Test
    void 사용자_입력_검증_정답() {
        String playerInput5 = "125";
        assertDoesNotThrow(() ->
            validator.validatePlayerInput(playerInput5));
    }

    @Test
    void 종료_입력_검증_문자() {
        String endInput1 = "a";
        assertThrows(IllegalArgumentException.class, () ->
            validator.validateGameEndInput(endInput1));
    }
    @Test
    void 종료_입력_검증_1과2외() {
        String endInput2 = "12";
        assertThrows(IllegalArgumentException.class, () ->
            validator.validateGameEndInput(endInput2));
    }
    @Test
    void 종료_입력_검증_1과2외_2() {
        String endInput3 = "3";
        assertThrows(IllegalArgumentException.class, () ->
            validator.validateGameEndInput(endInput3));
    }
    @Test
    void 종료_입력_검증_정답() {
        String endInput4 = "1";
        assertDoesNotThrow(() ->
            validator.validateGameEndInput(endInput4));
    }
    @Test
    void 종료_입력_검증_정답2() {
        String endInput5 = "2";
        assertDoesNotThrow(() ->
            validator.validateGameEndInput(endInput5));
    }
}
