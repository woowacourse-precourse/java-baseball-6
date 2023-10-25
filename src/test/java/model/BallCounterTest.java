package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BallCounterTest {
    List<Integer> userNum = new ArrayList<>();
    List<Integer> comNum = new ArrayList<>();

    /**
     * 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 0
     */
    @Test
    void 스트라이크_테스트(){
        //given
        BallCounter bc = new BallCounter();
        //when
        userNum = Arrays.asList(1,2,3);
        comNum = Arrays.asList(1,2,3);
        int[] result = bc.ballCount(userNum, comNum);
        int[] expected = {3,0};
        //then
        Assertions.assertArrayEquals(expected,result);
    }

    @Test
    void 볼_테스트(){
        //given
        BallCounter bc = new BallCounter();
        //when
        userNum = Arrays.asList(2,1,3);
        comNum = Arrays.asList(1,2,3);
        int[] result = bc.ballCount(userNum, comNum);
        int[] expected = {1,2};
        //then
        Assertions.assertArrayEquals(expected,result);
    }

    @Test
    void 낫싱_테스트(){
        //given
        BallCounter bc = new BallCounter();
        //when
        userNum = Arrays.asList(2,1,3);
        comNum = Arrays.asList(5,6,7);
        int[] result = bc.ballCount(userNum, comNum);
        int[] expected = {0,0};
        //then
        Assertions.assertArrayEquals(expected,result);
    }
}
