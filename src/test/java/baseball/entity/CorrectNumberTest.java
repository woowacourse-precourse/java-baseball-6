package baseball.entity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class CorrectNumberTest {
    @Test
    void 정답생성_각자리_중복확인() {
        // given
        CorrectNumber correctNumber = new CorrectNumber();

        // when
        correctNumber.generateNewCorrectNum();

        // then
        List<Integer> correctNumberList = correctNumber.getCorrectNumbers();
        for (int i = 0; i < correctNumberList.size(); i++) {
            for (int j = 0; j < correctNumberList.size(); j++) {
                if (i != j) { // 같은 위치는 비교하지 않는다.
                    assertThat(correctNumberList.get(i)).isNotEqualTo(correctNumberList.get(j));
                }
            }
        }
    }

}