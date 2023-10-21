package baseball;

import baseball.model.ComputerNumber;
import baseball.model.PlayerNumber;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
    @DisplayName("컴퓨터 랜덤값 생성")
    void generateComputerRandomNumbers(){
        ComputerNumber computerNumber = new ComputerNumber();
        computerNumber.generateComputerNumber();
    }

    @DisplayName("사용자 입력 예외사항 처리")
    @ParameterizedTest
    @ValueSource(strings = {"31","i","3a6","abc","012","311",""," "})
    void validatePlayerNumber(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new PlayerNumber(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
