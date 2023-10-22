package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

public class ServerTest {
    private Server server;
    @BeforeEach
    void setUp(){
        server = new Server();
    }
    @Test
    void testValidatePlayerInput_알맞은_값을_입력하면_에러없이_동작한다(){
        String correctInput = "154";
        Assertions.assertDoesNotThrow(()->server.validatePlayerInput(correctInput));
    }
    @Test
    void testValidatePlayerInput_숫자가_아닌_값을_입력하면_에러가_발생한다(){
        String wrongInput = "This is String";
        IllegalArgumentException exception =
                Assertions.assertThrows(IllegalArgumentException.class,
                        ()->server.validatePlayerInput(wrongInput));
        Assertions.assertEquals("숫자를 입력해주세요!",exception.getMessage());
    }
    @Test
    void testValidatePlayerInput_자리수가_다른_숫자를_입력하면_에러가_발생한다(){
        String wrongInput = "1538";
        IllegalArgumentException exception =
                Assertions.assertThrows(IllegalArgumentException.class,
                        ()->server.validatePlayerInput(wrongInput));
        Assertions.assertEquals("자리수가 다릅니다!",exception.getMessage());
    }
    @Test
    void testValidatePlayerInput_각자리수가_범위를_벗어나면_에러가_발생한다(){
        String wrongInput = "503";
        IllegalArgumentException exception =
                Assertions.assertThrows(IllegalArgumentException.class,
                        ()->server.validatePlayerInput(wrongInput));
        Assertions.assertEquals("숫자가 범위밖에 있습니다!",exception.getMessage());
    }
    @Test
    void testValidatePlayerInput_중복된_숫자를_포함하면_에러가_발생한다(){
        String wrongInput = "144";
        IllegalArgumentException exception =
                Assertions.assertThrows(IllegalArgumentException.class,
                        ()->server.validatePlayerInput(wrongInput));
        Assertions.assertEquals("중복된 숫자가 있습니다!",exception.getMessage());
    }
    @Disabled
    @Test
    void testStart_사용자가_1을_입력하면_재시작한다(){
        System.setIn(new ByteArrayInputStream("1".getBytes()));
        server.start();
        Assertions.assertEquals(1,server.getGameStatusCode());
}
    @Disabled
    @Test
    void testStart_사용자가_2를_입력하면_종료한다(){
        System.setIn(new ByteArrayInputStream("2".getBytes()));
        server.start();
        Assertions.assertEquals(0,server.getGameStatusCode());
    }
}

