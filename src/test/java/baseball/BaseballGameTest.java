package baseball;

import baseball.controller.BaseballController;
import baseball.domain.CompareNumbers;
import baseball.domain.Computer;
import baseball.exception.InputException;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BaseballGameTest extends NsTest {
    @Test
    void 컴퓨터_랜덤숫자_생성(){
        assertThat(Computer.createRandomNumbers().size()).isEqualTo(3);
    }
    @Test
    void 사용자_숫자_길이_테스트(){
        String input = "0";
        assertThatThrownBy(()-> InputException.lenException(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 사용자_숫자_중복_테스트(){
        List<Integer> input = List.of(1,1,1);
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
        List<Integer> input = List.of(1,0,9);
        assertThatThrownBy(()->InputException.outOfRangeException(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 숫자_비교_테스트(){
        List<Integer> computer = List.of(1,2,9);
        List<Integer> player = List.of(7,4,6);
        CompareNumbers test = new CompareNumbers(computer, player);

        assertThat(test.generateResult()).isEqualTo("낫싱");
    }
    @Test
    void 볼_테스트(){
        List<Integer> computer = List.of(1,2,9);
        List<Integer> player = List.of(7,4,6);
        CompareNumbers test = new CompareNumbers(computer, player);

        assertThat(test.generateResult()).isEqualTo("낫싱");
    }
    @Test
    void 현재_진행상황_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("326", "234", "1", "245", "168", "2");
                    assertThat(output()).contains("2볼", "3스트라이크", "1", "낫싱", "3스트라이크", "게임 종료");
                },
                2, 3, 4, 1, 6, 8
        );
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
