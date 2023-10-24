package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.GameStatus;
import java.util.stream.Stream;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@TestInstance(Lifecycle.PER_CLASS)
public class GameStatusTest {

    public Stream<Arguments> isPlaying() {
        return Stream.of(
            Arguments.of(GameStatus.PLAYING, true),
            Arguments.of(GameStatus.WIN, false)
        );
    }

    @ParameterizedTest
    @MethodSource("isPlaying")
    void isPlayingTest(GameStatus gameStatus, boolean isPlaying) {
        assertThat(gameStatus.isPlaying()).isEqualTo(isPlaying);
    }
}
