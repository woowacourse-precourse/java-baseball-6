package baseball.application.process;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("[GameStartProcessTest]")
class GameStartProcessTest extends BaseballProcessTest {

    final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    @Test
    @DisplayName("excute시 시작 메세지가 출력된다.")
    void printStartMessageWhenExecute() {
        // given
        GameStartProcess gameStartProcess = new GameStartProcess();

        // when
        gameStartProcess.execute(baseballContext, ioContext);

        // then
        verify(ioContext, times(1)).println(START_MESSAGE);
    }

    @Test
    @DisplayName("hasNext가 true를 반환한다.")
    void hasNextReturnTrue() {
        // given
        GameStartProcess gameStartProcess = new GameStartProcess();

        // when
        boolean result = gameStartProcess.hasNext();

        // then
        assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("next가 gameInitProcess를 반환한다.")
    void nextReturnGameInitProcess() {
        // given
        GameStartProcess gameStartProcess = new GameStartProcess();
        String expected = "gameInitProcess";

        // when
        String result = gameStartProcess.next();

        // then
        assertThat(result).isEqualTo(expected);
    }
}