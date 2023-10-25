package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class NumbersGeneratorTest {

    /**
     * 30회 반복 : 대략 1경 번당 2번 성공 오차
     */
    @DisplayName("중복없이 1-9 사이의 숫자가 3개 생성되었는지 확인")
    @Test
    public void checkRandomNumbers() throws Exception {
        //given
        NumbersGenerator numbersGenerator = new NumbersGenerator();

        for (int i = 0; i < 30; i++) {
            //when
            List<Integer> randomNumbers = numbersGenerator.createRandomNumbers();
            Set<Integer> set = new HashSet<>(randomNumbers);

            //then
            assertThat(set.size()).isEqualTo(3);
            for (int num : set) {
                assertThat(num).isBetween(1, 9);
            }
        }
    }
}
