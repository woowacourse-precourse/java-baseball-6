package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class BaseballTest {

    @Nested
    @DisplayName("Baseball 결과 테스트")
    class BaseballResultTest {

        private Baseball baseball;

        @BeforeEach
        void setUp() {
            mockStatic(Randoms.class);
            when(Randoms.pickNumberInRange(1, 9)).thenReturn(1, 2, 3);
            baseball = new Baseball();
        }

        @Test
        @DisplayName("입력한 값과 랜덤으로 생성된 값이 일치할 경우 3을 리턴해야 한다.")
        public void 입력한_값과_랜덤으로_생성된_값이_일치할_경우_3을_리턴해야_한다() {
            int countStrike = baseball.countStrike("123");
            Assertions.assertThat(countStrike).isEqualTo(3);
        }

    }
}
