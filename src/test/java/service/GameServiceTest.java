package service;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static service.NumberService.*;
import static domain.NumberConstant.*;

class GameServiceTest {

    @Test
    void playOneGame_로직_검사() {
        List<Integer> answer = generateRandomNumber(NUMBER_SET_SIZE);
        List<Integer> mockInput = new ArrayList<>();

        do {
            mockInput.addAll(answer);
        } while (answer.equals(mockInput));
    }

    @Test
    void checkResult_로직_검사() {
        int strike = 0;
        int ball = 0;

        List<Integer> answer = generateRandomNumber(NUMBER_SET_SIZE);
        List<Integer> mockInput = new ArrayList<>();

        mockInput.addAll(answer);

        for (int i = 0; i < NUMBER_SET_SIZE; i++) {
            Integer num = mockInput.get(i);

            if (answer.contains(num)) {
                if (i == answer.indexOf(num)) ++strike;
                else ++ball;
            }
        }

        assertThat(strike).isEqualTo(CORRECT_STRIKE_NUM);
    }
}