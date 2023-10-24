package baseball;

import baseball.controller.RandomListMaker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomListMakerTest {
    private final int MINIMUM_NUM_IN_RANGE = 1;
    private final int MAXIMUM_NUM_IN_RANGE = 9;
    private final int LIST_SIZE = 3;

    @DisplayName("RandomListMaker에서 생성된 리스트의 길이가 3인지 확인")
    @Test
    public void isThreeComponent() {
        List<Integer> integerList = RandomListMaker.generateRandomNumbers();
        assertThat(integerList.size()).isEqualTo(LIST_SIZE);
    }

    @DisplayName("RandomListMaker에서 생성된 리스트에 중복된 값이 없는지 확인")
    @Test
    public void isDistinct() {
        List<Integer> integerList = RandomListMaker.generateRandomNumbers();
        assertThat(integerList.stream().distinct().count()).isEqualTo(LIST_SIZE);
    }

    @DisplayName("RandomListMaker에서 생성된 리스트의 원소들이 모두 범위안에 속하는지 확인")
    @Test
    public void isInRange() {
        List<Integer> integerList = RandomListMaker.generateRandomNumbers();
        assertTrue(integerList.stream()
                .allMatch(num -> num >= MINIMUM_NUM_IN_RANGE && num <= MAXIMUM_NUM_IN_RANGE));
    }
}
