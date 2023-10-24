package baseball.service;

import baseball.model.ComputerNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballGameServiceTest {

    private BaseballGameService baseballGameService;

    @BeforeEach
    void setup() {
        baseballGameService = new BaseballGameService();
    }

    @Test
    @DisplayName("잘못된 사용자의 입력으로 게임 결과 가져오기 실패")
    void 게임_서비스_확인() throws Exception {
        //given
        String input = "1234";
        List<Integer> computerNumber = new ComputerNumber().getNumber();
        //when
        //then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> baseballGameService.getGameResult(input,computerNumber))
                        .isInstanceOf(IllegalArgumentException.class));

    }

}