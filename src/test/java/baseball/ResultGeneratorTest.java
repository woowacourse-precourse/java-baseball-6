package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


class ResultGeneratorTest {
    ResultGenerator resultGenerator = new ResultGenerator();

    @Test
    @DisplayName("볼, 스트라이크, 낫싱을 판단 테스트")
    void makeResult() {

        List<Integer> computerNumbers = List.of(1,2,3);

        List<Integer> strikeBall = //3스트라이크
                resultGenerator.makeResult(List.of(1,2,3),computerNumbers);
        Assertions.assertEquals(strikeBall,List.of(3,0));

        strikeBall = //낫싱
                resultGenerator.makeResult(List.of(6,4,7),computerNumbers);
        Assertions.assertEquals(strikeBall,List.of(0,0));


        strikeBall = //2볼
                resultGenerator.makeResult(List.of(5,1,2),computerNumbers);
        Assertions.assertEquals(strikeBall,List.of(0,2));


        strikeBall = //1스트라이크 1볼
                resultGenerator.makeResult(List.of(1,3,0),computerNumbers);
        Assertions.assertEquals(strikeBall,List.of(1,1));

    }
}