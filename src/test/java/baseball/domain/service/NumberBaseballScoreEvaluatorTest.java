package baseball.domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class NumberBaseballScoreEvaluatorTest {

    @ParameterizedTest
    @CsvSource({
            "123, 312, 3볼",
            "123, 123, 3스트라이크",
            "123, 456, 낫싱",
            "123, 134, 1볼 1스트라이크",
    })
    void 숫자_볼_스트라이크_테스트(String target, String input, String expected) {
        NumberBaseballScoreEvaluator evaluator = new NumberBaseballScoreEvaluator();
        assertEquals(expected, evaluator.evaluate(new BaseballScoreCounter(input, target)));
    }
}