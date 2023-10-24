package baseball.application.process;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("[PlayerInputProcessTest]")
class PlayerInputProcessTest extends BaseballProcessTest {

    @Test
    @DisplayName("excute시 사용자 입력 메세지 출력, 입력, 숫자 교체 의 행동을 한다. ")
    void doPrintInputAndCompareWhenExecute() {
        // given
        final String PLAYER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
        PlayerInputProcess playerInputProcess = new PlayerInputProcess();

        // when
        playerInputProcess.execute(baseballContext, ioContext);

        // then
        verify(ioContext, times(1)).print(PLAYER_INPUT_MESSAGE);
        verify(ioContext, times(1)).readLine();
        verify(baseballContext, times(1)).changePlayerNumber(null);
    }

    @ParameterizedTest(name = "[{index}] : {0}")
    @ValueSource(strings = {"24", "012", "1234", "1133", "asd"})
    @DisplayName("입력값으로 잘못 된 값이 들어가면 IllegalArgumentException을 발생한다.")
    void throwIllegalArgumentExceptionWhenInputInvalidValues(final String input) {
        // given
        PlayerInputProcess playerInputProcess = new PlayerInputProcess();

        when(ioContext.readLine()).thenReturn(input);
        doThrow(new IllegalArgumentException()).when(baseballContext)
            .changePlayerNumber(anyString());

        // when, then
        assertThrows(IllegalArgumentException.class,
            () -> playerInputProcess.execute(baseballContext, ioContext));
    }

    @Test
    @DisplayName("hasNext가 true를 반환한다.")
    void hasNextReturnTrue() {
        // given
        PlayerInputProcess playerInputProcess = new PlayerInputProcess();

        // when
        boolean result = playerInputProcess.hasNext();

        // then
        assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("next가 gameProgressProcess를 반환한다.")
    void nextReturnGameInitProcess() {
        // given
        PlayerInputProcess playerInputProcess = new PlayerInputProcess();
        String expected = "gameProgressProcess";

        // when
        String result = playerInputProcess.next();

        // then
        assertThat(result).isEqualTo(expected);
    }
}