package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @Test
    @DisplayName("스트라이크 개수 테스트")
    void 스트라이크_개수_테스트() {
        List<Integer> userInput1 = Arrays.asList(1, 2, 3);
        List<Integer> userInput2 = Arrays.asList(4, 7, 8);
        List<Integer> userInput3 = Arrays.asList(4, 2, 6);
        List<Integer> userInput4 = Arrays.asList(4, 5, 6);
        List<Integer> result = Arrays.asList(4, 5, 6);

        assertThat(Application.getStrikeCount(userInput1, result)).isEqualTo(0);
        assertThat(Application.getStrikeCount(userInput2, result)).isEqualTo(1);
        assertThat(Application.getStrikeCount(userInput3, result)).isEqualTo(2);
        assertThat(Application.getStrikeCount(userInput4, result)).isEqualTo(3);
    }

    @Test
    @DisplayName("볼 개수 테스트")
    void 볼_개수_테스트() {
        List<Integer> userInput1 = Arrays.asList(1, 2, 3);
        List<Integer> userInput2 = Arrays.asList(7, 4, 8);
        List<Integer> userInput3 = Arrays.asList(5, 6, 7);
        List<Integer> userInput4 = Arrays.asList(6, 4, 5);
        List<Integer> result = Arrays.asList(4, 5, 6);

        assertThat(Application.getBallCount(userInput1, result)).isEqualTo(0);
        assertThat(Application.getBallCount(userInput2, result)).isEqualTo(1);
        assertThat(Application.getBallCount(userInput3, result)).isEqualTo(2);
        assertThat(Application.getBallCount(userInput4, result)).isEqualTo(3);
    }

    @Test
    @DisplayName("문자열 리스트로 변경 테스트")
    void 문자열_리스트로_변경_테스트() {
        String number = "123";

        List<Integer> numberList = Application.changeStringToList(number);

        assertThat(numberList.get(0)).isEqualTo(1);
        assertThat(numberList.get(1)).isEqualTo(2);
        assertThat(numberList.get(2)).isEqualTo(3);
    }

    @Test
    @DisplayName("입력 확인 테스트")
    void 입력_확인_테스트() {
        String userInput = "456";
        List<Integer> result = Arrays.asList(4, 5, 6);
        String notThreeNumber = "1234";
        String notDigitNumber = "s14de7";
        String notRightRangeNumber = "083";
        String notDifferentNumber = "113";

        assertThat(Application.inputBaseball(userInput)).isEqualTo(result);
        assertThatThrownBy(() -> Application.inputBaseball(notThreeNumber))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Application.inputBaseball(notDigitNumber))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Application.inputBaseball(notRightRangeNumber))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Application.inputBaseball(notDifferentNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("재시작 종료 확인 테스트")
    void 재시작_종료_확인_테스트() {
        String one = "1";
        String two = "2";
        String notRightLength = "12";
        String notDigitNumber = "a12b";
        String notOneOrTwoNumber = "3";

        assertThat(Application.inputStartOrEnd(one)).isEqualTo(1);
        assertThat(Application.inputStartOrEnd(two)).isEqualTo(2);
        assertThatThrownBy(() -> Application.inputStartOrEnd(notRightLength))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Application.inputStartOrEnd(notDigitNumber))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Application.inputStartOrEnd(notOneOrTwoNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력 1또는 2인지 테스트")
    void 입력_1또는_2인지_테스트() {
        String one = "1";
        String two = "2";
        String three = "3";

        assertThat(Application.isOneOrTwo(one)).isEqualTo(true);
        assertThat(Application.isOneOrTwo(two)).isEqualTo(true);
        assertThatThrownBy(() -> Application.isOneOrTwo(three))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("길이 맞는지 테스트")
    void 길이_맞는지_테스트() {
        String threeNumber = "123";
        String notThreeNumber = "1234";

        assertThat(Application.isRightLength(threeNumber, 3)).isEqualTo(true);
        assertThatThrownBy(() -> Application.isRightLength(notThreeNumber, 3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("문자열 숫자인지 테스트")
    void 문자열_숫자인지_테스트() {
        String digitNumber = "135";
        String notDigitNumber = "s14de7";

        assertThat(Application.isDigitNumber(digitNumber)).isEqualTo(true);
        assertThatThrownBy(() -> Application.isDigitNumber(notDigitNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("범위 맞는 숫자 테스트")
    void 범위_맞는_숫자_테스트() {
        String rightRangeNumber = "183";
        String notRightRangeNumber = "083";

        assertThat(Application.isRightRangeNumber(rightRangeNumber)).isEqualTo(true);
        assertThatThrownBy(() -> Application.isRightRangeNumber(notRightRangeNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("서로 다른 숫자 테스트")
    void 서로_다른_숫자_테스트() {
        String differentNumber = "183";
        String notDifferentNumber = "113";

        assertThat(Application.isDifferentNumber(differentNumber)).isEqualTo(true);
        assertThatThrownBy(() -> Application.isDifferentNumber(notDifferentNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("서로 다른 랜덤숫자 테스트")
    void 서로_다른_랜덤숫자_테스트() {
        List<Integer> threeRandomNumber = Application.getThreeRandomNumber();
        String threeRandomNumberString = "";

        for (int i = 0; i < threeRandomNumber.size(); i++) {
            threeRandomNumberString += Integer.toString(threeRandomNumber.get(i));
        }

        boolean lengthThree = Application.isRightLength(threeRandomNumberString, 3);
        boolean digitNumber = Application.isDigitNumber(threeRandomNumberString);
        boolean rightRangeNumber = Application.isRightRangeNumber(threeRandomNumberString);
        boolean differentNumber = Application.isDifferentNumber(threeRandomNumberString);

        assertThat(lengthThree).isEqualTo(true);
        assertThat(digitNumber).isEqualTo(true);
        assertThat(rightRangeNumber).isEqualTo(true);
        assertThat(differentNumber).isEqualTo(true);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
