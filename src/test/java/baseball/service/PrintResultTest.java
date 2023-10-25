package baseball.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.Application;
import baseball.domain.User;
import baseball.dto.UserRequestDto;
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
        UserRequestDto userRequestDto = UserRequestDto.createUserRequestDto(List.of(1, 2, 3));
        userRequestDto.setBall(0);
        userRequestDto.setStrike(0);

        //when
        User user = User.createUser(userRequestDto);

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
        UserRequestDto userRequestDto = UserRequestDto.createUserRequestDto(List.of(1, 2, 3));
        userRequestDto.setBall(2);
        userRequestDto.setStrike(0);

        //when
        User user = User.createUser(userRequestDto);

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
        UserRequestDto userRequestDto = UserRequestDto.createUserRequestDto(List.of(1, 2, 3));
        userRequestDto.setBall(0);
        userRequestDto.setStrike(2);

        //when
        User user = User.createUser(userRequestDto);

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
        UserRequestDto userRequestDto = UserRequestDto.createUserRequestDto(List.of(1, 2, 3));
        userRequestDto.setBall(1);
        userRequestDto.setStrike(1);

        //when
        User user = User.createUser(userRequestDto);

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
        UserRequestDto userRequestDto = UserRequestDto.createUserRequestDto(List.of(1, 2, 3));
        userRequestDto.setBall(0);
        userRequestDto.setStrike(3);

        //when
        User user = User.createUser(userRequestDto);

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