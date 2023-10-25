package baseball.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameViewTest {

    private GameView view;
    private User user;

    @BeforeEach
    public void setUp() {
        user = mock(User.class);
        view = new GameView(user);
    }

    @DisplayName("게임 시작을 알리는 메시지를 출력하는 메소드가 호출한다.")
    @Test
    public void showGameStartMessage() {
        //when
        view.showStartMessage();

        //then
        verify(user).showStartMessage();
    }

    @DisplayName("사용자가 숫자를 입력하기 위한 메소드가 올바르게 호출된다.")
    @Test
    public void inputUserNumber() {
        //given
        when(user.getUserInput()).thenReturn("123");

        //when
        String userInput = view.getUserInput();

        verify(user).getUserInput();
        assertEquals("123", userInput);
    }
}