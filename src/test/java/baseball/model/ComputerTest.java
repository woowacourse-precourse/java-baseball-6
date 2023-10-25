package baseball.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    @DisplayName("랜덤 숫자개수 파악")
    @RepeatedTest(value = 10, name = "{랜덤숫자사이즈}, {currentRepetition}/{totalRepetitions}")
    public void 랜덤_숫자개수_파악() throws Exception{
        //given (주어진 값)
        Computer computer = new Computer();

        //when (기능 작동)
        computer.selectComputerNumber();
        int size = computer.getComputerNumber().size();

        //then (기능 작동 후 결과)
        Assertions.assertThat(size).isEqualTo(3);
    }

    @DisplayName("1~9사이 검사")
    @RepeatedTest(value = 10, name = "{범위안의 숫자}, {currentRepetition}/{totalRepetitions}")
    public void 숫자범위검사() throws Exception{
        //given (주어진 값)
        Computer computer = new Computer();

        //when (기능 작동)
        computer.selectComputerNumber();
        List<Integer> list = computer.getComputerNumber();

        Integer maxValue = list.stream()
                .mapToInt(x -> x)
                .max()
                .orElseThrow(IllegalArgumentException::new);

        Integer minValue = list.stream()
                .mapToInt(x -> x)
                .min()
                .orElseThrow(IllegalArgumentException::new);

        //then (기능 작동 후 결과)
        Assertions.assertThat(maxValue).isBetween(1,9);
        Assertions.assertThat(minValue).isBetween(1,9);
    }
}