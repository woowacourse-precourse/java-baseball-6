package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.config.withinRange;
import baseball.service.GenerationQuestionList;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GenerationQuestionTest {

    @DisplayName("generateRandomNumberList()를 실행시 길이가 3인 List 를 반환한다.")
    @Test
    void threeSizeOfList() {

        //given
        GenerationQuestionList computer = new GenerationQuestionList(new ArrayList<>());

        //when
        List<Integer> answerRandomList = computer.generateRandomNumberList(new withinRange(1, 9));

        //then
        assertThat(answerRandomList.size()).isEqualTo(3);
    }

    @DisplayName("generateRandomNumberList()를 실행시 중복값이 없는 List 를 반환한다.")
    @Test
    void notSameElementOfList() {

        //given
        GenerationQuestionList computer = new GenerationQuestionList(new ArrayList<>());

        //when
        List<Integer> answerRandomList = computer.generateRandomNumberList(new withinRange(1, 9));
        long count = answerRandomList.stream().distinct().count();

        //then
        assertThat(count).isEqualTo(3);
    }

    @DisplayName("generateRandomNumberList()를 실행시 각 값들은 1에서 9사이의 원소를 갖는 List 를 반환한다.")
    @Test
    void elementsValue_1_To_9_OfList() {

        //given
        GenerationQuestionList computer = new GenerationQuestionList(new ArrayList<>());
        withinRange withinRange = new withinRange(1, 9);
        //when
        List<Integer> answerRandomList = computer.generateRandomNumberList(withinRange);

        //then
        for (Integer number : answerRandomList) {
            assertThat(number >= withinRange.startInclusive() && number <= withinRange.endInclusive()).isTrue();
        }
    }

    @DisplayName("withinRange(시작 범위, 종료 범위)를 설정 후 generateThreeRandomNumber()를 실행시 각 값들은 시작 범위 ~ 종료 범위 내 3개의 원소를 갖는 List 를 반환한다.")
    @Test
    void elementsValue_4_TO_10_OfList() {

        //given
        GenerationQuestionList computer = new GenerationQuestionList(new ArrayList<>());
        int startInclusive = 4;
        int endInclusive = 8;
        withinRange withinRange = new withinRange(startInclusive, endInclusive);

        //when
        List<Integer> answerRandomList = computer.generateRandomNumberList(withinRange);

        //then
        for (Integer number : answerRandomList) {
            assertThat(number >= withinRange.startInclusive() && number <= withinRange.endInclusive()).isTrue();
        }
    }

    @DisplayName("아웃카운트(3)가 withinRange(시작 범위, 종료 범위)범위 값 보다 클 경우 IllegalArgumentException 를 반환한다.")
    @Test
    void withinRangeLessThanOutCount_SUCCESS() {

        //given
        GenerationQuestionList computer = new GenerationQuestionList(new ArrayList<>());
        int startInclusive = 1;
        int endInclusive = 3;
        withinRange withinRange = new withinRange(startInclusive, endInclusive);

        //then
        assertThatThrownBy(() -> computer.generateRandomNumberList(withinRange))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("아웃카운트(3)가 withinRange(시작 범위, 종료 범위)범위 값 보다 작을 경우 정상적으로 List<Integer> 가 생성된다.")
    @Test
    void withinRangeLessThanOutCount_FAIL() {

        //given
        GenerationQuestionList computer = new GenerationQuestionList(new ArrayList<>());
        int startInclusive = 1;
        int endInclusive = 3;
        withinRange withinRange = new withinRange(startInclusive, endInclusive);

        List<Integer> randomNumberList = computer.generateRandomNumberList(withinRange);

        //then
        assertThat(randomNumberList).isInstanceOf(List.class);
    }
}