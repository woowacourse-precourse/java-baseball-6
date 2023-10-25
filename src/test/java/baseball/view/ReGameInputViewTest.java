package baseball.view;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Test;
import baseball.constant.errormessage.PlayerInputError;

class ReGameInputViewTest {

    ReGameInputView reGameInputView = new ReGameInputView();

    @Test
    void 객체생성_예외발생_허가받지않은문자() {
        // Given
        System.setIn(new ByteArrayInputStream("3".getBytes()));

        // When
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> reGameInputView.inputReGameCommand());

        // Then
        assertEquals(exception.getMessage(), PlayerInputError.PLAYER_REGAME_WRONG_INPUT_NUMBER_MESSAGE);
    }

    @Test
    void 객체생성_정상값_입력() {
        // Given
        InputStream input = new ByteArrayInputStream("1\n".getBytes());
        System.setIn(input);

        // When && Then
        try {
            reGameInputView.inputReGameCommand();
        } catch (IllegalArgumentException e) {
            fail();
        }
    }
}