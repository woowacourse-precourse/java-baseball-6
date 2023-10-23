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

    @Disabled
    @Test
    void testStart_사용자가_1을_입력하면_재시작한다(){
        System.setIn(new ByteArrayInputStream("1".getBytes()));
        server.run();
        Assertions.assertEquals(1,server.getGameStatusCode());
}
    @Disabled
    @Test
    void testStart_사용자가_2를_입력하면_종료한다(){
        System.setIn(new ByteArrayInputStream("2".getBytes()));
        server.run();
        Assertions.assertEquals(0,server.getGameStatusCode());
    }
}

