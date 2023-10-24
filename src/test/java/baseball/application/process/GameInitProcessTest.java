package baseball.application.process;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("[GameInitProcessTest]")
class GameInitProcessTest extends BaseballProcessTest {

    @Test
    @DisplayName("excute시 게임이 초기화 된다.")
    void initGameWhenExecute() {
        // given
        GameInitProcess gameInitProcess = new GameInitProcess();

        // when
        gameInitProcess.execute(baseballContext, ioContext);

        // then
        verify(baseballContext, times(1)).init();
    }

    @Test
    @DisplayName("hasNext가 true를 반환한다.")
    void hasNextReturnTrue() {
        // given
        GameInitProcess gameInitProcess = new GameInitProcess();

        // when
        boolean result = gameInitProcess.hasNext();

        // then
        assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("next가 playerInputProcess를 반환한다.")
    void nextReturnPlayerInputProcess() {
        // given
        GameInitProcess gameInitProcess = new GameInitProcess();
        String expected = "playerInputProcess";

        // when
        String result = gameInitProcess.next();

        // then
        assertThat(result).isEqualTo(expected);
    }
}