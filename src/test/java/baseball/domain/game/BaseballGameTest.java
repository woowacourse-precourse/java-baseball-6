package baseball.domain.game;

import baseball.domain.judgement.BaseballJudgement;
import baseball.domain.player.BaseballPlayer;
import baseball.domain.player.Computer;
import baseball.mock.FakePlayer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

class BaseballGameTest {
        private Game baseballGame;

        @BeforeEach
        void init() {
                BaseballJudgement judgement = new Computer();
                BaseballPlayer playerA = new FakePlayer(RetryAnswer.YES, "123");
                BaseballPlayer playerB = new FakePlayer(RetryAnswer.NO, "123");
                baseballGame = new BaseballGame(judgement, playerA, playerB);
        }

        @Test
        @DisplayName("성공: 3 스트라이크 였을 때 게임을 종료하는 경우")
        void call_start_and_finish() {
                //given
                OutputStream out = new ByteArrayOutputStream();
                System.setOut(new PrintStream(out));
                String outputMessage = """
                        3스트라이크
                        3개의 숫자를 모두 맞히셨습니다! 게임 종료\s
                        게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
                        게임 종료""";

                //when
                baseballGame.start();

                //then
                Assertions.assertThat(out.toString().strip()).isEqualTo(outputMessage);
        }

        @Test
        @DisplayName("성공: 3 스트라이크 였을 때 게임을 1번 다시 하는 경우")
        void call_start_and_1_retry() {
                //given
                BaseballJudgement judgement = new Computer();
                BaseballPlayer playerA = new FakePlayer(RetryAnswer.YES, "123");
                BaseballPlayer playerB = new FakePlayer(RetryAnswer.YES, "123");
                baseballGame = new BaseballGame(judgement, playerA, playerB);

                OutputStream out = new ByteArrayOutputStream();
                System.setOut(new PrintStream(out));
                String outputMessage = """
                        3스트라이크
                        3개의 숫자를 모두 맞히셨습니다! 게임 종료\s
                        게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
                        3스트라이크
                        3개의 숫자를 모두 맞히셨습니다! 게임 종료\s
                        게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
                        게임 종료""";

                //when
                baseballGame.start();

                //then
                Assertions.assertThat(out.toString().strip()).isEqualTo(outputMessage);
        }

        @Test
        @DisplayName("성공: 게임 종료 메시지 출력")
        void call_finish() {
                OutputStream out = new ByteArrayOutputStream();
                System.setOut(new PrintStream(out));
                String outputMessage = "게임 종료";

                //when
                baseballGame.finish();

                //then
                Assertions.assertThat(out.toString().strip()).isEqualTo(outputMessage);
        }
}
