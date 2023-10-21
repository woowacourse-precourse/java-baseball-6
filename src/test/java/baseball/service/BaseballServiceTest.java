package baseball.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BaseballServiceTest {

    @Test
    void 사용자_입력값과_랜덤숫자_비교_결과_메시지_생성_3스트라이크() {
        BaseballService baseballService = new BaseballService();
        List<Integer> inputAnswer = List.of(1, 2, 3);
        List<Integer> randomNumbers = List.of(1, 2, 3);

        String resultMessage = baseballService.compareInputAnswerToRandomNumbers(inputAnswer, randomNumbers);

        Assertions.assertEquals("3스트라이크",resultMessage);
    }
}
