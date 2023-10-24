package baseball.domain.game;

import baseball.domain.game.BaseBallGameExitManager;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class BaseBallGameExitManagerTest {
    private final BaseBallGameExitManager baseBallGameExitManager = BaseBallGameExitManager.newInstance();

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
        final boolean userInputRetryOption = baseBallGameExitManager.isUserInputRetryOption("1");

        // then
        assertThat(userInputRetryOption).isTrue();
    }

    @Test
    void 게임_종료_테스트() {
        // given & when
        final boolean userInputExitOption = baseBallGameExitManager.isUserInputExitOption("2");

        // then
        assertThat(userInputExitOption).isTrue();
    }

}