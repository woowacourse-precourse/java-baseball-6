package baseball;

import baseball.controller.HintCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class HintCalculatorTest {

    @DisplayName("userList와 computerList가 하나도 겹치지 않을 때 낫싱 출력")
    @Test
    void printNothingHint(){
        List<Integer> userList = List.of(1, 2, 3);
        List<Integer> computerList = List.of(4, 5, 6);
        HintCalculator hintCalculator = new HintCalculator(userList, computerList);
        String hintString = hintCalculator.getHintString();
        String expectedHintString = "낫싱";
        assertThat(hintString).isEqualTo(expectedHintString);
    }
}
