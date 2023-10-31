package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RaceCarTest {

    private List<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = List.of(2, 4, 7, 9, 1, 5);
    }

    @Test
    void 컬렉션에서_스트림을통해_최대값을_찾아_값이_맞는지_확인한다() {
        int maxValue = numbers.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0); // 만약 컬렉션이 비어있으면 0을 반환

        assertEquals(maxValue, 9);
    }

    @Test
    void 컬렉션에서_스트림을통해_최대값이_없을경우_0을_반환한다() {
        numbers = List.of(0, 0, 0, 0);
        List<Integer> emptyList = numbers;
        int maxValue = emptyList.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0); // 만약 컬렉션이 비어있으면 0을 반환

        assertEquals(0, maxValue);
    }

    @Test
    void 값이_4보다_같거나크면_쉼표를_넣어_출력한다() {
        String result = numbers.stream()
                .filter(num -> num >= 4)
                .map(String::valueOf)
                .reduce((num1, num2) -> num1 + "," + num2)
                .orElse("");

        assertEquals("4,7,9,5", result);
    }


}
