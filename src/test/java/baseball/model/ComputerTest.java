package baseball.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {
    @Test
    void 컴퓨터_스트라이크_볼_횟수_테스트(){
        //given
        Computer computer = new Computer(List.of(1,2,3));
        final List<Integer> case1 = List.of(1,2,3); //3strike
        final List<Integer> case2 = List.of(4,5,6); //0,0
        final List<Integer> case3 = List.of(1,2,6); //2strike
        final List<Integer> case4 = List.of(2,3,1); //3ball
        final List<Integer> case5 = List.of(1,5,2); //1,1

        //when
        final List<Integer> result1 = computer.compareNumberList(case1);
        final List<Integer> result2 = computer.compareNumberList(case2);
        final List<Integer> result3 = computer.compareNumberList(case3);
        final List<Integer> result4 = computer.compareNumberList(case4);
        final List<Integer> result5 = computer.compareNumberList(case5);

        //then
        assertThat(result1).isEqualTo(List.of(0,3));
        assertThat(result2).isEqualTo(List.of(0,0));
        assertThat(result3).isEqualTo(List.of(0,2));
        assertThat(result4).isEqualTo(List.of(3,0));
        assertThat(result5).isEqualTo(List.of(1,1));
    }

}