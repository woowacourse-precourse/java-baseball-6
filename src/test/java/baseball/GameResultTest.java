package baseball;

import static baseball.domain.TryResult.BALL;
import static baseball.domain.TryResult.NOTHING;
import static baseball.domain.TryResult.STRIKE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import baseball.domain.GameResult;
import baseball.domain.TryResult;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GameResultTest {

    @Test
    void from은_시도결과_리스트를받아_게임결과_객체를_반환한다() {
        List<TryResult> tryResults = List.of(STRIKE, BALL, NOTHING);
        GameResult gameResult = GameResult.from(tryResults);
        assertEquals(gameResult.getTryResults(), tryResults);
    }

    @Test
    void isThreeStrike는_시도결과_리스트에_담겨있는게_다스트라이크면_true를_반환한다() {
        List<TryResult> tryResults = List.of(STRIKE, STRIKE, STRIKE);
        GameResult gameResult = GameResult.from(tryResults);
        assertTrue(gameResult.isAllStrike());
    }

    @Test
    void isThreeStrike는_시도결과_리스트에_담겨있는것중_스트라이크가_아닌게있으면_false를_반환한다() {
        List<TryResult> tryResults = List.of(STRIKE, BALL, NOTHING);
        GameResult gameResult = GameResult.from(tryResults);
        assertFalse(gameResult.isAllStrike());
    }

    @ParameterizedTest
    @CsvSource(value = {"STRIKE, NOTHING,NOTHING, false", "NOTHING, NOTHING,NOTHING, true"})
    void isNothing은_nothing이_아닌게_담겨있는지에_따라_결과를_반환한다(TryResult tryResult1, TryResult tryResult2,
        TryResult tryResult3, boolean isNothing) {
        List<TryResult> tryResults = List.of(tryResult1, tryResult2, tryResult3);
        GameResult gameResult = GameResult.from(tryResults);
        assertThat(gameResult.isNothing()).isEqualTo(isNothing);
    }

    @ParameterizedTest
    @CsvSource(value = {"STRIKE,2", "BALL, 1"})
    void getCount는_시도결과별_갯수를_반환한다(TryResult tryResult, int count) {
        List<TryResult> tryResults = List.of(STRIKE, STRIKE, BALL);
        GameResult gameResult = GameResult.from(tryResults);
        assertEquals(gameResult.getCount(tryResult), count);
    }
}
