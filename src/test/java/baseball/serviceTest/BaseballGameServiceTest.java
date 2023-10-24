package baseball.serviceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import baseball.service.BaseballGameService;
import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BaseballGameServiceTest {

    private BaseballGameService baseballGameService;

    @BeforeEach
    public void generateBaseballService() {
        baseballGameService = new BaseballGameService();
    }

    @Test
    void 결과상태_초기화_테스트() {
        //given
        HashMap<String, Integer> testResult = new HashMap<>();
        testResult.put("BALL", 0);
        testResult.put("STRIKE", 0);

        //when
        baseballGameService.initUserResult();

        //then
        assertThat(baseballGameService.getUserResult()).isEqualTo(testResult);
    }

    @Test
    void 스트라이크3개_결과_판단_테스트() {

        HashMap<String, Integer> testResult = new HashMap<>();
        testResult.put("BALL", 0);
        testResult.put("STRIKE", 3);

        baseballGameService.initUserResult();
        String computerNum = "123";
        String inputNum = "123";

        HashMap<String, Integer> userResult = baseballGameService.judgeResult(inputNum, computerNum);

        assertThat(testResult).isEqualTo(userResult);

    }

    @Test
    void 스트라이크2개_결과_판단_테스트() {

        HashMap<String, Integer> testResult = new HashMap<>();
        testResult.put("BALL", 0);
        testResult.put("STRIKE", 2);

        baseballGameService.initUserResult();
        String computerNum = "123";
        String inputNum = "129";

        HashMap<String, Integer> userResult = baseballGameService.judgeResult(inputNum, computerNum);

        assertThat(testResult).isEqualTo(userResult);

    }

    @Test
    void 스트라이크1개_결과_판단_테스트() {

        HashMap<String, Integer> testResult = new HashMap<>();
        testResult.put("BALL", 0);
        testResult.put("STRIKE", 1);

        baseballGameService.initUserResult();
        String computerNum = "123";
        String inputNum = "146";

        HashMap<String, Integer> userResult = baseballGameService.judgeResult(inputNum, computerNum);

        assertThat(testResult).isEqualTo(userResult);

    }

    @Test
    void 볼1개_결과_판단_테스트() {

        HashMap<String, Integer> testResult = new HashMap<>();
        testResult.put("BALL", 1);
        testResult.put("STRIKE", 0);

        baseballGameService.initUserResult();
        String computerNum = "123";
        String inputNum = "451";

        HashMap<String, Integer> userResult = baseballGameService.judgeResult(inputNum, computerNum);

        assertThat(testResult).isEqualTo(userResult);

    }

    @Test
    void 볼2개_결과_판단_테스트() {

        HashMap<String, Integer> testResult = new HashMap<>();
        testResult.put("BALL", 2);
        testResult.put("STRIKE", 0);

        baseballGameService.initUserResult();
        String computerNum = "123";
        String inputNum = "351";

        HashMap<String, Integer> userResult = baseballGameService.judgeResult(inputNum, computerNum);

        assertThat(testResult).isEqualTo(userResult);

    }

    @Test
    void 볼3개_결과_판단_테스트() {

        HashMap<String, Integer> testResult = new HashMap<>();
        testResult.put("BALL", 3);
        testResult.put("STRIKE", 0);

        baseballGameService.initUserResult();
        String computerNum = "123";
        String inputNum = "231";

        HashMap<String, Integer> userResult = baseballGameService.judgeResult(inputNum, computerNum);

        assertThat(testResult).isEqualTo(userResult);

    }

    @Test
    void 스트라이크1개_볼1개_결과_판단_테스트() {

        HashMap<String, Integer> testResult = new HashMap<>();
        testResult.put("BALL", 1);
        testResult.put("STRIKE", 1);

        baseballGameService.initUserResult();
        String computerNum = "123";
        String inputNum = "421";

        HashMap<String, Integer> userResult = baseballGameService.judgeResult(inputNum, computerNum);

        assertThat(testResult).isEqualTo(userResult);

    }

    @Test
    void 스트라이크1개_볼2개_결과_판단_테스트() {

        HashMap<String, Integer> testResult = new HashMap<>();
        testResult.put("BALL", 2);
        testResult.put("STRIKE", 1);

        baseballGameService.initUserResult();
        String computerNum = "123";
        String inputNum = "132";

        HashMap<String, Integer> userResult = baseballGameService.judgeResult(inputNum, computerNum);

        assertThat(testResult).isEqualTo(userResult);

    }

    @Test
    void 낫싱_결과_판단_테스트() {

        HashMap<String, Integer> testResult = new HashMap<>();
        testResult.put("BALL", 0);
        testResult.put("STRIKE", 0);

        baseballGameService.initUserResult();
        String computerNum = "123";
        String inputNum = "456";

        HashMap<String, Integer> userResult = baseballGameService.judgeResult(inputNum, computerNum);

        assertThat(testResult).isEqualTo(userResult);

    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "345", "985"})
    void 게임숫자_올바른지_판단(String num) {
        assertThatCode(() -> baseballGameService.judgeCorrectNum(num))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234", "122432", "12123123"})
    void 게임숫자_3자리보다_큰_수_예외처리(String num) {

        assertThat(baseballGameService.checkNumLength(num)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"avs", "1sd2", "@#"})
    void 게임숫자_숫자가_아닌_수_예외처리(String num) {

        assertThat(baseballGameService.checkNumDigit(num)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"012", "104", "980"})
    void 게임숫자_0을_포함하는_수_예외처리(String num) {

        assertThat(baseballGameService.checkNumZero(num)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"122", "998", "777"})
    void 게임숫자_같은수를_포함하는_수_예외처리(String num) {

        assertThat(baseballGameService.checkNumDiffernt(num)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    void 재시작_숫자가_올바른지_판단(String num) {
        assertThatCode(() -> baseballGameService.judgeCorrectRestartNum(num))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"3", "9", "a"})
    void 재시작_숫자_예외처리(String num) {
        assertThatCode(() -> baseballGameService.judgeCorrectRestartNum(num));
    }
}
