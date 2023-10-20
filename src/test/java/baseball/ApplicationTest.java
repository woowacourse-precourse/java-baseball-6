package baseball;

import baseball.error.ErrorException;
import baseball.error.GameInputErrorException;
import baseball.error.RetryInpurErrorException;
import baseball.model.Computer;
import baseball.util.BaseballNumberGenerator;
import baseball.util.BaseballRandomNumberGenerator;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class ApplicationTest extends NsTest {
    @Test
    void 컴퓨터_스트라이크_볼_횟수_테스트(){
        //given
        Computer computer = new Computer(List.of(1,2,3));
        final List<Integer> case1 = List.of(1,2,3); //3strike
        final List<Integer> case2 = List.of(4,5,6); //0,0
        final List<Integer> case3 = List.of(1,2,6); //2strike
        final List<Integer> case4 = List.of(2,3,1); //3ball
        final List<Integer> case5 = List.of(1,5,2); //1,1

        //when
        final List<Integer> result1 = computer.compareNumberList(case1);
        final List<Integer> result2 = computer.compareNumberList(case2);
        final List<Integer> result3 = computer.compareNumberList(case3);
        final List<Integer> result4 = computer.compareNumberList(case4);
        final List<Integer> result5 = computer.compareNumberList(case5);

        //then
        assertThat(result1).isEqualTo(List.of(0,3));
        assertThat(result2).isEqualTo(List.of(0,0));
        assertThat(result3).isEqualTo(List.of(0,2));
        assertThat(result4).isEqualTo(List.of(3,0));
        assertThat(result5).isEqualTo(List.of(1,1));
    }

    @Test
    void 컴퓨터_랜덤_생성된_숫자_사이즈_중복_테스트(){
        //given
        BaseballNumberGenerator baseballNumberGenerator = new BaseballRandomNumberGenerator();

        //when
        final List<Integer> case1 = baseballNumberGenerator.generate();
        final Set<Integer> case1Set = new HashSet<>(case1);

        //then
        assertThat(case1.contains(0)).isEqualTo(false);
        assertThat(case1.size() == 3).isEqualTo(true);
        assertThat(case1.size() == case1Set.size()).isEqualTo(true);

    }
    @Test
    void 숫자_야구_게임의_입력한_값이_유효한_값인지_검사_기능_테스트(){
        //given
        ErrorException errorException = new GameInputErrorException();
        final String case1 = "123"; //유효
        final String case2 = "dsa"; //숫자가 아님
        final String case3 = "1234"; // 3자릿 수가 아님
        final String case4 = "012"; // 1~9 범위가 아님
        final String case5 = "444"; // 중복 숫자
        final String IS_NOT_NUMERIC_MESSAGE = "숫자만 입력이 가능합니다. 애플리케이션을 종료합니다.";
        final String IS_NOT_THREE_DIGITS_MESSAGE = "3자리 숫자만 입력 가능합니다. 애플리케이션을 종료합니다.";
        final String IS_NOT_VALID_RANGE_MESSAGE = "각 자릿 숫자는 1~9의 숫자만 입력 가능합니다. 애플리케이션을 종료합니다.";
        final String EXIST_DUPLICATE_NUMBER = "각 자리에 서로 다른 숫자를 입력해야 합니다. 애플리케이션을 종료합니다.";

        //when
        errorException.checkUserInputValidate(case1);
        Throwable throwable1 = catchThrowable(() -> {
            errorException.checkUserInputValidate(case2);
        });
        Throwable throwable2 = catchThrowable(() -> {
            errorException.checkUserInputValidate(case3);
        });
        Throwable throwable3 = catchThrowable(() -> {
            errorException.checkUserInputValidate(case4);
        });
        Throwable throwable4 = catchThrowable(() -> {
            errorException.checkUserInputValidate(case5);
        });

        //then
        assertThat(throwable1).isInstanceOf(IllegalArgumentException.class).hasMessage(IS_NOT_NUMERIC_MESSAGE);
        assertThat(throwable2).isInstanceOf(IllegalArgumentException.class).hasMessage(IS_NOT_THREE_DIGITS_MESSAGE);
        assertThat(throwable3).isInstanceOf(IllegalArgumentException.class).hasMessage(IS_NOT_VALID_RANGE_MESSAGE);
        assertThat(throwable4).isInstanceOf(IllegalArgumentException.class).hasMessage(EXIST_DUPLICATE_NUMBER);
    }

    @Test
    void 게임_끝난_경우_재시작_종료_입력_값_유효한_지_검사_테스트(){
        //given
        ErrorException errorException = new RetryInpurErrorException();
        final String IS_NOT_NUMERIC_MESSAGE = "숫자만 입력이 가능합니다. 애플리케이션을 종료합니다.";
        final String IS_NOT_ONE_OR_TWO_MESSAGE = "1이나 2만 입력이 가능합니다. 애플리케이션을 종료합니다.";
        final String case1 = "1";
        final String case2 = "2";
        final String case3 = "123";
        final String case4 = "x";

        //when
        errorException.checkUserInputValidate(case1);
        errorException.checkUserInputValidate(case2);
        Throwable throwable1 = catchThrowable(() -> {
            errorException.checkUserInputValidate(case3);
        });
        Throwable throwable2 = catchThrowable(() -> {
            errorException.checkUserInputValidate(case4);
        });

        //then
        assertThat(throwable1).isInstanceOf(IllegalArgumentException.class).hasMessage(IS_NOT_ONE_OR_TWO_MESSAGE);
        assertThat(throwable2).isInstanceOf(IllegalArgumentException.class).hasMessage(IS_NOT_NUMERIC_MESSAGE);
    }
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
