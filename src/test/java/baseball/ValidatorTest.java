package baseball;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ValidatorTest {

    public Validator validator;

    @BeforeEach
    void preSet() {
        validator = new Validator(893);
    }

    @Test
    void _1스트라이크() {
        validator.getBaseballAnswer("857");
        Map<String, Integer> result = validator.checkAnswer();
        assertEquals(1, result.get("스트라이크"));
        assertEquals(0, result.get("볼"));
    }

    @Test
    void _2스트라이크() {
        validator.getBaseballAnswer("853");
        Map<String, Integer> result = validator.checkAnswer();
        assertEquals(2, result.get("스트라이크"));
        assertEquals(0, result.get("볼"));
    }

    @Test
    void _3스트라이크() {
        validator.getBaseballAnswer("893");
        Map<String, Integer> result = validator.checkAnswer();
        assertEquals(3, result.get("스트라이크"));
        assertEquals(0, result.get("볼"));
    }

    @Test
    void _1볼_1스트라이크() {
        validator.getBaseballAnswer("837");
        Map<String, Integer> result = validator.checkAnswer();
        assertEquals(1, result.get("스트라이크"));
        assertEquals(1, result.get("볼"));
    }

    @Test
    void _2볼_1스트라이크() {
        validator.getBaseballAnswer("839");
        Map<String, Integer> result = validator.checkAnswer();
        assertEquals(1, result.get("스트라이크"));
        assertEquals(2, result.get("볼"));
    }

    @Test
    void 낫싱() {
        validator.getBaseballAnswer("127");
        Map<String, Integer> result = validator.checkAnswer();
        assertEquals(0, result.get("스트라이크"));
        assertEquals(0, result.get("볼"));
    }

    @ParameterizedTest
    @CsvSource(value = {
        "'123 ', 공백을 제거하고 입력해주세요.",
        "ㄱ12, 숫자만 입력해주세요.",
        "58, 3개의 숫자로 입력해주세요.",
        "5894, 3개의 숫자로 입력해주세요.",
        "224, 서로 다른 3개의 숫자로 입력해주세요.",
        "777, 서로 다른 3개의 숫자로 입력해주세요.",
        "103, 1과 9 사이의 숫자만 입력해주세요.",
        "530, 1과 9 사이의 숫자만 입력해주세요."
    })
    void 숫자야구_입력_예외_테스트(String input, String expectedMessage) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
            () -> validator.getBaseballAnswer(input));
        assertEquals(e.getMessage(), expectedMessage);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "3, 1과 2 중 하나만 선택해주세요.",
        "'1 ', 공백을 제거하고 입력해주세요.",
        "ㄱ, 숫자만 입력해주세요."
    })
    void 게임진행여부_입력_예외_테스트(String input, String expectedMessage) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
            () -> validator.getProgressAnswer(input));
        assertEquals(e.getMessage(), expectedMessage);
    }

}