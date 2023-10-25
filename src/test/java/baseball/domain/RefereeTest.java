package baseball.domain;

import baseball.dto.BaseballGameResultDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class RefereeTest {

    private static Referee referee;

    @BeforeEach
    void setUp(){
        referee = new Referee();
        referee.decideAnswer(new BaseballNumber(List.of(1,2,3)));
    }

    @ParameterizedTest(name = "{index}. STRIKE_TEST : 입력값 = {0} 결과값 = {1}스트라이크")
    @CsvSource(value = {"1,2,3:3","1,2,4:2","1,4,5:1"}, delimiter = ':')
    void judge_test_strike(String source, int expected){
        List<Integer> numbers = Arrays.stream(source.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        BaseballNumber guess = new BaseballNumber(numbers);
        BaseballGameResultDto dto = referee.judge(guess);
        assertThat(dto.getStrike()).isEqualTo(expected);
    }

    @ParameterizedTest(name = "{index}. BALL_TEST : 입력값 = {0} 결과값 = {1}볼")
    @CsvSource(value = {"4,6,1:1","4,3,2:2","3,1,2:3","1,3,6:1"}, delimiter = ':')
    void judge_test_ball(String source, int expected){
        List<Integer> numbers = Arrays.stream(source.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        BaseballNumber guess = new BaseballNumber(numbers);
        BaseballGameResultDto dto = referee.judge(guess);
        assertThat(dto.getBall()).isEqualTo(expected);
    }
}