package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {


    @Test
    void 입력_성공() {
        BaseballGameReferee baseballGameReferee = new BaseballGameReferee();
        String input1 = "789";
        baseballGameReferee.validateBaseballGameNumber(input1);
    }

    @Test
    void 입력_실패() {
        BaseballGameReferee baseballGameReferee = new BaseballGameReferee();
        String input1 = "1324";
        String input2 = "031";
        String input3 = "112";
        String input4 = "13n";

        assertThatThrownBy(()-> baseballGameReferee.validateBaseballGameNumber(input1)
        ).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(()-> baseballGameReferee.validateBaseballGameNumber(input2)
        ).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(()-> baseballGameReferee.validateBaseballGameNumber(input3)
        ).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(()-> baseballGameReferee.validateBaseballGameNumber(input4)
        ).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 입력_채점() {
        BaseballGameReferee referee = new BaseballGameReferee();

        String[] inputs = new String[]{"123","231","864","987","563","786","624","391","418","175"};
        System.out.println();
        for (String str : inputs) {
            referee.judgement(new BaseballGameNumber(str)).printJudgement();
        }
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
