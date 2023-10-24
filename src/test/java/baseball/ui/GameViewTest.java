package baseball.ui;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.controller.AbstractGameController;
import baseball.controller.GameController;
import baseball.controller.GameControllerImpl;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameViewTest {

    final GameView gameView = new GameView(new GameControllerImpl(), new UserInputValidator(), () -> {
        return "123";
    });

    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void 게임시작_시작안내문구를_출력한다() {
        gameView.start();
        assertEquals("숫자 야구 게임을 시작합니다.", outputStreamCaptor.toString().trim());
    }

    @Test
    public void 추측시작_입력안내문구를_출력한다() {
        gameView.guessUntilCorrect();
        assertEquals("숫자를 입력해주세요 : ", outputStreamCaptor.toString().trim());
    }

    @Test
    public void 추측_실패시_다시_추측한다() {
        GameController mockGameControllerTerminateAfterTwice = new AbstractGameController() {
            int count = 0;

            @Override
            public boolean isStillWrong() {
                return count++ < 2;
            }
        };
        GameView gameView = new GameView(mockGameControllerTerminateAfterTwice, new UserInputValidator(), () -> {
            return "123";
        });

        gameView.guessUntilCorrect();

        assertThat(outputStreamCaptor.toString().trim().contains("숫자를 입력해주세요 : 숫자를 입력해주세요 : "));
    }

    @Test
    public void 추측_성공시_성공문구_출력한다() {
        GameController gameController = new AbstractGameController() {
            @Override
            public boolean isStillWrong() {
                return false;
            }
        };
        GameView gameView = new GameView(gameController, new UserInputValidator(), () -> {
            return "123";
        });

        gameView.guessUntilCorrect();

        assertEquals("3개의 숫자를 모두 맞히셨습니다! 게임 종료", outputStreamCaptor.toString().trim());
    }

    private static void mockInput() {
        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

}