package baseball.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import baseball.dto.GameRequest;
import baseball.dto.GameResponse;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameDispatcherTest {

    // TODO GamePlay의 반환값을 GameRespone로 바인딩하여 출력합니다.
    @Test
    @DisplayName("TODO GamePlay의 반환값을 GameRespone로 바인딩하여 출력합니다.")
    public void testGameDispatcher() throws Exception {
        // given
        List<String> testArgs = Collections.emptyList();
        GameRequest testRequest = new GameRequest("predict", testArgs);

        GamePlay testGamePlay = mock(GamePlay.class);
        String testResult = "1볼 1스트라이크";
        when(testGamePlay.play(testArgs)).thenReturn(testResult);

        // when
        GameDispatcher gameDispatcher = new GameDispatcherImpl(testGamePlay);
        GameResponse response = gameDispatcher.dispatch(testRequest);

        // then
        assertThat(response.msg()).isEqualTo(testResult);
        assertThat(response.result()).isEqualTo("SUCCESS");
    }

    // TODO GamePlay가 예외를 쓰로우할 시, 해당 예외를 GameResponse로 바인딩하여 출력합니다.
    @Test
    @DisplayName("GamePlay가 예외를 쓰로우할 시, 해당 예외를 GameResponse로 바인딩하여 출력합니다.")
    public void testHandleException() throws Exception {
        // given
        List<String> testArgs = Collections.emptyList();
        GameRequest testRequest = new GameRequest("predict", testArgs);

        GamePlay testGamePlay = mock(GamePlay.class);
        String testMsg = "잘못된 입력입니다, 예측 가능한 수는 세자리(1~9) 숫자입니다.";
        when(testGamePlay.play(testArgs)).thenThrow(new IllegalArgumentException(testMsg));

        // when
        GameDispatcher gameDispatcher = new GameDispatcherImpl(testGamePlay);
        GameResponse response = gameDispatcher.dispatch(testRequest);

        // then
        assertThat(response.msg()).isEqualTo(testMsg);
        assertThat(response.result()).isEqualTo("FAIL");
    }

}
