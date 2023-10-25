package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    //바뀔수있는부분은 유저쪽이기에 테스트코드도 유저쪽을 작성해야할것같다
    //입력길이,재시작,0확인,문자입력,중복숫자확인
    @Test
    @DisplayName("문자열에서 리스트로 변환 테스트")
    void 입력한_문자열_리스트로_변환() {
        //Given
        User user = new User();

        //When
        String testNumber = "123";
        List<Integer> testList = Arrays.asList(1, 2, 3);

        //Then
        Assertions.assertEquals(user.makeListNumber(testNumber), testList);
    }

    @Test
    @DisplayName("입력한 숫자 중 중복 숫자 확인 테스트")
    void 입력한_숫자_중복확인() {
        //Given
        User user = new User();

        //Then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            //when
            user.makeListNumber("112");
        });


    }

    @Test
    @DisplayName("입력한 숫자의 길이 확인 테스트")
    void 입력한_숫자_길이확인() {
        //Given
        User user = new User();

        //Then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            //when
            user.makeListNumber("1234");
        });

    }

    @Test
    @DisplayName("입력한 숫자 중 0이 있는지 확인")
    void 입력한_숫자중_0유무_확인() {
        //Given
        User user = new User();

        //Then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            //when
            user.makeListNumber("012");
        });

    }

    @Test
    @DisplayName("문자를 입력했을 때 오류 확인")
    void 입력한_숫자중_문자_확인() {
        //Given
        User user = new User();

        //Then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            //when
            user.makeListNumber("abc");
        });
    }

    @Test
    @DisplayName("재시작시 입력 오류 확인")
    void 재시작시_입력문자_확인() {
        //Given
        User user = new User();

        //then
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            //when
            user.makeListNumber("3");
        });
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
