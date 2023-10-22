package baseball;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ResultFactoryTest {
    @Test
    void 숫자가_모두_같을시_3스트라이크(){
        ResultFactory resultFactory = new ResultFactory();
        UserPrediction userPrediction = new UserPrediction(7,8,9);
        Answer answer = new Answer(7,8,9);

        Result result = resultFactory.compareAndGetResult(userPrediction, answer);

        assertEquals(3, result.getNumberOfStrikes());
        assertEquals(0, result.getNumberOfBalls());
    }

    @Test
    void 숫자가_모두_다를시_0볼_0스트라이크(){
        ResultFactory resultFactory = new ResultFactory();
        UserPrediction userPrediction = new UserPrediction(1,2,3);
        Answer answer = new Answer(7,8,9);

        Result result = resultFactory.compareAndGetResult(userPrediction, answer);

        assertEquals(0, result.getNumberOfStrikes());
        assertEquals(0, result.getNumberOfBalls());
    }

    @Test
    void 같은숫자_모두_다른_위치_3볼(){
        ResultFactory resultFactory = new ResultFactory();
        UserPrediction userPrediction = new UserPrediction(1,2,3);
        Answer answer = new Answer(3,1,2);

        Result result = resultFactory.compareAndGetResult(userPrediction, answer);

        assertEquals(0, result.getNumberOfStrikes());
        assertEquals(3, result.getNumberOfBalls());
    }

}