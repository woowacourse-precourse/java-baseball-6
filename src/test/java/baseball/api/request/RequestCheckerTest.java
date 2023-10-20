package baseball.api.request;

import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RequestCheckerTest {

    @DisplayName("사용자 입력 시나리오")
    @TestFactory
    Collection<DynamicTest> gameRequest() {
        // given
        command(new String[]{"123","1234", "28a", "104", "288"});
        return List.of(
                DynamicTest.dynamicTest("3자리가 아닌경우 예외가 발생한다.", () -> {
                    //when
                    String input = RequestChecker.gameRequest();
                    // then
                    assertThat("123").isEqualTo(input);
                    System.out.println(input);
                }),

                DynamicTest.dynamicTest("3자리가 아닌경우 예외가 발생한다.", () -> {

                    //when //then
                    assertThatThrownBy(RequestChecker::gameRequest)
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage("사용자의 입력값은 3자리 수이며 1-9까지의 값만 가능합니다.");
                }),
                DynamicTest.dynamicTest("문자가 들어온다면 예외가 발생한다.", () -> {

                    //when //then
                    assertThatThrownBy(RequestChecker::gameRequest)
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage("사용자의 입력값은 3자리 수이며 1-9까지의 값만 가능합니다.");
                }),
                DynamicTest.dynamicTest("숫자 0이 들어온다면 예외가 발생한다.", () -> {

                    //when //then
                    assertThatThrownBy(RequestChecker::gameRequest)
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage("사용자의 입력값은 3자리 수이며 1-9까지의 값만 가능합니다.");
                }),
                DynamicTest.dynamicTest("중복된 값이 들어온다면 예외가 발생한다.", () -> {

                    //when //then
                    assertThatThrownBy(RequestChecker::gameRequest)
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage("입력값은 중복되면 안됩니다.");
                })
        );
    }

    private void command(final String... results) {
        byte[] bytes = String.join("\n", results).getBytes();
        System.setIn(new ByteArrayInputStream(bytes));
    }

}