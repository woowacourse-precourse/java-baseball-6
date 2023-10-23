package baseball.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballControllerTest extends NsTest {

    @Test
    @DisplayName("잘못된 사용자 입력으로 게임 재시작 실패")
    void 게임_재시작_확인() {
        //given
        String input = "123";
        String wrongChoice = "3";
        //when
        //then
        assertThatThrownBy(() ->
                assertRandomNumberInRangeTest(() -> {
                    run(input, wrongChoice);
                }, 1, 2, 3)).isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}