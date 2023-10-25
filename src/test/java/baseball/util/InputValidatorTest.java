package baseball.util;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    void 입력값의_길이가_3이_아닌_경우_01() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateUserNumber(""));
    }

    @Test
    void 입력값의_길이가_3이_아닌_경우_02() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateUserNumber("1"));
    }

    @Test
    void 입력값의_길이가_3이_아닌_경우_03() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateUserNumber("12"));
    }

    @Test
    void 입력값의_길이가_3이_아닌_경우_04() {
        assertThrows(IllegalArgumentException.class,
            () -> InputValidator.validateUserNumber("1234"));
    }

    @Test
    void 입력값의_길이가_3이_아닌_경우_05() {
        assertThrows(IllegalArgumentException.class,
            () -> InputValidator.validateUserNumber("123456789"));
    }

    @Test
    void 숫자가_아닌_경우_01() {
        assertThrows(IllegalArgumentException.class,
            () -> InputValidator.validateUserNumber("asd"));
    }

    @Test
    void 숫자가_아닌_경우_02() {
        assertThrows(IllegalArgumentException.class,
            () -> InputValidator.validateUserNumber("zx1"));
    }

    @Test
    void 숫자가_아닌_경우_03() {
        assertThrows(IllegalArgumentException.class,
            () -> InputValidator.validateUserNumber("q2e"));
    }

    @Test
    void 숫자가_아닌_경우_04() {
        assertThrows(IllegalArgumentException.class,
            () -> InputValidator.validateUserNumber("1at"));
    }

    @Test
    void 숫자가_아닌_경우_05() {
        assertThrows(IllegalArgumentException.class,
            () -> InputValidator.validateUserNumber("1d2"));
    }

    @Test
    void 수에_0이_포함된_경우_01() {
        assertThrows(IllegalArgumentException.class,
            () -> InputValidator.validateUserNumber("012"));
    }

    @Test
    void 수에_0이_포함된_경우_02() {
        assertThrows(IllegalArgumentException.class,
            () -> InputValidator.validateUserNumber("102"));
    }

    @Test
    void 수에_0이_포함된_경우_03() {
        assertThrows(IllegalArgumentException.class,
            () -> InputValidator.validateUserNumber("120"));
    }

    @Test
    void 중복된_수가_존재하는_경우_01() {
        assertThrows(IllegalArgumentException.class,
            () -> InputValidator.validateUserNumber("112"));
    }

    @Test
    void 중복된_수가_존재하는_경우_02() {
        assertThrows(IllegalArgumentException.class,
            () -> InputValidator.validateUserNumber("121"));
    }

    @Test
    void 중복된_수가_존재하는_경우_03() {
        assertThrows(IllegalArgumentException.class,
            () -> InputValidator.validateUserNumber("211"));
    }

    @Test
    void 중복된_수가_존재하는_경우_04() {
        assertThrows(IllegalArgumentException.class,
            () -> InputValidator.validateUserNumber("111"));
    }

    @Test
    void 게임_재시작_커맨드가_1_혹은_2가_아닌_경우_01() {
        assertThrows(IllegalArgumentException.class,
            () -> InputValidator.validateRestartCommand(""));
    }

    @Test
    void 게임_재시작_커맨드가_1_혹은_2가_아닌_경우_02() {
        assertThrows(IllegalArgumentException.class,
            () -> InputValidator.validateRestartCommand("0"));
    }

    @Test
    void 게임_재시작_커맨드가_1_혹은_2가_아닌_경우_03() {
        assertThrows(IllegalArgumentException.class,
            () -> InputValidator.validateRestartCommand("3"));
    }

    @Test
    void 게임_재시작_커맨드가_1_혹은_2가_아닌_경우_04() {
        assertThrows(IllegalArgumentException.class,
            () -> InputValidator.validateRestartCommand("a"));
    }

    @Test
    void 게임_재시작_커맨드가_1_혹은_2가_아닌_경우_05() {
        assertThrows(IllegalArgumentException.class,
            () -> InputValidator.validateRestartCommand("a1s2d3"));
    }


}