package baseball.domain;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.*;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Pitch 도메인 테스트")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PitchTest extends NsTest {

    @DisplayName("빈 값을 입력한 경우")
    @Test
    @Order(0)
    public void Case_1_Empty_Input() {
        // when & given
        List<String> inputs = List.of(
                "\n", " ", "  ","          ", "1 2 3"
        );

        // then
        for (String input : inputs) {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(input))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }

    @DisplayName("3자리를 초과해서 입력한 경우")
    @Test
    @Order(1)
    public void Case_2_Over_Length_Input() {
        List<String> inputs = List.of(
                "12345", "3295834859", "1234"
        );

        // then
        for (String input : inputs) {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(input))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }

    @DisplayName("3자리 미만해서 입력한 경우")
    @Test
    @Order(2)
    public void Case_3_Less_Length_Input() {
        List<String> inputs = List.of(
                "1", "34"
        );

        // then
        for (String input : inputs) {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(input))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }

    @DisplayName("0을 입력한 경우")
    @Test
    @Order(3)
    public void Case_4_Zero_Input() {
        // when & given
        List<String> inputs = List.of(
            "109", "048", "000","012", "106"
        );

        // then
        for (String input : inputs) {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(input))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }

    @DisplayName("중복된 숫자를 입력한 경우")
    @Test
    @Order(4)
    public void Case_5_Duplicate_Input() {
        List<String> inputs = List.of(
                "111", "121", "323"
        );

        // then
        for (String input : inputs) {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(input))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }

    @DisplayName("영어, 한글, 특수 문자를 입력한 경우")
    @Test
    @Order(5)
    public void Case_6_Not_Number_Input() {
        List<String> inputs = List.of(
                "하이요", "Hii", "Who","인in", "*&*"
        );

        // then
        for (String input : inputs) {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(input))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }


}
