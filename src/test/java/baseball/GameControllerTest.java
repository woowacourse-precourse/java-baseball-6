package baseball;

import baseball.controller.GameController;
import baseball.model.GameModel;
import baseball.view.GameView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameControllerTest {

    private GameModel model;
    private GameView view;
    private GameController controller;

    @BeforeEach
    void setUp() {
        model = mock(GameModel.class);
        view = mock(GameView.class);
        controller = new GameController(model, view);
    }

    @Test
    void testReplayGameOption() {
        // Arrange
        when(view.askForReplay()).thenReturn(true); // 시뮬레이션: 게임을 다시 시작하는 선택

        // Act
        controller.handleGameEnd();

        // Assert
        assertFalse(model.isExit());
        assertFalse(model.isGameRunning());
        // 두 변수가 모두 false, updateResult 이후에 isGameRunning이 true
    }

    @Test
    void testExitGameOption() {
        // Arrange
        when(view.askForReplay()).thenReturn(false); // 시뮬레이션: 게임을 완전히 종료하는 선택

        // Act
        controller.handleGameEnd();

        // Assert
        assertFalse(model.isGameRunning());
    }

}
