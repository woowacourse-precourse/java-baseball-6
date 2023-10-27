package baseball.model;

import baseball.service.ComputerService;
import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {


    ComputerService computerService = new ComputerService();

    @Test
    @DisplayName("컴퓨터_크기_테스트")
    public void sizeTest() {
        List<Integer> test = computerService.createComputerList();
        Computer computer = new Computer(test);
        assertThat(computer.getComputer().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("컴퓨터_중복_테스트")
    public void duplicateTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            List<Integer> duplicates = Arrays.asList(1, 2, 2);
            Computer computer = new Computer(duplicates);
        }, "컴퓨터가 선택한 숫자는 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("컴퓨터_숫자여부_테스트")
    public void isNumberTest() {
        List<Integer> numbers = computerService.createComputerList();
        Computer computer = new Computer(numbers);
        numbers.stream()
                .map(val -> assertThat(val).isInstanceOf(Integer.class));
    }

}