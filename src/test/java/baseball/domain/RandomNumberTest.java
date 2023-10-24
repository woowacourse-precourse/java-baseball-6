package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomNumberTest {

    private RandomNumber randomNumber;

    @Test
    @DisplayName("리셋 테스트")
    void randomNumberResetTest() {
        randomNumber = RandomNumber.create(List.of(1,2,3));
        randomNumber.reset(List.of(3,4,5));

        assertEquals(3, randomNumber.getNumberAtIndex(0));
        assertEquals(4, randomNumber.getNumberAtIndex(1));
        assertEquals(5, randomNumber.getNumberAtIndex(2));
    }

    @Test
    @DisplayName("리스트에 해당하는 숫자가 있으면 true 반환 테스트")
    void numberExistsInListTest() {
        int number = 3;
        randomNumber = RandomNumber.create(List.of(1, 3, 4));
        assertThat(randomNumber.numberExistsInList(number)).isTrue();
    }

    @Test
    @DisplayName("리스트에 해당하는 숫자가 있으면 false 반환 테스트")
    void numberNotExistsInListTest() {
        int number = 6;
        randomNumber = RandomNumber.create(List.of(1, 3, 4));
        assertThat(randomNumber.numberExistsInList(number)).isFalse();
    }
}