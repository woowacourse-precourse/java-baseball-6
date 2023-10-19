package baseball;


import baseball.domain.Answer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BaseBallTest {

    @Test
    @DisplayName("서로 다른 세자리의 수를 생성한다")
    void createAnswer() {
        Answer answer = new Answer();
        List<Integer> numberList = answer.toIntList();
        Assertions.assertThat(numberList.stream().distinct().count() == numberList.size());
    }
}
