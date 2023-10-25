package baseball.domain.game;

import baseball.application.ConsoleInputOutput;
import baseball.domain.BallsFixture;
import baseball.domain.ball.Ball;
import baseball.domain.picker.BallPicker;
import baseball.domain.picker.RandomBallPicker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

class GameTest {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 9;

    @Test
    @DisplayName("게임 실행은 정상적으로 작동되어야 한다.")
    void 게임_실행_정상작동() {
        BallPicker ballPicker = mock(RandomBallPicker.class);
        when(ballPicker.pickNumberInRange(MIN_RANGE, MAX_RANGE)).thenReturn(new Ball(4), new Ball(2), new Ball(5));

        GameOperator gameOperator = mock(ConsoleInputOutput.class);
        when(gameOperator.batting()).thenReturn(BallsFixture.fixture().build());

        Game game = new Game(ballPicker, gameOperator);
        game.play();

        verify(gameOperator).batting();
        verify(gameOperator).round(any());
    }

    @Test
    @DisplayName("게임을 계속 할지 물어보는 것은 정상 작동 되어야 한다")
    void 게임_계속진행_정상작동() {
        BallPicker ballPicker = mock(RandomBallPicker.class);
        GameOperator gameOperator = mock(ConsoleInputOutput.class);
        when(gameOperator.isContinue()).thenReturn(true);

        Game game = new Game(ballPicker, gameOperator);
        boolean isContinue = game.wantsToContinue();

        assertTrue(isContinue);
    }
}