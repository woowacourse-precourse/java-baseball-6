package baseball.service;

import baseball.domain.Baseball;
import baseball.domain.Result;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballServiceTest {
    BaseballService baseballService = new BaseballService();

    @Test
    void 숫자비교_낫싱() {
        Baseball answer = new Baseball(123);
        Baseball guess = new Baseball(456);
        Result result = baseballService.compare(guess, answer);
        Result expectedResult = new Result(0, 0);
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void 숫자비교_1볼() {
        Baseball answer = new Baseball(123);
        Baseball guess = new Baseball(451);
        Result result = baseballService.compare(guess, answer);
        Result expectedResult = new Result(1, 0);
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void 숫자비교_2볼() {
        Baseball answer = new Baseball(123);
        Baseball guess = new Baseball(214);
        Result result = baseballService.compare(guess, answer);
        Result expectedResult = new Result(2, 0);
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void 숫자비교_3볼() {
        Baseball answer = new Baseball(123);
        Baseball guess = new Baseball(231);
        Result result = baseballService.compare(guess, answer);
        Result expectedResult = new Result(3, 0);
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void 숫자비교_1스트라이크() {
        Baseball answer = new Baseball(123);
        Baseball guess = new Baseball(145);
        Result result = baseballService.compare(guess, answer);
        Result expectedResult = new Result(0, 1);
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void 숫자비교_2스트라이크() {
        Baseball answer = new Baseball(123);
        Baseball guess = new Baseball(124);
        Result result = baseballService.compare(guess, answer);
        Result expectedResult = new Result(0, 2);
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void 숫자비교_3스트라이크() {
        Baseball answer = new Baseball(123);
        Baseball guess = new Baseball(123);
        Result result = baseballService.compare(guess, answer);
        Result expectedResult = new Result(0, 3);
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void 숫자비교_2볼1스트라이크() {
        Baseball answer = new Baseball(123);
        Baseball guess = new Baseball(213);
        Result result = baseballService.compare(guess, answer);
        Result expectedResult = new Result(2, 1);
        assertThat(result).isEqualTo(expectedResult);
    }
}