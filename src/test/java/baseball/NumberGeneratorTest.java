package baseball;


import baseball.model.NumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class NumberGeneratorTest {

    NumberGenerator numberGenerator = new NumberGenerator();
    @Test
    @DisplayName("생성된 숫자는 3자리 이어야 합니다.")
    void numberSizeTest() {
        List<Integer> number = numberGenerator.generate();
        Assertions.assertThat(number.size()).isEqualTo(3);
    }

    @Test
    void numberIsDuplicatedTest() {
        int i = 0;
        List<Integer> number = numberGenerator.generate();
        for(; i<number.size()-1; i++){
            Assertions.assertThat(number.get(i)).isNotEqualTo(number.get(i+1));
        }
        Assertions.assertThat(number.get(2)).isNotEqualTo(number.get(0));
    }


}
