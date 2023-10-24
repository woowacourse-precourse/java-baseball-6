package baseball;

import baseball.controller.BaseballController;
import baseball.vo.enums.GameRule;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class ApplicationTest extends NsTest {
    @Test
    @Disabled
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

//    @Test
    @DisplayName("랜덤_숫자_세자리_생성_테스트")
    @RepeatedTest(value = 10, name = "{displayName}, {currentRepetition} of {totalRepetitions}")
    void createThreeRandomNumbers(RepetitionInfo repetitionInfo) {
//        System.out.println("랜덤_숫자_세자리_생성_테스트 " + repetitionInfo.getCurrentRepetition() + " / " +
//                repetitionInfo.getTotalRepetitions());
        // give
        final BaseballController baseballController = BaseballController.getInstance();
        baseballController.createNewBaseballGameNumberList();
        // when
        final List<Integer> baseballGameNumberList = baseballController.getComputerBaseballGameNumberList();
        // then
        assertAll(
            // 1. 랜덤하게 생성된 숫자의 길이가 3자리
                () -> assertThat(baseballGameNumberList.size()).isEqualTo(GameRule.GAME_NUMBER_LEN.getValue()),
            // 2. 랜덤하게 생성된 숫자들에서 중복된 값이 없음
                () -> assertThat(baseballGameNumberList.stream().distinct().collect(Collectors.toList()).size())
                        .isEqualTo(GameRule.GAME_NUMBER_LEN.getValue())
        );
    }


    @DisplayName("게임시작_시_생성된_숫자의_중복_테스트")
    @RepeatedTest(value = 10, name = "{displayName}, {currentRepetition} of {totalRepetitions}")
    void testDuplicateNumbersOnGameStartWithThreeRandomNumbers() {
        // give
        final BaseballController baseballController = BaseballController.getInstance();
        baseballController.createNewBaseballGameNumberList();
        final List<Integer> baseballGameNumberList = baseballController.getComputerBaseballGameNumberList();
        // when
        final Set<Integer> baseballGameNumberSet = new HashSet<>(baseballGameNumberList);
        // then
        assertAll(
                // 1. Set을 사용하여 중복을 제거한 뒤 사이즈 비교
                () -> assertThat(baseballGameNumberList.size()).isEqualTo(baseballGameNumberSet.size()),
                // 2. 랜덤하게 생성된 숫자들에서 중복된 값이 없음
                () -> assertThat(baseballGameNumberList.stream().distinct().collect(Collectors.toList()).size())
                        .isEqualTo(GameRule.GAME_NUMBER_LEN.getValue())
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
