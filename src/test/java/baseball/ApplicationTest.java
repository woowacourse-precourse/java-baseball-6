package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ApplicationTest extends NsTest {
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

    // 잘못된 입력값 예외 검증 테스트 - 길이가 3, 해당 값은 숫자로 변환 불가한 문자 -> 예외 발생 체크
    @Test
    void inputTest1(){
        assertSimpleTest(()->
                assertThatThrownBy(() -> runException("not"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // 잘못된 입력값 예외 검증 테스트 - 길이가 3이 아님, 해당 값은 숫자로 변환 불가한 문자 -> 예외 발생 체크
    @Test
    void inputTest2(){
        assertSimpleTest(()->
                assertThatThrownBy(() -> runException("notNumber"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    // 잘못된 입력값 예외 검증 테스트 - 길이가 3이 아님, 해당 값은 숫자로 변환 불가한 문자(스페이스바) -> 예외 발생 체크
    @Test
    void inputTest3(){
        assertSimpleTest(()->
                assertThatThrownBy(() -> runException(" "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // 잘못된 입력값 예외 검증 테스트 - 길이가 3, 해당 값은 숫자로 변환 불가한 문자(스페이스바) -> 예외 발생 체크
    @Test
    void inputTest4(){
        assertSimpleTest(()->
                assertThatThrownBy(() -> runException("   "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    // 잘못된 재시작 선택 입력값 예외 검증 테스트 - 문자가 1 또는 2가 아님, 해당 값은 숫자로 변환 불가한 문자 -> 예외 발생 체크
    @Test
    void selectTest1(){
        assertRandomNumberInRangeTest(
                () -> {
                    assertThrows(IllegalArgumentException.class, () -> run("246", "135", "notNumber"));
                },
                1, 3, 5, 5, 8, 9
        );
    }


    // 잘못된 재시작 선택 입력값 예외 검증 테스트 - 문자가 1 또는 2가 아님, 해당 값은 숫자로 변환 가능한 문자 -> 예외 발생 체크
    @Test
    void selectTest2(){
        assertRandomNumberInRangeTest(
                () -> {
                    assertThrows(IllegalArgumentException.class, () -> run("246", "135", "5"));
                },
                1, 3, 5, 5, 8, 9
        );
    }




    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}