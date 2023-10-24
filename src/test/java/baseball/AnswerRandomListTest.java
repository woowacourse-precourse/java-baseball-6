package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.service.GenerationQuestionList;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AnswerRandomListTest {

    @DisplayName("generateThreeRandomNumber()를 실행시 길이가 3인 List 를 반환한다.")
    @Test
    void threeSizeOfList() {

        //given
        GenerationQuestionList computer = new GenerationQuestionList(new ArrayList<>());

        //when
        List<Integer> answerRandomList = computer.generateThreeRandomNumber();

        //then
        assertThat(answerRandomList.size()).isEqualTo(3);
    }

    @DisplayName("generateThreeRandomNumber()를 실행시 중복값이 없는 List 를 반환한다.")
    @Test
    void notSameElementOfList() {

        //given
        GenerationQuestionList computer = new GenerationQuestionList(new ArrayList<>());

        //when
        List<Integer> answerRandomList = computer.generateThreeRandomNumber();
        long count = answerRandomList.stream().distinct().count();

        //then
        assertThat(count).isEqualTo(3);
    }

    @DisplayName("generateThreeRandomNumber()를 실행시 각 값들은 1에서 9사이의 원소를 갖는 List 를 반환한다.")
    @Test
    void elementsValue1To9OfList() {

        //given
        GenerationQuestionList computer = new GenerationQuestionList(new ArrayList<>());

        //when
        List<Integer> answerRandomList = computer.generateThreeRandomNumber();

        //then
        for (Integer number : answerRandomList) {
            assertThat(number >= 1 && number <= 9).isTrue();
        }
    }

}