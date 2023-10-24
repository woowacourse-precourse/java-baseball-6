package baseball.parser;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import baseball.domain.ball.BallNumber;
import baseball.domain.game.GameStatus;
import baseball.validator.InputValidator;
import collection.Triple;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

final class InputParserTest {

    @DisplayName("3개의 숫자로 이루어진 입력은 Triple<BallNumber>로 정상 파싱된다.")
    @Test
    void testParsingBallNumbersInput() {
        // given
        final InputParser inputParser = new InputParser(new InputValidator());

        // when
        final Triple<BallNumber> ballNumbers = inputParser.parseBallNumbersInput("123");

        // then
        assertThat(ballNumbers.first().number()).isEqualTo(1);
        assertThat(ballNumbers.second().number()).isEqualTo(2);
        assertThat(ballNumbers.third().number()).isEqualTo(3);
    }

    @DisplayName("1개의 숫자로 이루어진 입력은 GameStatus로 정상 파싱된다.")
    @Test
    void testParsingGameStatusInput() {
        // given
        final InputParser inputParser = new InputParser(new InputValidator());

        // when
        final GameStatus gameStatus = inputParser.parseGameStatusInput("1");

        // then
        assertThat(gameStatus).isEqualTo(GameStatus.REPLAY);
    }
}