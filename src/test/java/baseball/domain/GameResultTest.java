package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GameResultTest {
    @DisplayName("스트라이크 개수로 게임 결과를 반환한다")
    @ParameterizedTest
    @CsvSource({"0, CONTINUE", "3, END"})
    void GetGameResultFromStrikeCount(int strikeCount, GameResult expected) {
        GameResult actual = GameResult.from(strikeCount);

        assertThat(actual).isEqualTo(expected);
    }
}
