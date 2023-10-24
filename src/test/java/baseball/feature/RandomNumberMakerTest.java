package baseball.feature;

import static org.junit.jupiter.api.Assertions.*;


import java.text.MessageFormat;
import java.util.List;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class RandomNumberMakerTest {

    @RepeatedTest(100)
    public void makerTest() {
        RandomNumberMaker RNM = new RandomNumberMaker();
        List<Integer> mylist = RNM.maker();
        boolean allInRange = mylist.stream().allMatch(i -> i >= 1 && i <= 9);
        assertTrue(allInRange, MessageFormat.format("당신의배열 {0} 모든 원소가 1~9 사이의 값이 아닙니다.", mylist));
    }
}