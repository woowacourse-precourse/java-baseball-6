package baseball;

import baseball.domain.GameStandard;
import baseball.domain.Judge;
import baseball.domain.NumbersGenerate;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    GameStandard gameStandard;
    Judge judge;


    @BeforeEach
    void setUp() {
        gameStandard = new GameStandard();
        judge = new Judge();
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

    @Test
    void 예외_한자리수_입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_문자타입_입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("asd"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_음수_입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @DisplayName("심판의 유저의 게임 진행 상황 확인, 볼, 스트라이크, 낫싱")
    @Test
    public void baseballGameInspectionTest() throws Exception {
        // given
        List<Integer> computerList = new ArrayList<>(List.of(1, 2, 3));
        List<List<Integer>> numInputUser = new ArrayList<>(List.of(
                // 3스트라이크
                List.of(1, 2, 3),
                // 2스트라이크
                List.of(1, 2, 4),
                // 2볼 1스트라이크
                List.of(1, 3, 2),
                // 1볼 1스트라이크
                List.of(1, 8, 2),
                // 1스트라이크
                List.of(1, 8, 4),
                // 1볼
                List.of(4, 1, 6),
                // 2볼
                List.of(7, 1, 2),
                // 3볼
                List.of(3, 1, 2),
                // 낫싱
                List.of(7, 9, 8)
        ));

        List<String> hints = new ArrayList<>(
                List.of(
                        "3스트라이크",
                        "2스트라이크",
                        "2볼 1스트라이크",
                        "1볼 1스트라이크",
                        "1스트라이크",
                        "1볼",
                        "2볼",
                        "3볼",
                        "낫싱"
                )
        );
        String resultHint = "";
        List<String> hintResult = new ArrayList<>();

        // when
        for (List<Integer> numList : numInputUser) {
            resultHint = judge.baseballGameInspection(computerList, numList);
            hintResult.add(resultHint);
        }

        // then
        assertThat(hintResult).containsAll(hints);
    }

    @DisplayName("유저의 랜덤 입력 숫자와, 컴퓨터의 랜덤 숫자중 같은 것의 갯수를 구한다.")
    @ParameterizedTest
    @CsvSource({"1,2,3,3", "1,2,4,2", "1,4,5,1", "1,3,4,2", "3,1,4,2", "4,1,3,2", "4,3,1,2", "4,5,1,1", "4,1,5,1", "3,2,1,3", "4,5,6,0"})
    public void getSameNumber2ComputerTest(int num1, int num2, int num3, int expectCntSameNum) throws Exception {
        // given
        List<Integer> computerList = new ArrayList<>(List.of(1, 2, 3));
        List<Integer> userList = new ArrayList<>(List.of(num1, num2, num3));

        // when
        int result = gameStandard.getSameNumber2Computer(computerList, userList);

        // then
        assertThat(result).isEqualTo(expectCntSameNum);
    }

    @DisplayName("유저의 입력한 숫자중 특정한 index의 값의 숫자와 컴퓨터의 저장된 3개의 숫자중 특정 index에 숫자가 같은지 확인한다.")
    @ParameterizedTest
    @CsvSource({"0,1,true", "1,2,true", "2,3,true", "0,4,false", "1,4,false", "2,4,false"})
    public void isSamePlaceNumUserAndComputerTest(int placeIndexOfUser, int numIndexPlaceOfUser, boolean expectResult) throws Exception {
        // given
        List<Integer> computerList = new ArrayList<>(List.of(1, 2, 3));

        // when
        boolean result = gameStandard.isSamePlaceNumUserAndComputer(computerList, placeIndexOfUser, numIndexPlaceOfUser);

        // then
        assertThat(result).isEqualTo(expectResult);
    }
}
