package baseball;

import baseball.constants.GameConstants;
import baseball.constants.ResultConstants;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    Service service = new Service();


    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }


    //숫자 개수
    @Test
    void 예외_테스트1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    public void validateInputTest(){
        //given
        String test1 = "123";
        String test2 = "1234";
        String test3 = "qwer";
        String test4 = "112";

        //when & then
        Assertions.assertDoesNotThrow(() -> service.validateInput(test1));

        Assertions.assertThrows(IllegalArgumentException.class, () -> service.validateInput(test2));
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.validateInput(test3));
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.validateInput(test4));
    }

    @Test
    public void calcResultTest(){
        //given
        int[] userNums1 = {1,2,3};
        int[] answerNums1 = {1,2,3};
        int[] answerNums2 = {1,3,2};
        int[] answerNums3 = {4,5,6};


        //when & then
        service.calcResult(userNums1, answerNums1);
        Assertions.assertEquals(3,service.score.getStrike());
        Assertions.assertEquals(0,service.score.getBall());


        service.calcResult(userNums1, answerNums2);
        Assertions.assertEquals(1,service.score.getStrike());
        Assertions.assertEquals(2,service.score.getBall());


        service.calcResult(userNums1, answerNums3);
        Assertions.assertEquals(0,service.score.getStrike());
        Assertions.assertEquals(0,service.score.getBall());
    }


    @Test
    public void generateGameResultTest1(){
        //given
        int strikeCount = 1;
        int ballCount = 1;
        service.score.setStrike(strikeCount);
        service.score.setBall(ballCount);

        //when & then
        Assertions.assertEquals(String.format(ResultConstants.BALL_STRIKE ,ballCount, strikeCount), service.generateGameResult());
     }

    @Test
    public void generateGameResultTest2() {
        //given
        int strikeCount = 2;
        int ballCount = 0;
        service.score.setStrike(strikeCount);
        service.score.setBall(ballCount);

        //when & then
        Assertions.assertEquals(String.format(ResultConstants.STRIKE, strikeCount), service.generateGameResult());
    }

    @Test
    public void generateGameResultTest3() {
        //given
        int strikeCount = 0;
        int ballCount = 3;
        service.score.setStrike(strikeCount);
        service.score.setBall(ballCount);

        //when & then
        Assertions.assertEquals(String.format(ResultConstants.BALL, ballCount), service.generateGameResult());
    }

    @Test
    public void creRandomNumsTest(){
        //when
        int[] randomNums = service.creRandomNums();

        //then
        for (int num : randomNums) {
            Assertions.assertTrue(num >= GameConstants.RANDOM_MIN_RANGE && num <= GameConstants.RANDOM_MAX_RANGE);
        }

        long distinctCount = Arrays.stream(randomNums).distinct().count();
        Assertions.assertEquals(randomNums.length, distinctCount);
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
