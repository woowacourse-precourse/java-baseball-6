package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.mockito.MockedStatic;

import static org.mockito.Mockito.*;

class BaseballTest {

    @Nested
    @DisplayName("Baseball 결과 테스트")
    class BaseballResultTest {

        private Baseball baseball;
        private MockedStatic<Randoms> randomsMockedStatic;

        @BeforeEach
        void setUp() {
            randomsMockedStatic = mockStatic(Randoms.class);
            when(Randoms.pickNumberInRange(1, 9)).thenReturn(1, 2, 3);
            baseball = new Baseball();
        }

        @AfterEach
        void reset() {
            randomsMockedStatic.close();
        }

        @Test
        @DisplayName("입력한 값과 랜덤으로 생성된 값이 일치할 경우 3을 리턴해야 한다.")
        public void 입력한_값과_랜덤으로_생성된_값이_일치할_경우_3을_리턴해야_한다() {
            int countStrike = baseball.countStrike("123");
            Assertions.assertThat(countStrike).isEqualTo(3);
        }

        @Test
        @DisplayName("입력한 값과 랜덤으로 생성된 값이 일치할 경우 참을 반환 해야 한다.")
        public void 입력한_값과_랜덤으로_생성된_값이_일치할_경우_참을_반환_해야_한다() {
            boolean isPerfect = baseball.isPerfect("123");
            Assertions.assertThat(isPerfect).isTrue();
        }


        @Test
        @DisplayName("입력한 값이 Nothing일 경우 참을 반환한다.")
        public void 입력한_값이_Nothing일_경우_참을_반환한다() {
            boolean isPerfect = baseball.isNothing("567");
            Assertions.assertThat(isPerfect).isTrue();
        }

    }
}
