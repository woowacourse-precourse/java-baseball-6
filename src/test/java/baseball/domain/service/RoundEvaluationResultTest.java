package baseball.domain.service;

import static org.junit.jupiter.api.Assertions.*;

import baseball.domain.model.GameStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RoundEvaluationResultTest {

    private RoundEvaluationResult result;

    @BeforeEach
    void setUp() {
        result = new RoundEvaluationResult(GameStatus.CONTINUE, "Some Message");
    }

    @ParameterizedTest
    @CsvSource({
            "2, false",
            "1, true"
    })
    void eveluateRestart_게임종료_번호에_따라_게임상태가_올바르게_변경되어야함(String input, boolean expectedIsExit) {
        result.eveluateRestart(input);

        assertEquals(expectedIsExit, !result.isExit());
    }
}
