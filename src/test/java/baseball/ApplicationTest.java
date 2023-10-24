package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.AbstractThrowableAssert;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    void set_different_numbers_테스트(){
        final int[] OPPONENT_NUM = Set_Different_Number.set_different_numbers(3);
        assertThat(OPPONENT_NUM.length)
                .as("길이 검사")
                .isEqualTo(3);
        for (int digit : OPPONENT_NUM) {
            assertThat(digit).as("컴퓨터 랜덤 숫자 리스트 요소 범위 검사").isBetween(1, 9);
        }
    }

    @Test
    void count_correct_num_spot_테스트(){
        final int[] firstcase1 = {1,2,3}, secondcase1 = {9,8,7};    //0스트라이크
        final int[] firstcase2 = {1,2,3}, secondcase2 = {1,8,7};    //1스트라이크
        final int[] firstcase3 = {1,2,3}, secondcase3 = {9,2,7};    //1스트라이크
        final int[] firstcase4 = {1,2,3}, secondcase4 = {9,8,3};    //1스트라이크
        final int[] firstcase5 = {1,2,3}, secondcase5 = {1,2,7};    //2스트라이크
        final int[] firstcase6 = {1,2,3}, secondcase6 = {9,2,3};    //2스트라이크
        final int[] firstcase7 = {1,2,3}, secondcase7 = {1,8,3};    //2스트라이크
        final int[] firstcase8 = {1,2,3}, secondcase8 = {1,2,3};    //3스트라이크

        final int result1 = Multi_Numeric_Comparator.count_correct_num_spot(firstcase1,secondcase1);
        final int result2 = Multi_Numeric_Comparator.count_correct_num_spot(firstcase2,secondcase2);
        final int result3 = Multi_Numeric_Comparator.count_correct_num_spot(firstcase3,secondcase3);
        final int result4 = Multi_Numeric_Comparator.count_correct_num_spot(firstcase4,secondcase4);
        final int result5 = Multi_Numeric_Comparator.count_correct_num_spot(firstcase5,secondcase5);
        final int result6 = Multi_Numeric_Comparator.count_correct_num_spot(firstcase6,secondcase6);
        final int result7 = Multi_Numeric_Comparator.count_correct_num_spot(firstcase7,secondcase7);
        final int result8 = Multi_Numeric_Comparator.count_correct_num_spot(firstcase8,secondcase8);

        assertThat(result1).as("스트라이크 개수 테스트").isEqualTo(0);
        assertThat(result2).as("스트라이크 개수 테스트").isEqualTo(1);
        assertThat(result3).as("스트라이크 개수 테스트").isEqualTo(1);
        assertThat(result4).as("스트라이크 개수 테스트").isEqualTo(1);
        assertThat(result5).as("스트라이크 개수 테스트").isEqualTo(2);
        assertThat(result6).as("스트라이크 개수 테스트").isEqualTo(2);
        assertThat(result7).as("스트라이크 개수 테스트").isEqualTo(2);
        assertThat(result8).as("스트라이크 개수 테스트").isEqualTo(3);
    }

    @Test
    void count_right_num_wrong_spot_테스트(){
        final int[] firstcase1 = {1,2,3}, secondcase1 = {9,8,7};      //0볼
        final int[] firstcase2 = {1,2,3}, secondcase2 = {9,1,7};      //1볼
        final int[] firstcase3 = {1,2,3}, secondcase3 = {9,8,1};      //1볼
        final int[] firstcase4 = {1,2,3}, secondcase4 = {2,8,7};      //1볼
        final int[] firstcase5 = {1,2,3}, secondcase5 = {9,8,2};      //1볼
        final int[] firstcase6 = {1,2,3}, secondcase6 = {3,8,7};      //1볼
        final int[] firstcase7 = {1,2,3}, secondcase7 = {9,3,7};      //1볼
        final int[] firstcase8 = {1,2,3}, secondcase8 = {9,1,2};      //2볼
        final int[] firstcase9 = {1,2,3}, secondcase9 = {2,1,7};      //2볼
        final int[] firstcase10 = {1,2,3}, secondcase10 = {2,8,1};    //2볼
        final int[] firstcase11 = {1,2,3}, secondcase11 = {9,3,2};    //2볼
        final int[] firstcase12 = {1,2,3}, secondcase12 = {2,3,7};    //2볼
        final int[] firstcase13 = {1,2,3}, secondcase13 = {3,8,2};    //2볼
        final int[] firstcase14 = {1,2,3}, secondcase14 = {3,1,7};    //2볼
        final int[] firstcase15 = {1,2,3}, secondcase15 = {3,8,1};    //2볼
        final int[] firstcase16 = {1,2,3}, secondcase16 = {9,3,1};    //2볼
        final int[] firstcase17 = {1,2,3}, secondcase17 = {2,3,1};    //3볼
        final int[] firstcase18 = {1,2,3}, secondcase18 = {3,1,2};    //3볼

        final int result1 = Multi_Numeric_Comparator.count_right_num_wrong_spot(firstcase1,secondcase1);
        final int result2 = Multi_Numeric_Comparator.count_right_num_wrong_spot(firstcase2,secondcase2);
        final int result3 = Multi_Numeric_Comparator.count_right_num_wrong_spot(firstcase3,secondcase3);
        final int result4 = Multi_Numeric_Comparator.count_right_num_wrong_spot(firstcase4,secondcase4);
        final int result5 = Multi_Numeric_Comparator.count_right_num_wrong_spot(firstcase5,secondcase5);
        final int result6 = Multi_Numeric_Comparator.count_right_num_wrong_spot(firstcase6,secondcase6);
        final int result7 = Multi_Numeric_Comparator.count_right_num_wrong_spot(firstcase7,secondcase7);
        final int result8 = Multi_Numeric_Comparator.count_right_num_wrong_spot(firstcase8,secondcase8);
        final int result9 = Multi_Numeric_Comparator.count_right_num_wrong_spot(firstcase9,secondcase9);
        final int result10 = Multi_Numeric_Comparator.count_right_num_wrong_spot(firstcase10,secondcase10);
        final int result11 = Multi_Numeric_Comparator.count_right_num_wrong_spot(firstcase11,secondcase11);
        final int result12 = Multi_Numeric_Comparator.count_right_num_wrong_spot(firstcase12,secondcase12);
        final int result13 = Multi_Numeric_Comparator.count_right_num_wrong_spot(firstcase13,secondcase13);
        final int result14 = Multi_Numeric_Comparator.count_right_num_wrong_spot(firstcase14,secondcase14);
        final int result15 = Multi_Numeric_Comparator.count_right_num_wrong_spot(firstcase15,secondcase15);
        final int result16 = Multi_Numeric_Comparator.count_right_num_wrong_spot(firstcase16,secondcase16);
        final int result17 = Multi_Numeric_Comparator.count_right_num_wrong_spot(firstcase17,secondcase17);
        final int result18 = Multi_Numeric_Comparator.count_right_num_wrong_spot(firstcase18,secondcase18);


        assertThat(result1).as("볼 개수 테스트").isEqualTo(0);
        assertThat(result2).as("볼 개수 테스트").isEqualTo(1);
        assertThat(result3).as("볼 개수 테스트").isEqualTo(1);
        assertThat(result4).as("볼 개수 테스트").isEqualTo(1);
        assertThat(result5).as("볼 개수 테스트").isEqualTo(1);
        assertThat(result6).as("볼 개수 테스트").isEqualTo(1);
        assertThat(result7).as("볼 개수 테스트").isEqualTo(1);
        assertThat(result8).as("볼 개수 테스트").isEqualTo(2);
        assertThat(result9).as("볼 개수 테스트").isEqualTo(2);
        assertThat(result10).as("볼 개수 테스트").isEqualTo(2);
        assertThat(result11).as("볼 개수 테스트").isEqualTo(2);
        assertThat(result12).as("볼 개수 테스트").isEqualTo(2);
        assertThat(result13).as("볼 개수 테스트").isEqualTo(2);
        assertThat(result14).as("볼 개수 테스트").isEqualTo(2);
        assertThat(result15).as("볼 개수 테스트").isEqualTo(2);
        assertThat(result16).as("볼 개수 테스트").isEqualTo(2);
        assertThat(result17).as("볼 개수 테스트").isEqualTo(3);
        assertThat(result18).as("볼 개수 테스트").isEqualTo(3);
    }

    @Test
    void Exit_input_check(){
        final String case1 = "12414";
        final String case2 = "String";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Error_Check.Exit_input_check(case1))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Error_Check.Exit_input_check(case2))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void num_input_check(){
        final String case1 = "12414";
        final String case2 = "12";
        final String case3 = "111";
        final String case4 = "String";
        final String case5 = "SSS";
        final String case6 = "TES";
        final String case7 = "TE1";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Error_Check.num_input_check(case1))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Error_Check.num_input_check(case2))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Error_Check.num_input_check(case3))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Error_Check.num_input_check(case4))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Error_Check.num_input_check(case5))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Error_Check.num_input_check(case6))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Error_Check.num_input_check(case7))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}