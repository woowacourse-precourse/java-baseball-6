package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class NumberGeneratorTest {

    @DisplayName("1000개의 랜덤한 숫자를 생성하는 테스트")
    @Test
    void makeRandomInRangeTest() {
        //given
        NumberGenerator numberGenerator = new NumberGenerator();
        //when
        for (int i = 0; i < 1000 ; i++) {
            final int randomNumber = numberGenerator.generateRandomNumber();
            //then
            System.out.println(randomNumber);
        }
    }

    @DisplayName("1000개의 랜덤한 숫자 리스트를 생성하는 테스트")
    @Test
    void generateRandomList() {
        //give
        NumberGenerator numberGenerator = new NumberGenerator();
        //when
        for (int i = 0; i < 1000; i++) {
            final List<Integer> randomList = numberGenerator.generateRandomAnswer();
            //then
            System.out.println(randomList);
        }
    }

    @DisplayName("1 ~ 9까지 지정 범위에 숫자 생성 테스트")
    @Test
    void generateRandomNumberInCustomRange() {
        //given
        NumberGenerator numberGenerator = new NumberGenerator();
        //when
        final int randomNumber = numberGenerator.generateRandomNumber();
        //then
        assertThat(randomNumber).isBetween(1, 9);
    }

    @DisplayName("생성된 랜덤 리스트의 범위와 크기가 3인지 확인하는 테스트")
    @Test
    void validateRandomListRangeAndSize() {
        //given
        NumberGenerator numberGenerator = new NumberGenerator();
        //when
        final List<Integer> randomNumberList = numberGenerator.generateRandomAnswer();
        //then
        randomNumberList.forEach(randomNumber -> assertThat(randomNumber).isBetween(1, 9));
        assertThat(randomNumberList.size()).isEqualTo(3);
    }

    @DisplayName("생성된 랜덤 리스트의 값이 중복되는지 확인하는 테스트")
    @Test
    void duplicateNumberInRandomList() {
        //given
        NumberGenerator numberGenerator = new NumberGenerator();
        //when
        final List<Integer> randomNumberList = numberGenerator.generateRandomAnswer();
        //given
        final Set<Integer> integerSet = new HashSet<>(randomNumberList);
        assertThat(integerSet.size()).isEqualTo(3);
    }
}