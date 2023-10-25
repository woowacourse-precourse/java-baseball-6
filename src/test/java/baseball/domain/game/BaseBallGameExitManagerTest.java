package baseball.domain.game;

import baseball.domain.game.BaseBallGameExitManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static camp.nextstep.edu.missionutils.Console.close;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseBallGameExitManagerTest {
    private final BaseBallGameExitManager baseBallGameExitManager = BaseBallGameExitManager.newInstance();

    @BeforeEach
    void consoleClose() {
        close();
    }

    @Test
    void 재시작_여부_출력_테스트() {
        // given
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        final String exitMessage = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
        // when
        baseBallGameExitManager.printInputExitOption();

        // then
        assertThat(out.toString().trim()).isEqualTo(exitMessage);
    }

    @Test
    void 새로운_게임_시작_테스트() {
        // given & when
        String inputCommand = "2";
        System.setIn(new ByteArrayInputStream(inputCommand.getBytes()));
        final boolean userInputRetryOption = baseBallGameExitManager.isExitingBaseballGame();

        // then
        assertThat(userInputRetryOption).isTrue();
    }

    @Test
    void 게임_종료_테스트() {
        // given & when
        String inputCommand = "1";
        System.setIn(new ByteArrayInputStream(inputCommand.getBytes()));
        final boolean userInputRetryOption = baseBallGameExitManager.isExitingBaseballGame();

        // then
        assertThat(userInputRetryOption).isFalse();
    }

    @Test
    void 다른_커맨드_입력시_익셉션_발생_테스트() {
        // given
        String inputCommand = "3";
        System.setIn(new ByteArrayInputStream(inputCommand.getBytes()));
        // when & then
        assertThatThrownBy(baseBallGameExitManager::isExitingBaseballGame)
                .isInstanceOf(IllegalArgumentException.class);
    }

}