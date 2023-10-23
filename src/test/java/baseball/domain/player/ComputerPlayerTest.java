package baseball.domain.player;

import baseball.domain.game.ContinueAnswer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerPlayerTest {
        public static final int LIMIT_NUMBER = 3;
        private BaseballPlayer baseballPlayer;

        @BeforeEach
        void init() {
                baseballPlayer = new Computer();
        }

        @Test
        @DisplayName("성공: computer 는 3 자리의 서로 다른 수를 생성 후 반환")
        void call_submitThreeNumber_given_limit_number_length() {
                //when
                String result = baseballPlayer.submitThreeNumber(LIMIT_NUMBER);

                //then
                assertThat(result.length()).isEqualTo(LIMIT_NUMBER);
                assertThat(result.matches("^(?!.*(.).*\\1)\\d{" + LIMIT_NUMBER + "}$")).isTrue();
        }

        @Test
        @DisplayName("성공: computer 는 항상 재시작 요청에 대해 YES 응답을 반환")
        void call_responseContinuePlay() {
                //when
                ContinueAnswer continueAnswer = baseballPlayer.responseContinuePlay();

                //then
                assertThat(continueAnswer).isEqualTo(ContinueAnswer.YES);
        }

}
