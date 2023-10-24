package baseball.controller;

import baseball.Application;
import baseball.model.Command;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class BaseballControllerTest extends NsTest {

    @DisplayName("무한이 틀리는 경우 체크")
    @ParameterizedTest(name = "{displayName}")
    @MethodSource("parametersProvider")
    void checkStackOverflow(String[] guessNumbers, Integer first, Integer second, Integer third) {
        assertRandomNumberInRangeTest(
                () -> {
                    run(guessNumbers);
                    assertThat(output()).contains("낫싱", "3스트라이크", "게임 종료");
                },
                first, second, third
        );
    }

    static Stream<Arguments> parametersProvider() {
        int first = 4;
        int second = 5;
        int third = 6;
        String wrongNumber = "123";
        String infiniteFailureInput = (wrongNumber + ",").repeat(6000);
        String correctInput = first + String.valueOf(second) + third;
        String[] testCase = (infiniteFailureInput + correctInput + "," + Command.QUIT).split(",");
        return Stream.of(
                Arguments.arguments(testCase, first, second, third)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}