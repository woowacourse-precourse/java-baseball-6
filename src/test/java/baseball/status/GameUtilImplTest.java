package baseball.status;

import static baseball.status.GameSetting.COUNT_NUM;
import static baseball.status.GameSetting.MAX_NUM;
import static baseball.status.GameSetting.MIN_NUM;
import static org.assertj.core.api.Assertions.assertThat;

import baseball.game.impl.GameUtilImpl;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameUtilImplTest {
    @Test
    @DisplayName("스트라이크 계산")
    void outputTest1() {
        GameUtilImpl gameUtil = new GameUtilImpl();
        List<Integer> computerNum = List.of(1, 2, 3);
        List<Integer> inputNum = List.of(1, 4, 5);
        List<Integer> inputNum2 = List.of(1, 2, 4);
        List<Integer> inputNum3 = List.of(1, 2, 3);

        int[] result = gameUtil.calculateResult(computerNum, inputNum);
        int[] result2 = gameUtil.calculateResult(computerNum, inputNum2);
        int[] result3 = gameUtil.calculateResult(computerNum, inputNum3);

        assertThat(result).containsExactly(0, 1);
        assertThat(result2).containsExactly(0, 2);
        assertThat(result3).containsExactly(0, 3);
    }

    @Test
    @DisplayName("볼 계산")
    void outputTest2() {
        GameUtilImpl gameUtil = new GameUtilImpl();
        List<Integer> computerNum = List.of(1, 2, 3);
        List<Integer> inputNum = List.of(2, 4, 5);
        List<Integer> inputNum2 = List.of(2, 1, 4);
        List<Integer> inputNum3 = List.of(2, 3, 1);

        int[] result = gameUtil.calculateResult(computerNum, inputNum);
        int[] result2 = gameUtil.calculateResult(computerNum, inputNum2);
        int[] result3 = gameUtil.calculateResult(computerNum, inputNum3);

        assertThat(result).containsExactly(1, 0);
        assertThat(result2).containsExactly(2, 0);
        assertThat(result3).containsExactly(3, 0);
    }

    @Test
    @DisplayName("볼 + 스트라이크 계산")
    void outputTest3() {
        GameUtilImpl gameUtil = new GameUtilImpl();
        List<Integer> computerNum = List.of(1, 2, 3);
        List<Integer> inputNum = List.of(1, 3, 4);
        List<Integer> inputNum2 = List.of(3, 2, 1);

        int[] result = gameUtil.calculateResult(computerNum, inputNum);
        int[] result2 = gameUtil.calculateResult(computerNum, inputNum2);

        assertThat(result).containsExactly(1, 1);
        assertThat(result2).containsExactly(2, 1);
    }

    @Test
    @DisplayName("설정된 컴퓨터 수 유효성 확인")
    void setComputerNumTest() {
        GameUtilImpl gameUtil = new GameUtilImpl();
        List<Integer> computerNum = gameUtil.setComputerNum();

        assertThat(computerNum).hasSize(COUNT_NUM.getValue());

        for (int num : computerNum) {
            assertThat(num >= MIN_NUM.getValue()).isTrue();
            assertThat(num <= MAX_NUM.getValue()).isTrue();
        }

        for (int i = 0; i < computerNum.size(); i++) {
            for (int j = i + 1; j < computerNum.size(); j++) {
                assertThat(computerNum.get(i)).isNotEqualTo(computerNum.get(j));
            }
        }
    }
}