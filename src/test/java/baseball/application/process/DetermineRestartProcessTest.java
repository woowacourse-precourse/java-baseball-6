package baseball.application.process;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import baseball.domain.restartflag.RestartFlag;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("DetermineRestartProcessTest")
class DetermineRestartProcessTest extends BaseballProcessTest {

    @Test
    @DisplayName("excute시 재시작여부를 묻는 출력, 입력, 재시작 여부 판단의 행동을 한다.")
    void doPrintInputAndDetermineRestartWhenExecute() {
        // given
        final String ASK_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
        final String input = "1";
        final RestartFlag restartFlag = new RestartFlag(1);

        DetermineRestartProcess determineRestartProcess = new DetermineRestartProcess();

        when(ioContext.readLine()).thenReturn(input);
        when(baseballContext.inputRestartFlag(anyString())).thenReturn(restartFlag);

        // when
        determineRestartProcess.execute(baseballContext, ioContext);

        // then
        verify(ioContext, times(1)).println(ASK_RESTART_MESSAGE);
        verify(ioContext, times(1)).readLine();
        verify(baseballContext, times(1)).inputRestartFlag(anyString());
    }

    @ParameterizedTest(name = "[{index}] : {0}")
    @ValueSource(strings = {"0", "3", "123"})
    @DisplayName("잘못된 값이 입력되었을 때 IllegalArgumentException을 발생한다.")
    void throwsIllegalArgumentExceptionWhenInvalidInput(final String input) {
        // given
        DetermineRestartProcess determineRestartProcess = new DetermineRestartProcess();

        when(ioContext.readLine()).thenReturn(input);
        doThrow(IllegalArgumentException.class).when(baseballContext).inputRestartFlag(anyString());

        // when, then
        assertThrows(IllegalArgumentException.class,
            () -> determineRestartProcess.execute(baseballContext, ioContext));
    }

    @Test
    @DisplayName("hasNext가 true를 반환함")
    void hasNextReturnTrue() {
        // given
        DetermineRestartProcess determineRestartProcess = new DetermineRestartProcess();

        // when
        boolean result = determineRestartProcess.hasNext();

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("입력이 1인 경우 next가 gameInitProcess를 반환한다.")
    void nextReturnGameInitProcessWhenInputIsOne() {
        // given
        final String expected = "gameInitProcess";
        final int input = 1;
        final RestartFlag restartFlag = new RestartFlag(input);

        DetermineRestartProcess determineRestartProcess = new DetermineRestartProcess();

        when(ioContext.readLine()).thenReturn(String.valueOf(input));
        when(baseballContext.inputRestartFlag(anyString())).thenReturn(restartFlag);

        determineRestartProcess.execute(baseballContext, ioContext);

        // when
        String result = determineRestartProcess.next();

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("입력이 2인 경우 next가 applicationEndProcess를 반환한다.")
    void nextReturnApplicationEndProcessWhenInputIsTwo() {
        // given
        final String expected = "applicationEndProcess";
        final int input = 2;
        final RestartFlag restartFlag = new RestartFlag(input);

        DetermineRestartProcess determineRestartProcess = new DetermineRestartProcess();

        when(ioContext.readLine()).thenReturn(String.valueOf(input));
        when(baseballContext.inputRestartFlag(anyString())).thenReturn(restartFlag);

        determineRestartProcess.execute(baseballContext, ioContext);

        // when
        String result = determineRestartProcess.next();

        // then
        assertThat(result).isEqualTo(expected);
    }
}