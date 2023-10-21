package baseball.generator;

import baseball.dto.GameResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GameResultMessageGeneratorTest {

    @DisplayName("게임 결과에 따른 메시지를 출력할 수 있다.")
    @ParameterizedTest
    @CsvSource(textBlock = """
                2스트라이크, 2, 0
                2볼, 0, 2
                1볼 1스트라이크, 1, 1
                낫싱, 0, 0
            """)
    void createGameResultMessage(String resultMessage, int strikeCount, int ballCount) {
        // given
        GameResult gameResult = new GameResult(strikeCount, ballCount);

        // when
        String gameResultMessage = GameResultMessageGenerator.createGameResultMessage(gameResult);

        // then
        Assertions.assertThat(gameResultMessage).isEqualTo(resultMessage);
    }
}