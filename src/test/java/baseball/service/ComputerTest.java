package baseball.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerTest {

    @Test
    @DisplayName("랜덤 숫자 3자리 생성")
    void generateRandomNumber() {
        //given
        List<Integer> randomNumbers = new ArrayList<>();
        Computer computer = new Computer();
        //when
        randomNumbers = computer.generateNumber();
        //then
        Assertions.assertEquals(3, randomNumbers.size());
    }

    @Test
    @DisplayName("숫자 비교 결과1 : 숫자만 같을 경우")
    void getResult_숫자만_같을_경우() {
        //given
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(2, 1, 7);
        Computer computer = new Computer();
        //when
        String result = computer.getResult(numbers1, numbers2);
        //then
        Assertions.assertEquals("2볼", result);
    }

    @Test
    @DisplayName("숫자 비교 결과2 : 숫자와 위치가 같을 경우")
    void getResult_숫자와_위치가_같을_경우() {
        //given
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(1, 3, 5);
        Computer computer = new Computer();
        //when
        String result = computer.getResult(numbers1, numbers2);
        //then
        Assertions.assertEquals("1볼 1스트라이크", result);
    }

    @Test
    @DisplayName("숫자 비교 결과3 : 일치한 숫자가 없을 경우")
    void getResult_일치한_숫자가_없을_경우() {
        //given
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(6, 7, 8);
        Computer computer = new Computer();
        //when
        String result = computer.getResult(numbers1, numbers2);
        //then
        Assertions.assertEquals("낫싱", result);
    }

    @Test
    @DisplayName("숫자 비교 결과4 : 숫자와 위치를 모두 맞춘 경우")
    void getResult_숫자와_위치를_모두_맞춘_경우() {
        //given
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(1, 2, 3);
        Computer computer = new Computer();
        //when
        String result = computer.getResult(numbers1, numbers2);
        //then
        Assertions.assertEquals("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료", result);
    }
}