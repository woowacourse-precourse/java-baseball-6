package baseball;

import baseball.model.ComputerNumbers;
import baseball.model.Number;
import baseball.model.UserNumbers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompareWithAnswerTest {
    @Test
    public void 원볼_원스트라이크_테스트(){
        //given
        Number[] computerNums = { new Number(1),new Number(2),new Number(3)};
        Number[] userNums= {new Number(4),new Number(1),new Number(3)};

        UserNumbers userNumbers = new UserNumbers(userNums);
        ComputerNumbers computerNumbers = new ComputerNumbers(computerNums);
        //when
        boolean b = CompareWithAnswer.compareWithAnswer(computerNumbers, userNumbers);
        //then
        assertEquals(false,b);
    }

    @Test
    public void 제로볼_투스트라이크_테스트(){
        //given
        Number[] computerNums = { new Number(1),new Number(2),new Number(3)};
        Number[] userNums= {new Number(1),new Number(2),new Number(4)};

        UserNumbers userNumbers = new UserNumbers(userNums);
        ComputerNumbers computerNumbers = new ComputerNumbers(computerNums);
        //when
        boolean b = CompareWithAnswer.compareWithAnswer(computerNumbers, userNumbers);
        //then
        assertEquals(false,b);
    }

    @Test
    public void 쓰리스트라이크_테스트(){
        //given
        Number[] computerNums = { new Number(1),new Number(2),new Number(3)};
        Number[] userNums= {new Number(1),new Number(2),new Number(3)};

        UserNumbers userNumbers = new UserNumbers(userNums);
        ComputerNumbers computerNumbers = new ComputerNumbers(computerNums);
        //when
        boolean b = CompareWithAnswer.compareWithAnswer(computerNumbers, userNumbers);
        //then
        assertEquals(true,b);
    }
}