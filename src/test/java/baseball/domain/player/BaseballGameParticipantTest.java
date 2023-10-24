package baseball.domain.player;

import baseball.domain.game.RetryAnswer;
import baseball.mock.FakeGameConsoleReader;
import baseball.util.GameConsole;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballGameParticipantTest {
        public static final int LIMIT_NUMBER = 3;
        private BaseballPlayer baseballPlayer;
        private GameConsole gameConsole;

        @Test
        @DisplayName("성공: 플레이어가 서로 다른 숫자 3가지를 입력한 경우")
        void call_inputNumber_given_3_different_numbers() {
                //given
                String number = "123";
                gameConsole = new FakeGameConsoleReader(number);
                baseballPlayer = new BaseballGameParticipant(gameConsole);

                //when
                String result = baseballPlayer.provideLimitedNumber(LIMIT_NUMBER);

                //then
                assertThat(number).isEqualTo(result);
        }

        @Test
        @DisplayName("실패: 플레이어가 중복된 숫자를 입력한 경우")
        void call_inputNumber_given_3_duplicate_numbers() {
                //given
                gameConsole = new FakeGameConsoleReader("122");
                baseballPlayer = new BaseballGameParticipant(gameConsole);

                // then
                assertThatThrownBy(() -> baseballPlayer.provideLimitedNumber(LIMIT_NUMBER))
                        .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("예외: 플레이어가 3개를 초과한 숫자를 입력한 경우")
        void call_inputNumber_given_over_4_numbers() {
                //given
                gameConsole = new FakeGameConsoleReader("123456");
                baseballPlayer = new BaseballGameParticipant(gameConsole);

                // then
                assertThatThrownBy(() -> baseballPlayer.provideLimitedNumber(LIMIT_NUMBER))
                        .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("예외: 플레이어가 숫자 이외의 문자를 입력한 경우")
        void call_inputNumber_given_string_mixed_numbers() {
                //given
                gameConsole = new FakeGameConsoleReader("12!");
                baseballPlayer = new BaseballGameParticipant(gameConsole);

                // then
                assertThatThrownBy(() -> baseballPlayer.provideLimitedNumber(LIMIT_NUMBER))
                        .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("재시작: 플레이어가 1을 입력한 경우")
        void call_responseContinuePlay_when_player_enter_1() {
                //given
                String response = "1";
                gameConsole = new FakeGameConsoleReader(response);
                baseballPlayer = new BaseballGameParticipant(gameConsole);

                //when
                RetryAnswer continueAnswer = baseballPlayer.responseRetryPlay();

                //then
                assertThat(continueAnswer).isEqualTo(RetryAnswer.YES);
        }

        @Test
        @DisplayName("종료: 플레이어가 2를 입력한 경우")
        void call_responseContinuePlay_when_player_enter_2() {
                //given
                String response = "2";
                gameConsole = new FakeGameConsoleReader(response);
                baseballPlayer = new BaseballGameParticipant(gameConsole);

                //when
                RetryAnswer continueAnswer = baseballPlayer.responseRetryPlay();

                //then
                assertThat(continueAnswer).isEqualTo(RetryAnswer.NO);
        }

        @Test
        @DisplayName("예외: 플레이어가 1 또는 2 이외의 문자를 입력한 경우")
        void call_responseContinuePlay_when_player_enter_3() {
                //given
                String response = "3";
                gameConsole = new FakeGameConsoleReader(response);
                baseballPlayer = new BaseballGameParticipant(gameConsole);

                //then
                assertThatThrownBy(() -> baseballPlayer.responseRetryPlay())
                        .isInstanceOf(IllegalArgumentException.class);
        }
}
