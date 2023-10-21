package baseball;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {

    private final InputStream systemIn = System.in;
    private ByteArrayInputStream testIn;

    /**
     * @Method : System.in 복원
     * @auther : SYB
     * @since : 2023/10/21
     */
    @AfterEach
    public void restoreInput() {
        System.setIn(systemIn);
    }

    /**
     * @Method : 콘솔 입력 제공
     * @auther : SYB
     * @since : 2023/10/21
     */
    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @Test
    void 사용자_입력_기능_검증() {
        Game game = new Game();
        provideInput("123a");
        assertThat(game.inputUserNumber()).isEqualTo(List.of(1, 2, 3));
    }

    @Test
    void 사용자_숫자_입력_예외_테스트() {
        Game game = new Game();
        provideInput("123");
        assertThrows(IllegalArgumentException.class, () -> game.inputUserNumber());
    }

}
