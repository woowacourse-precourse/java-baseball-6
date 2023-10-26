package judge;

import ball.Balls;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class JudgeTest {
    private Judge judge;
    @BeforeEach
    void init(){
        judge = new Judge();
    }
    @ParameterizedTest
    @CsvSource(value = {"123,456", "789,456", "192,386"})
    @DisplayName("NOTHING 테스트")
    void judge_test_NOTHING(String userInput, String computerInput) {
        Balls userBalls = new Balls(userInput);
        Balls computerBalls = new Balls(computerInput);
        judge.compareBalls(userBalls, computerBalls);
        assertThat(judge.getStrikeCount()).isZero();
        assertThat(judge.getBallCount()).isZero();
    }

    @ParameterizedTest
    @ValueSource(strings = {"125", "523", "183"})
    @DisplayName("STRIKE 테스트")
    void judge_test_STRIKE(String userInput){
        String computerInput = "123";
        Balls userBalls = new Balls(userInput);
        Balls computerBalls = new Balls(computerInput);
        judge.compareBalls(userBalls, computerBalls);
        assertThat(judge.getStrikeCount()).isEqualTo(2);
        assertThat(judge.getBallCount()).isZero();
    }

    @ParameterizedTest
    @ValueSource(strings = {"372", "218", "931"})
    @DisplayName("BALL 테스트")
    void judge_test_BALL(String userInput){
        String computerInput = "123";
        Balls userBalls = new Balls(userInput);
        Balls computerBalls = new Balls(computerInput);
        judge.compareBalls(userBalls, computerBalls);
        assertThat(judge.getStrikeCount()).isZero();
        assertThat(judge.getBallCount()).isEqualTo(2);
    }

    @ParameterizedTest
    @ValueSource(strings = {"135", "721", "243"})
    @DisplayName("1 STRIKE 1 BALL 테스트")
    void judge_test_1BALL_1STRIKE(String userInput){
        String computerInput = "123";
        Balls userBalls = new Balls(userInput);
        Balls computerBalls = new Balls(computerInput);
        judge.compareBalls(userBalls, computerBalls);
        assertThat(judge.getStrikeCount()).isOne();
        assertThat(judge.getBallCount()).isOne();
    }
}
