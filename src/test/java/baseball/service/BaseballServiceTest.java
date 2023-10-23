package baseball.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mockStatic;

import baseball.model.Baseball;
import baseball.model.BaseballNumber;
import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

class BaseballServiceTest {

    private static MockedStatic<Randoms> randoms;
    private final BaseballService baseballService = new BaseballService();

    @BeforeAll
    static void beforeAll() {
        randoms = mockStatic(Randoms.class);
    }

    @AfterAll
    static void afterAll() {
        randoms.close();
    }

    @Nested
    @DisplayName("1-9까지 임의의 서로 다른 세 숫자를 생성할 시")
    class createAnswerBaseball {

        @DisplayName("성공적으로 생성한다.")
        @Test
        void success() {
            //given
            given(Randoms.pickNumberInRange(anyInt(), anyInt())).willReturn(5, 1, 1, 2, 2);

            //when
            Baseball answerBaseball = baseballService.createAnswerBaseball();

            //then
            assertThat(answerBaseball).isNotNull();
            Assertions.assertThat(answerBaseball.getBaseballNumbers())
                    .extracting(BaseballNumber::getNumber)
                    .containsExactly(5, 1, 2);
        }
    }
}