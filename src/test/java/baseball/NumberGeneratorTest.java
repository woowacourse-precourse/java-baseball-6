package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NumberGeneratorTest {

    @DisplayName("1000개의 랜덤한 숫자를 생성하는 테스트")
    @Test
    void makeRandomInRangeTest() {
        //given
        NumberGenerator numberGenerator = new NumberGenerator();
        //when
        for (int i = 0; i < 1000 ; i++) {
            int randomNumber = numberGenerator.generateRandomNumber();
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
            List<Integer> randomList = numberGenerator.makeRandomAnswerList();
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
        int randomNumber = numberGenerator.generateRandomNumber();
        //then
        assertThat(randomNumber).isBetween(1, 9);
    }

    @DisplayName("생성된 랜덤 리스트의 범위와 크기가 3인지 확인하는 테스트")
    @Test
    void validateRandomListRangeAndSize() {
        //given
        NumberGenerator numberGenerator = new NumberGenerator();
        //when
        List<Integer> randomNumberList = numberGenerator.makeRandomAnswerList();
        //then
        randomNumberList.forEach(randomNumber -> assertThat(randomNumber).isBetween(1, 9));
        assertThat(randomNumberList.size()).isEqualTo(3);
    }
}