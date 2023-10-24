package baseball.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BaseballRefereeTest {


    private final BaseBallReferee baseBallReferee = new BaseBallReferee();

    @Test
    @DisplayName("3스트라이크 판단")
    public void test3Strike() {
        BaseballNumber userBaseballNumber = new BaseballNumber(new BaseballNumberGenerator123());
        BaseballNumber computerBaseballNumber = new BaseballNumber(new BaseballNumberGenerator123());

        BaseballResult baseballResult = baseBallReferee.returnBaseballResult(userBaseballNumber, computerBaseballNumber);

        Assertions.assertEquals(3, baseballResult.getCount(BaseballResultState.STRIKE));
        Assertions.assertEquals(0, baseballResult.getCount(BaseballResultState.BALL));
        Assertions.assertEquals(0, baseballResult.getCount(BaseballResultState.NOTHING));
    }

    @Test
    @DisplayName("2스트라이크")
    public void test2Strike1Ball() {
        BaseballNumber userBaseballNumber = new BaseballNumber(new BaseballNumberGenerator124());
        BaseballNumber computerBaseballNumber = new BaseballNumber(new BaseballNumberGenerator123());

        BaseballResult baseballResult = baseBallReferee.returnBaseballResult(userBaseballNumber, computerBaseballNumber);

        Assertions.assertEquals(2, baseballResult.getCount(BaseballResultState.STRIKE));
        Assertions.assertEquals(0, baseballResult.getCount(BaseballResultState.BALL));
        Assertions.assertEquals(0, baseballResult.getCount(BaseballResultState.NOTHING));
    }

    @Test
    @DisplayName("1볼")
    public void test1Ball() {
        BaseballNumber userBaseballNumber = new BaseballNumber(new BaseballNumberGenerator124());
        BaseballNumber computerBaseballNumber = new BaseballNumber(new BaseballNumberGenerator456());

        BaseballResult baseballResult = baseBallReferee.returnBaseballResult(userBaseballNumber, computerBaseballNumber);

        Assertions.assertEquals(0, baseballResult.getCount(BaseballResultState.STRIKE));
        Assertions.assertEquals(1, baseballResult.getCount(BaseballResultState.BALL));
        Assertions.assertEquals(0, baseballResult.getCount(BaseballResultState.NOTHING));
    }


    @Test
    @DisplayName("낫싱")
    public void testNothing() {
        BaseballNumber userBaseballNumber = new BaseballNumber(new BaseballNumberGenerator456());
        BaseballNumber computerBaseballNumber = new BaseballNumber(new BaseballNumberGenerator123());

        BaseballResult baseballResult = baseBallReferee.returnBaseballResult(userBaseballNumber, computerBaseballNumber);

        Assertions.assertEquals(0, baseballResult.getCount(BaseballResultState.STRIKE));
        Assertions.assertEquals(0, baseballResult.getCount(BaseballResultState.BALL));
        Assertions.assertEquals(1, baseballResult.getCount(BaseballResultState.NOTHING));
    }

    public static class BaseballNumberGenerator123 implements BaseballNumberGenerator {
        @Override
        public List<Integer> generateBaseballNumber(int length) {
            return List.of(1,2,3);
        }
    }

    public static class BaseballNumberGenerator124 implements BaseballNumberGenerator {
        @Override
        public List<Integer> generateBaseballNumber(int length) {
            return List.of(1,2,4);
        }
    }

    public static class BaseballNumberGenerator456 implements BaseballNumberGenerator {
        @Override
        public List<Integer> generateBaseballNumber(int length) {
            return List.of(4,5,6);
        }
    }
}
