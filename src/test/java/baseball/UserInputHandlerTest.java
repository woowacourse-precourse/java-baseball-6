package baseball;

import baseball.constants.AppConstants;
import baseball.controller.UserInputHandler;
import baseball.model.GameScoreDTO;
import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

public class UserInputHandlerTest {
    private InputStream originalSystemIn;

    protected void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @BeforeEach
    void setUp() {
        originalSystemIn = System.in;
    }

    @AfterEach
    void tearDown() {
        System.setIn(originalSystemIn);
    }

    @Test
    void 플레이어_입력값_테스트_정상값() {
        // 정상값 테스트
        systemIn("123");
        UserInputHandler userInputHandler = new UserInputHandler();
        Assertions.assertThat(userInputHandler.getUserInput()).isEqualTo(List.of(1, 2, 3));
        Console.close();
    }

    @Test
    void 플레이어_입력값_테스트_빈값() {
        systemIn("");
        UserInputHandler userInputHandler = new UserInputHandler();
        Assertions.assertThatThrownBy(() -> userInputHandler.getUserInput())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(AppConstants.ERR_WRONG_INPUT);
        Console.close();
    }

    @Test
    void 플레이어_입력값_테스트_숫자만() {
        systemIn("한글로");
        UserInputHandler userInputHandler = new UserInputHandler();
        Assertions.assertThatThrownBy(() -> userInputHandler.getUserInput())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(AppConstants.ERR_WRONG_INPUT);
        Console.close();

        systemIn("eng");
        Assertions.assertThatThrownBy(() -> userInputHandler.getUserInput())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(AppConstants.ERR_WRONG_INPUT);
        Console.close();
    }

    @Test
    void 플레이어_입력값_한자리() {
        systemIn("1");
        UserInputHandler userInputHandler = new UserInputHandler();
        Assertions.assertThatThrownBy(() -> userInputHandler.getUserInput())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(AppConstants.ERR_WRONG_INPUT);
        Console.close();
    }

    @Test
    void 플레이어_입력값_0포함() {
        systemIn("012");
        UserInputHandler userInputHandler = new UserInputHandler();
        Assertions.assertThatThrownBy(() -> userInputHandler.getUserInput())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(AppConstants.ERR_WRONG_INPUT);
        Console.close();
    }

    @Test
    void 플레이어_입력값_중복체크() {
        systemIn("111");
        UserInputHandler userInputHandler = new UserInputHandler();
        Assertions.assertThatThrownBy(() -> userInputHandler.getUserInput())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(AppConstants.ERR_WRONG_INPUT);
        Console.close();
    }

    @Test
    void 게임_재시작값_1() {
        systemIn("1");
        GameScoreDTO gameScoreDTO = new GameScoreDTO();
        gameScoreDTO.setGameOver(true);
        UserInputHandler userInputHandler = new UserInputHandler();
        Assertions.assertThat(userInputHandler.isContinueGame(gameScoreDTO)).isEqualTo(true);
        Console.close();
    }

    @Test
    void 게임_재시작값_2() {
        systemIn("2");
        GameScoreDTO gameScoreDTO = new GameScoreDTO();
        gameScoreDTO.setGameOver(true);
        UserInputHandler userInputHandler = new UserInputHandler();
        Assertions.assertThat(userInputHandler.isContinueGame(gameScoreDTO)).isEqualTo(false);
        Console.close();
    }

    @Test
    void 게임_재시작값_다른값() {
        systemIn("5");

        GameScoreDTO gameScoreDTO = new GameScoreDTO();
        gameScoreDTO.setGameOver(true);
        UserInputHandler userInputHandler = new UserInputHandler();
        Assertions.assertThatThrownBy(() -> userInputHandler.isContinueGame(gameScoreDTO))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(AppConstants.ERR_INVALID_RESTART_VALUE);
        Console.close();
    }
}