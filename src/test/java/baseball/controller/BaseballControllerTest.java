package baseball.controller;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

class BaseballControllerTest extends NsTest {

    //TODO: 무한히 틀려도 스택 오버플로우가 발생하지 않게 하는 방법 고민해보기
    @DisplayName("스택 오버플로우 예외 체크")
    @ParameterizedTest(name = "{displayName}")
    @MethodSource("parametersProvider")
    void checkStackOverflow(String[] value) {
        assertRandomNumberInRangeTest(
                () -> Assertions.assertThatThrownBy(() -> run(value))
                        .isInstanceOf(StackOverflowError.class),
                7, 2, 3
        );
    }

    static Stream<Arguments> parametersProvider() {
        String a = "123,".repeat(5000);
        a = a + "723,2";
        return Stream.of(
                Arguments.arguments((Object) a.split(","))
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}