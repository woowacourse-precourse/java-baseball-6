package baseball.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.Application;
import baseball.domain.User;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 출력문 테스트
 */
class PrintResultTest extends NsTest {
    private final PrintResult printResult;

    public PrintResultTest() {
        printResult = new PrintResult();
    }

    @DisplayName("낫싱")
    @Test
    void nothing() {
        //given
        User user = User.createUser(List.of(1, 2, 3));
        user.setBall(0);
        user.setStrike(0);

        //then
        assertSimpleTest(() -> {
            printResult.result(user);
            assertThat(output()).contains("낫싱");
        });
    }

    @DisplayName("Ball")
    @Test
    void ball() {
        //given
        User user = User.createUser(List.of(1, 2, 3));
        user.setBall(2);
        user.setStrike(0);

        //then
        assertSimpleTest(() -> {
            printResult.result(user);
            assertThat(output()).contains("2볼");
        });
    }

    @DisplayName("Strike")
    @Test
    void strike() {
        //given
        User user = User.createUser(List.of(1, 2, 3));
        user.setBall(0);
        user.setStrike(2);

        //then
        assertSimpleTest(() -> {
            printResult.result(user);
            assertThat(output()).contains("2스트라이크");
        });
    }

    @DisplayName("Ball & Strike")
    @Test
    void ballAndStrike() {
        //given
        User user = User.createUser(List.of(1, 2, 3));
        user.setBall(1);
        user.setStrike(1);

        //then
        assertSimpleTest(() -> {
            printResult.result(user);
            assertThat(output()).contains("1볼 1스트라이크");
        });
    }

    @DisplayName("Strike3")
    @Test
    void strike3() {
        //given
        User user = User.createUser(List.of(1, 2, 3));
        user.setBall(0);
        user.setStrike(3);

        //then
        assertSimpleTest(() -> {
            printResult.result(user);
            assertEquals(
                    "3스트라이크\n"
                            + "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
                            + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.",
                    output().trim());
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}