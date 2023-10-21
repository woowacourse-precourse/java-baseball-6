package baseball;

import baseball.model.ComputerNumber;
import baseball.model.PlayerNumber;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    @DisplayName("3자리가 아닌 경우")
    void validatePlayerNumberLength() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> PlayerNumber.validateLength("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("1부터 9까지가 아닌 숫자이거나 문자일 경우")
    void validatePlayerNumberRange() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> PlayerNumber.validateNumberRange("3a6"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("3자리인데 중복된 숫자가 있을 경우")
    void validatePlayerDuplicateNumber() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> PlayerNumber.validateDuplicateNumber("336"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("컴퓨터 랜덤값 생성")
    void generateComputerRandomNumbers(){
        ComputerNumber computerNumber = new ComputerNumber();
        computerNumber.generateComputerNumber();
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
