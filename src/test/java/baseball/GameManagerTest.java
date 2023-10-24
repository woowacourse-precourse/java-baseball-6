package baseball;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameManagerTest {
    private GameManager game;

    @BeforeEach
    void setUp(){
        game = new GameManager();
    }

    @DisplayName("isValid입력값이 유효한 경우")
    @Test
    void 사용자입력_유효성_성공(){
        String playerInput = "187";
        boolean result = game.isValidForm(playerInput);
        Assertions.assertTrue(result);
    }

    @Test
    void 사용자입력_유효성_실패(){
        String playerInput = "1a3";
        boolean result = game.isValidForm(playerInput);
        Assertions.assertFalse(result);
    }

    @Test
    void 사용자입력_유효성_검사_숫자가_아님(){
        String playerInput = "1a3";
        boolean result = game.isValidForm(playerInput);
        Assertions.assertFalse(result);
    }
    @Test
    void 사용자입력_유효성_검사_숫자가_아님2(){
        String playerInput = "bac";
        boolean result = game.isValidForm(playerInput);
        Assertions.assertFalse(result);
    }
    @Test
    void 사용자입력_유효성_검사_3자리(){
        String playerInput = "13333333";
        boolean result = game.isValidForm(playerInput);
        Assertions.assertFalse(result);
    }
    @Test
    void 사용자입력_유효성_검사_숫자범위(){
        String playerInput = "012";
        boolean result = game.isValidForm(playerInput);
        Assertions.assertFalse(result);
    }
    @Test
    void 사용자입력_유효성_검사_중복(){
        String playerInput = "223";
        boolean result = game.isValidForm(playerInput);
        Assertions.assertFalse(result);
    }

}
