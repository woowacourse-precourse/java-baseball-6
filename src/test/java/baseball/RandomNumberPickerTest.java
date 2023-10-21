package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RandomNumberPickerTest {

    @Test
    public void 랜덤숫자_테스트(){
        //given
        RandomNumberPicker randomNumberPicker = new RandomNumberPicker();
        //when
        List<Integer> nums = randomNumberPicker.pickRandomNums();
        //then
        Assertions.assertEquals(3,nums.size());
        Assertions.assertNotEquals(nums.get(0),nums.get(1));
        Assertions.assertNotEquals(nums.get(0),nums.get(2));
        Assertions.assertNotEquals(nums.get(1),nums.get(2));
        Assertions.assertTrue(nums.get(0)<10 && 0<nums.get(0));
        Assertions.assertTrue(nums.get(1)<10 && 0<nums.get(1));
        Assertions.assertTrue(nums.get(2)<10 && 0<nums.get(2));
    }
}