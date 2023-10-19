package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {

    @DisplayName("makeAnswerList()를 실행시 길이가 3인 List 를 반환한다.")
    @Test
    void threeSizeOfList() {

        //given
        Computer computer = new Computer();

        //when
        List<Integer> answerRandomList = computer.makeAnswerList();

        //then
        assertThat(answerRandomList.size()).isEqualTo(3);
    }

    @DisplayName("makeAnswerList()를 실행시 중복값이 없는 List 를 반환한다.")
    @Test
    void notSameElementOfList() {

        //given
        Computer computer = new Computer();

        //when
        List<Integer> answerRandomList = computer.makeAnswerList();
        long count = answerRandomList.stream().distinct().count();

        //then
        assertThat(count).isEqualTo(3);
    }

    @DisplayName("makeAnswerList()를 실행시 각 값들은 1에서 9사이의 원소를 갖는 List 를 반환한다.")
    @Test
    void elementsValue1To9OfList() {

        //given
        Computer computer = new Computer();

        //when
        List<Integer> answerRandomList = computer.makeAnswerList();

        //then
        for (Integer number : answerRandomList) {
            assertThat(number >= 1 && number <= 9).isTrue();
        }
    }

}