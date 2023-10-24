package baseball.application.process;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import baseball.domain.compararesult.CompareResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("GameProgressProcessTest")
class GameProgressProcessTest extends BaseballProcessTest {

    @Test
    @DisplayName("execute시 컴퓨터와 사용자의 숫자를 비교하고 결과를 출력한다.")
    void compareNumbersAndPrintResultWhenExecute() {
        // given
        GameProgressProcess gameProgressProcess = new GameProgressProcess();
        CompareResult compareResult = new CompareResult();

        when(baseballContext.compareNumbers()).thenReturn(compareResult);

        // when
        gameProgressProcess.execute(baseballContext, ioContext);

        // then
        verify(baseballContext, times(1)).compareNumbers();
        verify(ioContext, times(1)).println(compareResult.toString());
    }

    @Test
    @DisplayName("hasNext가 true를 반환한다.")
    void hasNextReturnTrue() {
        // given
        GameProgressProcess gameProgressProcess = new GameProgressProcess();

        // when
        boolean result = gameProgressProcess.hasNext();

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("정답을 맞췄을 시 next가 gameEndProcess를 반환한다.")
    void nextReturnGameEndProcessWhenAnswer() {
        // given
        GameProgressProcess gameProgressProcess = new GameProgressProcess();
        CompareResult compareResult = new CompareResult();
        for (int i = 0; i < 3; i++) {
            compareResult.addStrike();
        }

        when(baseballContext.compareNumbers()).thenReturn(compareResult);

        gameProgressProcess.execute(baseballContext, ioContext);

        // when
        String result = gameProgressProcess.next();

        // then
        assertThat(result).isEqualTo("gameEndProcess");
    }

    @Test
    @DisplayName("정답이 아닐 시 next가 playerInputProcess를 반환한다.")
    void nextReturnPlayerInputProcessWhenWrong() {
        // given
        GameProgressProcess gameProgressProcess = new GameProgressProcess();
        CompareResult compareResult = new CompareResult();

        when(baseballContext.compareNumbers()).thenReturn(compareResult);

        gameProgressProcess.execute(baseballContext, ioContext);

        // when
        String result = gameProgressProcess.next();

        // then
        assertThat(result).isEqualTo("playerInputProcess");
    }
}