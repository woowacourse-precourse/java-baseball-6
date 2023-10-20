package baseball;

import baseball.domain.Computer;
import baseball.exception.InputException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BaseballGameTest {
    @Test
    void 컴퓨터_랜덤숫자_생성(){
        Computer computer = new Computer();
        assertThat(computer.getRandomNumbers().size()).isEqualTo(3);
    }
    @Test
    void 사용자_숫자_길이_테스트(){
        String input = "0";
        assertThatThrownBy(()-> InputException.lenException(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 사용자_숫자_중복_테스트(){
        List<String> input = List.of("1","1","1");
        assertThatThrownBy(()->InputException.duplicateException(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 사용자_숫자_문자포함_테스트(){
        String input = "S2!";
        assertThatThrownBy(()->InputException.notNumericException(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 사용자_숫자_범위_테스트(){
        List<String> input = List.of("1","0","9");
        assertThatThrownBy(()->InputException.outOfRangeException(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
