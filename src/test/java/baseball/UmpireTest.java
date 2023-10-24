package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UmpireTest {

    @Test
    void 삼_스트라이크_테스트() {

        List<Integer> answerList = new ArrayList<>();

        answerList.add(3);
        answerList.add(6);
        answerList.add(9);


        List<Integer> trialList = new ArrayList<>();
        trialList.add(3);
        trialList.add(6);
        trialList.add(9);

        Umpire umpire = new Umpire();

        umpire.judge(answerList, trialList);

        assertEquals(3, umpire.getStrike());
        assertEquals(0,umpire.getBall());
        assertEquals(false, umpire.isNothing());
    }

    @Test
    void 볼_스트라이크_테스트() {

        List<Integer> answerList = new ArrayList<>();

        answerList.add(3);
        answerList.add(6);
        answerList.add(9);


        List<Integer> trialList = new ArrayList<>();
        trialList.add(6);
        trialList.add(3);
        trialList.add(9);

        Umpire umpire = new Umpire();

        umpire.judge(answerList, trialList);

        assertEquals(1, umpire.getStrike());
        assertEquals(2,umpire.getBall());
        assertEquals(false, umpire.isNothing());
    }

    @Test
    void 삼_볼_테스트() {

        List<Integer> answerList = new ArrayList<>();

        answerList.add(3);
        answerList.add(6);
        answerList.add(9);


        List<Integer> trialList = new ArrayList<>();
        trialList.add(9);
        trialList.add(3);
        trialList.add(6);

        Umpire umpire = new Umpire();

        umpire.judge(answerList, trialList);

        assertEquals(0, umpire.getStrike());
        assertEquals(3,umpire.getBall());
        assertEquals(false, umpire.isNothing());
    }

    @Test
    void 낫싱_테스트() {

        List<Integer> answerList = new ArrayList<>();

        answerList.add(3);
        answerList.add(6);
        answerList.add(9);


        List<Integer> trialList = new ArrayList<>();
        trialList.add(1);
        trialList.add(2);
        trialList.add(4);

        Umpire umpire = new Umpire();

        umpire.judge(answerList, trialList);

        assertEquals(0, umpire.getStrike());
        assertEquals(0,umpire.getBall());
        assertEquals(true, umpire.isNothing());
    }

}