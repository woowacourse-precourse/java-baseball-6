package baseball.domain.player;

import baseball.domain.judgement.GameState;
import baseball.domain.judgement.BaseballJudgement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerJudgementTest {
        private BaseballJudgement judgement;

        @BeforeEach
        void init() {
                judgement = new Computer();
        }

        @Test
        @DisplayName("성공: 주어진 두 수가 1 스트라이크인 경우")
        void call_judgementGameState_given_1_strike() {
                //given
                String num1 = "123";
                String num2 = "146";
                OutputStream out = new ByteArrayOutputStream();
                System.setOut(new PrintStream(out));
                //when
                GameState gameState = judgement.judgementGameState(num1, num2);
                //then
                assertThat(gameState).isEqualTo(GameState.PROGRESS);
                assertThat(out.toString().strip()).isEqualTo("1스트라이크");
        }

        @Test
        @DisplayName("성공: 주어진 두 수가 1 볼인 경우")
        void call_judgementGameState_given_1_ball() {
                //given
                String num1 = "123";
                String num2 = "415";
                OutputStream out = new ByteArrayOutputStream();
                System.setOut(new PrintStream(out));
                //when
                GameState gameState = judgement.judgementGameState(num1, num2);
                //then
                assertThat(gameState).isEqualTo(GameState.PROGRESS);
                assertThat(out.toString().strip()).isEqualTo("1볼");
        }

        @Test
        @DisplayName("성공: 주어진 두 수가 1 볼 1 스트라이크인 경우")
        void call_judgementGameState_given_1_ball_1_strike() {
                //given
                String num1 = "123";
                String num2 = "135";
                OutputStream out = new ByteArrayOutputStream();
                System.setOut(new PrintStream(out));
                //when
                GameState gameState = judgement.judgementGameState(num1, num2);
                //then
                assertThat(gameState).isEqualTo(GameState.PROGRESS);
                assertThat(out.toString().strip()).isEqualTo("1볼 1스트라이크");
        }

        @Test
        @DisplayName("성공: 낫싱인 경우")
        void call_judgementGameState_given_noting() {
                //given
                String num1 = "123";
                String num2 = "456";
                OutputStream out = new ByteArrayOutputStream();
                System.setOut(new PrintStream(out));
                //when
                GameState gameState = judgement.judgementGameState(num1, num2);
                //then
                assertThat(gameState).isEqualTo(GameState.PROGRESS);
                assertThat(out.toString().strip()).isEqualTo("낫싱");
        }

        @Test
        @DisplayName("성공: 3 스트라이크인 경우")
        void call_judgementGameState_given_3_strike() {
                //given
                String num1 = "123";
                String num2 = "123";
                //when
                GameState gameState = judgement.judgementGameState(num1, num2);
                //then
                assertThat(gameState).isEqualTo(GameState.FINISH);
        }
}
