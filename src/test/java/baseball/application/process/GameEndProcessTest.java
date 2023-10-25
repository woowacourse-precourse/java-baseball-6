package baseball.application.process;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("[GameEndProcessTest]")
class GameEndProcessTest extends BaseballProcessTest {

    @Test
    @DisplayName("excute시 정답을 알리는 문구를 출력한다.")
    void printAnswerMessageWhenExecute() {
        // given
        final String ANSWER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        GameEndProcess gameEndProcess = new GameEndProcess();

        // when
        gameEndProcess.execute(baseballContext, ioContext);

        // then
        verify(ioContext, times(1)).println(ANSWER_MESSAGE);
    }

    @Test
    @DisplayName("hasNext가 true를 반환한다.")
    void hasNextReturnTrue() {
        // given
        GameEndProcess gameEndProcess = new GameEndProcess();

        // when
        boolean result = gameEndProcess.hasNext();

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("next가 determineRestartProcess를 반환한다.")
    void nextReturnDetermineRestartProcess() {
        // given
        GameEndProcess gameEndProcess = new GameEndProcess();
        String expected = "determineRestartProcess";

        // when
        String result = gameEndProcess.next();

        // then
        assertThat(result).isEqualTo(expected);
    }
}