package service;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static service.NumberService.*;
import static domain.NumberConstant.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class NumberServiceTest {
    @Test
    void generateRandomNumber_서로_다른_숫자_검사() {
        List<Integer> randomNumbers = new ArrayList<>();

        while (randomNumbers.size() < NUMBER_SET_SIZE) {
            int num = Randoms.pickNumberInRange(START_RANGE_NUM, END_RANGE_NUM);

            if (!randomNumbers.contains(num))
                randomNumbers.add(num);
        }

        for (int i = 0; i < randomNumbers.size(); i++) {
            int num = randomNumbers.get(i);

            for (int j = i + 1; j < randomNumbers.size(); j++)
                assertThat(num).isNotEqualTo(randomNumbers.get(j));
        }
    }

    @Test
    void validateInputDuplicate_로직_검사() {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < NUMBER_SET_SIZE; i++)
            numbers.add(1);

        assertThrows(IllegalArgumentException.class, () -> {
            validateInputDuplicate(numbers);
        });
    }

    @Test
    void validateRestartNumber_로직_검사() {
        String restart = "3";

        assertThrows(IllegalArgumentException.class, () -> {
            validateRestartNumber(restart);
        });
    }
}