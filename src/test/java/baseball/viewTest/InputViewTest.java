package baseball.viewTest;

import baseball.view.InputView;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputViewTest {
    @BeforeEach
    public void setUp() {
        System.setIn(new ByteArrayInputStream("".getBytes()));
    }

    @AfterEach
    public void tearDown() {
        System.setIn(System.in);
    }

    @Test
    void 숫자입력_테스트() {
        String inputNum = "123";
        InputStream in = new ByteArrayInputStream(inputNum.getBytes());
        System.setIn(in);

        String UserInputNum = InputView.inputNum();
        assertEquals(inputNum, UserInputNum.trim());
    }

    @Test
    void 재시작_숫자입력_테스트() {
        String restartNum = "1";
        InputStream in = new ByteArrayInputStream(restartNum.getBytes());
        System.setIn(in);

        int UserRestartnum = InputView.restart();
        System.out.println(UserRestartnum);
        assertEquals(1, UserRestartnum);
    }
}
