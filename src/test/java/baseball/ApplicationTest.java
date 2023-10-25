package baseball;

import baseball.controller.BaseballController;
import baseball.service.OperatorService;
import baseball.vo.enums.GameRule;
import baseball.vo.enums.UserInterfaceMessage;
import baseball.vo.enums.ValidationMessage;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
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


    @Test
    void UserInterfaceMessage_메시지_확인_테스트() {
        // give
        final String gameStartMessage =
                "야구게임에 오신 것을 환영합니다.\n야구게임은 숫자 3개를 입력받습니다.\n만약 종료를 원하시면 2를 입력하세요 ";
        // when
        final String gameStartMessageEnum = UserInterfaceMessage.GAME_INFO.getValue();
        // then
        assertThat(gameStartMessage).isEqualTo(gameStartMessageEnum);
    }

    @Test
    void ValidationMessage_메시지_확인_테스트() {
        // give
        final String properTypeMessage = "바르게 입력되었습니다.";
        // when
        final String properTypeMessageEnum = ValidationMessage.PROPER_TYPE.getValue();
        // then
        assertThat(properTypeMessage).contains(properTypeMessageEnum);
    }

    @Test
    void 게임_참여자의_null값_입력_예외_테스트() {
        final String userInput = null;
        assertThatThrownBy(() -> OperatorService.getInstance().validateGameNumber(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ValidationMessage.NULL_TYPE.getValue());
    }

    @Test
    void 게임_참여자의_empty_string값_입력_예외_테스트() {
        final String userInput = "";
        assertThatThrownBy(() -> OperatorService.getInstance().validateGameNumber(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ValidationMessage.EMPTY_TYPE.getValue());
    }

    @Test
    void 게임_참여자의_0_입력_예외_테스트() {
        final String userInput = "0";
        assertThatThrownBy(() -> OperatorService.getInstance().validateGameNumber(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ValidationMessage.ZERO_TYPE.getValue());
    }

    @DisplayName("숫자로_변환될_수_없는_값_입력_예외_테스트")
    @ParameterizedTest(name = "{index}. {displayName} - userInput parameter: {0}")
    @ValueSource(strings = {"abc", "가나다", "ab1"})
    void 숫자로_변환될_수_없는_값_입력_예외_테스트(final String userInput) {
        assertThatThrownBy(() -> OperatorService.getInstance().validateGameNumber(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ValidationMessage.NOT_NUMBER.getValue());
    }

    @DisplayName("게임_참여자의_3자리_미만_입력_예외_테스트")
    @ParameterizedTest(name = "{index}. {displayName} - userInput parameter: {0}")
    @ValueSource(strings = {"13", "1", "00", "11"})
    void 게임_참여자의_3자리_미만_입력_예외_테스트(final String userInput) {
        assertThatThrownBy(() -> OperatorService.getInstance().validateGameNumber(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ValidationMessage.UNDER_THREE.getValue());
    }

    @DisplayName("게임_참여자의_3자리_초과_입력_예외_테스트")
    @ParameterizedTest(name = "{index}. {displayName} - userInput parameter: {0}")
    @ValueSource(strings = {"1234", "12345", "1987"})
    void 게임_참여자의_3자리_초과_입력_예외_테스트(final String userInput) {
        assertThatThrownBy(() -> OperatorService.getInstance().validateGameNumber(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ValidationMessage.OVER_THREE.getValue());
    }

    @DisplayName("게임_참여자의_게임_중복_숫자값_입력_예외_테스트")
    @ParameterizedTest(name = "{index}. {displayName} - userInput parameter: {0}")
    @ValueSource(strings = {"122", "223", "338"})
    void 게임_참여자의_게임_중복_숫자값_입력_예외_테스트(final String userInput) {
        assertThatThrownBy(() -> OperatorService.getInstance().validateGameNumber(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ValidationMessage.NOT_DUPLICATE_NUMBER.getValue());
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
