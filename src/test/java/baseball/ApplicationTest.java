package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

import baseball.domain.BaseballNumber;
import baseball.domain.BaseballScore;
import baseball.service.BaseballService;
import baseball.util.Util;
import baseball.validator.Validator;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void initializeComputerNumber_유효성테스트() {
        //given
        BaseballService baseballService = new BaseballService();
        //when

        Throwable thrown = catchThrowable(() -> baseballService.initializeComputerNumber());
        //then
        assertThat(thrown).as("initializeComputerNumber_테스트").doesNotThrowAnyException();
    }

    @Test
    void 숫자의_개수가_3개이상_입력_예외() {
        BaseballService baseballService = new BaseballService();
        //given
        String input = "1234";

        //when
        //then
        assertThatThrownBy(() -> baseballService.initializeUserNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력의 길이는 3이어야합니다.");
    }

    @Test
    void 중복된_숫자가_들어왔을때_예외() {
        //given
        BaseballService baseballService = new BaseballService();
        String input = "484";
        //when
        //then
        assertThatThrownBy(() -> baseballService.initializeUserNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("모든 입력된 값은 달라야합니다.");
    }

    @Test
    void initializeUserNumber_유효성테스트() {
        //initializeUserNumber메서드의 주기능이되는 BaseballNumber의 생성자를 테스트
        //given
        BaseballService baseballService = new BaseballService();

        String str1 = "123";
        String str2 = "456";
        String str3 = "789";
        //when
        final Throwable thrown1 = catchThrowable(() -> baseballService.initializeUserNumber(str1));
        final Throwable thrown2 = catchThrowable(() -> baseballService.initializeUserNumber(str2));
        final Throwable thrown3 = catchThrowable(() -> baseballService.initializeUserNumber(str3));

        //then
        assertThat(thrown1).as("initializeUserNumber_테스트").doesNotThrowAnyException();
        assertThat(thrown2).as("initializeUserNumber_테스트").doesNotThrowAnyException();
        assertThat(thrown3).as("initializeUserNumber_테스트").doesNotThrowAnyException();
    }

    @Test
    void 사용자_입력이_숫자가_아닐때() {
        //given
        BaseballService baseballService = new BaseballService();
        String str1 = "asdf";
        String str2 = "qwer";
        String str3 = "zxcv";
        //when
        final Throwable thrown1 = catchThrowable(() -> baseballService.initializeUserNumber(str1));
        final Throwable thrown2 = catchThrowable(() -> baseballService.initializeUserNumber(str2));
        final Throwable thrown3 = catchThrowable(() -> baseballService.initializeUserNumber(str3));

        //then
        assertThat(thrown1).as("initializeUserNumber_테스트").isInstanceOf(IllegalArgumentException.class);
        assertThat(thrown2).as("initializeUserNumber_테스트").isInstanceOf(IllegalArgumentException.class);
        assertThat(thrown3).as("initializeUserNumber_테스트").isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void compareNumber_테스트() {
        //given
        //3스트라이크
        BaseballNumber computer1 = new BaseballNumber("123");
        BaseballNumber user1 = new BaseballNumber("123");
        //3스트라이크
        BaseballNumber computer2 = new BaseballNumber("123");
        BaseballNumber user2 = new BaseballNumber("123");
        //2볼 1스트라이크
        BaseballNumber computer3 = new BaseballNumber("456");
        BaseballNumber user3 = new BaseballNumber("465");
        //2볼 1스트라이크
        BaseballNumber computer4 = new BaseballNumber("789");
        BaseballNumber user4 = new BaseballNumber("879");
        //when
        BaseballScore resultBaseballScore1 = BaseballNumber.compareNumber(computer1, user1);
        BaseballScore resultBaseballScore2 = BaseballNumber.compareNumber(computer2, user2);
        BaseballScore resultBaseballScore3 = BaseballNumber.compareNumber(computer3, user3);
        BaseballScore resultBaseballScore4 = BaseballNumber.compareNumber(computer4, user4);
        boolean result1 = BaseballScore.isBaseballScoreEqual(resultBaseballScore1, resultBaseballScore2);
        boolean result2 = BaseballScore.isBaseballScoreEqual(resultBaseballScore3, resultBaseballScore4);
        //then
        assertThat(result1).isEqualTo(true);
        assertThat(result2).isEqualTo(true);
    }

    @Test
    void validateStringIsNaturalNumber_문자열이_자연수가_아니라면_예외발생() {
        //given
        String string1 = "123";
        String string2 = "abc";
        String string3 = "123a";
        //when
        Throwable throwable1 = catchThrowable(
                () -> Validator.validateStringIsNaturalNumber(string1, "문자열이 자연수로 이루어지지 않았습니다"));
        Throwable throwable2 = catchThrowable(
                () -> Validator.validateStringIsNaturalNumber(string2, "문자열이 자연수로 이루어지지 않았습니다"));
        Throwable throwable3 = catchThrowable(
                () -> Validator.validateStringIsNaturalNumber(string3, "문자열이 자연수로 이루어지지 않았습니다"));
        //then
        assertThat(throwable1).as("자연수일때").doesNotThrowAnyException();
        assertThat(throwable2).as("자연수가 아닐때").isInstanceOf(IllegalArgumentException.class);
        assertThat(throwable3).as("문자가 섞여있을때").isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateStringHasNot_문자열이_특정문자를_갖고있다면_예외발생() {
        //given
        String testString1 = "abcdef";
        String testString2 = "123456";
        String testString3 = "안녕하세요";
        String notContainsString1 = "a";
        String notContainsString2 = "6";
        String notContainsString3 = "A";
        //when
        Throwable throwable1 = catchThrowable(
                () -> Validator.validateStringHasNot(notContainsString1, testString1, "문자열이 특정 문자를 갖고있습니다."));
        Throwable throwable2 = catchThrowable(
                () -> Validator.validateStringHasNot(notContainsString2, testString2, "문자열이 특정 문자를 갖고있습니다."));
        Throwable throwable3 = catchThrowable(
                () -> Validator.validateStringHasNot(notContainsString3, testString3, "문자열이 특정 문자를 갖고있습니다."));
        //then
        assertThat(throwable1).as("특정 문자를 갖고있을때").isInstanceOf(IllegalArgumentException.class);
        assertThat(throwable2).as("특정 문자를 갖고있을때").isInstanceOf(IllegalArgumentException.class);
        assertThat(throwable3).as("특정 문자를 갖고있지 않을때").doesNotThrowAnyException();
    }

    @Test
    void validateStringLength_문자열이_주어진_길이가_아닐때_예외발생() {
        //given
        String testString1 = "abc";
        String testString2 = "abcd";
        int length1 = 4;
        int length2 = 4;
        //when
        Throwable throwable1 = catchThrowable(
                () -> Validator.validateStringLength(length1, testString1, "문자열이 주어진 길이와 다릅니다."));
        Throwable throwable2 = catchThrowable(
                () -> Validator.validateStringLength(length2, testString2, "문자열이 주어진 길이와 다릅니다."));
        //then
        assertThat(throwable1).as("주어진 길이가 다를때").isInstanceOf(IllegalArgumentException.class);
        assertThat(throwable2).as("주어진 길이와 같을때").doesNotThrowAnyException();
    }

    @Test
    void validateStringAllDifferent_문자열이_중복되는_문자를_갖고있을때_예외발생() {
        //given
        String testString1 = "abcc";
        String testString2 = "abc";
        //when
        Throwable throwable1 = catchThrowable(
                () -> Validator.validateStringAllDifferent(testString1, "문자열이 중복되는 문자를 갖고있습니다."));
        Throwable throwable2 = catchThrowable(
                () -> Validator.validateStringAllDifferent(testString2, "문자열이 중복되는 문자를 갖고있습니다."));
        //then
        assertThat(throwable1).as("중복되는 문자를 갖고있을때").isInstanceOf(IllegalArgumentException.class);
        assertThat(throwable2).as("중복되는 문자를 갖고있지 않을때").doesNotThrowAnyException();
    }

    @Test
    void validateStringIsOneOrTwo_문자열이_1이나_2가_아닐때_예외발생() {
        //given
        String testString1 = "1";
        String testString2 = "2";
        String testString3 = "3";
        String testString4 = "a";
        //when
        Throwable throwable1 = catchThrowable(
                () -> Validator.validateStringIsOneOrTwo(testString1));
        Throwable throwable2 = catchThrowable(
                () -> Validator.validateStringIsOneOrTwo(testString2));
        Throwable throwable3 = catchThrowable(
                () -> Validator.validateStringIsOneOrTwo(testString3));
        Throwable throwable4 = catchThrowable(
                () -> Validator.validateStringIsOneOrTwo(testString4));
        //then
        assertThat(throwable1).as("문자열이 1이나 2 일때").doesNotThrowAnyException();
        assertThat(throwable2).as("문자열이 1이나 2 일때").doesNotThrowAnyException();
        assertThat(throwable3).as("문자열이 1이나 2가 아닐때").isInstanceOf(IllegalArgumentException.class);
        assertThat(throwable4).as("문자열이 1이나 2가 아닐때").isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void stringToIntegerList_문자열을_IntegerList로_변경_IntegerList로변환() {
        //given
        String testString1 = "12345";
        String testString2 = "abcde";
        List<Integer> expectList = new ArrayList(Arrays.asList(1, 2, 3, 4, 5));
        //when
        List<Integer> resultList = Util.naturalNumberstringToIntegerList(testString1);
        Throwable throwable = catchThrowable(
                () -> Util.naturalNumberstringToIntegerList(testString2));
        //then
        assertThat(resultList).isEqualTo(expectList);
        assertThat(throwable).as("문자열이 자연수로 이루어지지 않았을때").isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void countSameValueSameIdxByIntegerLists_Integer리스트들_사이에_값이같고_인덱스도_같은_수의_개수_개수리턴() {
        //given
        List<Integer> testList1 = new ArrayList(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> testList2 = new ArrayList(Arrays.asList(1, 2, 3, 1, 2));
        int expectCount1 = 3;
        List<Integer> testList3 = new ArrayList(Arrays.asList(5, 6, 7, 8, 9));
        List<Integer> testList4 = new ArrayList(Arrays.asList(1, 6, 7, 9));
        int expectCount2 = 2;
        //when
        int resultCount1 = Util.countSameValueSameIdxByIntegerLists(testList1, testList2);
        int resultCount2 = Util.countSameValueSameIdxByIntegerLists(testList3, testList4);
        //then
        assertThat(resultCount1).isEqualTo(expectCount1);
        assertThat(resultCount2).isEqualTo(expectCount2);
    }

    @Test
    void countSameValueDifferentIdxByIntegerList_Integer리스트들_사이에_값이같고_인덱스는_다른_수의_개수_개수리턴() {
        //given
        List<Integer> testList1 = new ArrayList(Arrays.asList(1, 2, 3));
        List<Integer> testList2 = new ArrayList(Arrays.asList(1, 3, 2));
        int expectCount1 = 2;
        List<Integer> testList3 = new ArrayList(Arrays.asList(5, 6, 7, 8, 9));
        List<Integer> testList4 = new ArrayList(Arrays.asList(5, 6, 8, 7, 9));
        int expectCount2 = 2;
        //when
        int resultCount1 = Util.countSameValueDifferentIdxByIntegerLists(testList1, testList2);
        int resultCount2 = Util.countSameValueDifferentIdxByIntegerLists(testList3, testList4);
        //then
        assertThat(resultCount1).isEqualTo(expectCount1);
        assertThat(resultCount2).isEqualTo(expectCount2);
    }

    //initializeComputerNumber메서드를 테스트할 방법은?
    @Test
    void isContinueGame_문자열이_1이라면_참을_2라면_거짓을_리턴() {
        //given
        String testString1 = "1";
        String testString2 = "2";
        BaseballService baseballService = new BaseballService();
        boolean expectBoolean1 = true;
        boolean expectBoolean2 = false;
        //when
        boolean result1 = baseballService.isContinueGame(testString1);
        boolean result2 = baseballService.isContinueGame(testString2);
        //then
        assertThat(result1).isEqualTo(expectBoolean1);
        assertThat(result2).isEqualTo(expectBoolean2);
    }

    @Test
    void compareBaseballNumber_BaseballNumber값들의_비교로_알맞은_BaseballCount_리턴() {
        //given
        BaseballNumber baseballNumber1 = new BaseballNumber("123");
        BaseballNumber baseballNumber2 = new BaseballNumber("325");
        BaseballScore expectBaseballScore1 = new BaseballScore(1, 1);
        BaseballScore expectBaseballScore2 = new BaseballScore(0, 2);
        BaseballScore resultBaseballScore = BaseballNumber.compareNumber(baseballNumber1, baseballNumber2);

        //when
        boolean isBaseballScoreEqual1 = BaseballScore.isBaseballScoreEqual(expectBaseballScore1, resultBaseballScore);
        boolean isBaseballScoreEqual2 = BaseballScore.isBaseballScoreEqual(expectBaseballScore2, resultBaseballScore);
        //then
        assertThat(isBaseballScoreEqual1).isTrue();
        assertThat(isBaseballScoreEqual2).isFalse();
    }

    @Test
    void 출력문테스트() {
        System.out.println("안녕하세요");
        assertThat(output()).contains("안녕");
        assertThat(output()).doesNotContain("안녕해");
    }

    @Test
    void compareBaseballNumber_출력문을_사용해서_BaseballNumber값들의_비교로_알맞은_BaseballCount_리턴() {
        //given
        BaseballNumber baseballNumber1 = new BaseballNumber("123");
        BaseballNumber baseballNumber2 = new BaseballNumber("325");
        BaseballScore expectBaseballScore1 = new BaseballScore(1, 1);
        String expectOutput1 = "1볼 1스트라이크";
        String expectOutput2 = "2스트라이크";
        BaseballScore resultBaseballScore = BaseballNumber.compareNumber(baseballNumber1, baseballNumber2);
        //when
        resultBaseballScore.showBaseballScore();
        //then
        assertThat(output()).contains(expectOutput1);
        assertThat(output()).doesNotContain(expectOutput2);
    }
//BaseballService까지 테스트 코드 진행


}
