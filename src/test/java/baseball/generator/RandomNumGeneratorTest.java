package baseball.generator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RandomNumGeneratorTest {

    @DisplayName("숫자 야구 전용 랜덤 숫자 생성하면 숫자의 갯수는 3이다.")
    @Test
    void RandomNumGeneratorSize3() {
        //given
        //when
        List<Integer> randomNumberList = RandomNumGenerator.generate();

        //then
        assertThat(randomNumberList).hasSize(3);

    }

    @DisplayName("숫자 야구 전용 랜덤 숫자 생성하면 숫자는 서로 다르다.")
    @Test
    void RandomNumGeneratorDistinct() {
        //given
        //when
        List<Integer> randomNumberList = RandomNumGenerator.generate();

        //then
        assertThat(randomNumberList).doesNotHaveDuplicates();

    }

}