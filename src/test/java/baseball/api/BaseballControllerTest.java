package baseball.api;

import baseball.application.BaseballGameService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BaseballControllerTest {

    @Nested
    @DisplayName("Service 계층 호출 테스트")
    class CallServiceTest {

        @Test
        @DisplayName("baseballGameService의 startGame 메서드를 실행한다.")
        public void baseballGameService의_startGame_메서드를_실행한다() {
            BaseballGameService mockBaseballService = mock(BaseballGameService.class);
            BaseballController baseballController = new BaseballController(mockBaseballService);
            doNothing().when(mockBaseballService).startGame();

            baseballController.startBaseball();

            verify(mockBaseballService, times(1)).startGame();
        }

    }

}
