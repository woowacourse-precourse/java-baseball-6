package baseball.domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import baseball.domain.model.BaseballNumber;
import baseball.domain.util.RandomNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class NumberBaseBallGameTest {

    private static final String GENERATED_NUMBER = "133";

    @Mock
    private RandomNumberGenerator randomNumberGenerator;

    private NumberBaseballScoreEvaluator evaluator;
    private NumberBaseBallGame numberBaseBallGame;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        evaluator = new NumberBaseballScoreEvaluator();
        when(randomNumberGenerator.generateRandomNumbers()).thenReturn(GENERATED_NUMBER);
        numberBaseBallGame = new NumberBaseBallGame(randomNumberGenerator, evaluator);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "456", "789", GENERATED_NUMBER})
    void 입력된_숫자에_따른_게임오버_여부_테스트(String input) {
        BaseballNumber inputNumber = new BaseballNumber(input);
        RoundEvaluationResult result = numberBaseBallGame.evaluateRound(inputNumber);
        assertEquals(GENERATED_NUMBER.equals(input), result.isgameOver());
    }
}
