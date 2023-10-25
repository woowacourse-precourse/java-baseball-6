package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.domain.BaseballNumbers;
import baseball.domain.Command;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ApplicationTest extends NsTest {

    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @CsvSource({"1234", "23", "53465", "13456", "895453", "123568", "123456789"})
    void 예외_테스트_세자리가_아닌_수(int input) {
        assertThatThrownBy(() -> BaseballNumbers.validate(List.of(input))).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"0", "120", "105", "024", "060", "690", "780", "805"})
    void 예외_테스트_0을_포함한_수(int input) {
        assertThatThrownBy(() -> BaseballNumbers.validate(List.of(input))).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"112", "322", "454", "252", "898", "889", "499", "157"})
    void 예외_테스트_중복을_포함한_수(int input) {
        assertThatThrownBy(() -> BaseballNumbers.validate(List.of(input))).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"-123", "-234", "-342", "-567", "-472", "-427", "-546", "-479", "-694", "-999"})
    void 예외_테스트_음수(int input) {
        assertThatThrownBy(() -> BaseballNumbers.validate(List.of(input))).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"우테코", "테코우", "코우테", "우우테테코코", "우우우우우우우우우우우우우우우우우우테코", "ウテコ", "UtEkO", "Ютеко", "யுடெகோ", "尤蒂科",
            "يوتيكو"})
    void 예외_테스트_문자열(String input) {
        assertThatThrownBy(() -> BaseballNumbers.validate(List.of(Integer.parseInt(input)))).isInstanceOf(
                IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"우1테코", "우1테1코", "12ute코", "우te12코", "5우테코45", "우123테ko", "ウ1테2kO6"})
    void 예외_테스트_문자열_숫자_혼합(String input) {
        assertThatThrownBy(() -> BaseballNumbers.validate(List.of(Integer.parseInt(input)))).isInstanceOf(
                IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"4", "54", "654", "재시작", "종료"})
    void 예외_테스트_재시작_혹은_종료_외_입력(String input) {
        assertThatThrownBy(() -> Command.validate(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
