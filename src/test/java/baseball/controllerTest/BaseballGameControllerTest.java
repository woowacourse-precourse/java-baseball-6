package baseball.controllerTest;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.controller.BaseballGameController;
import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BaseballGameControllerTest {
    private BaseballGameController baseballGameController;

    @BeforeEach
    public void generateBaseballGameController() {
        baseballGameController = new BaseballGameController();
    }

    @Test
    void 게임시작_상태_테스트() {
        baseballGameController.gameStart();
        assertThat(baseballGameController.getGameStatus()).isEqualTo("PLAYING");
    }

    @Test
    void 게임재시작_상태_테스트() {

        String restartNum = "1";
        InputStream in = new ByteArrayInputStream(restartNum.getBytes());
        System.setIn(in);
        baseballGameController.restartOrEnd();

        assertThat(baseballGameController.getGameStatus()).isEqualTo("PLAYING");
        Console.close();
    }

    @Test
    void 게임종료_상태_테스트() {

        String restartNum = "2";
        InputStream in = new ByteArrayInputStream(restartNum.getBytes());
        System.setIn(in);
        baseballGameController.restartOrEnd();

        assertThat(baseballGameController.getGameStatus()).isEqualTo("END");
        Console.close();
    }

}
