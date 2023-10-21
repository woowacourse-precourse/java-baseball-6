package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringToIntegerListTest {
    @Test
    public void 문자열을_숫자리스트로_변환_테스트(){
        //given
        String str="193";
        //when
        List<Integer> intList = StringToIntegerList.turnToIntList(str);
        //then
        Assertions.assertEquals(1,intList.get(0));
        Assertions.assertEquals(9,intList.get(1));
        Assertions.assertEquals(3,intList.get(2));
    }
}