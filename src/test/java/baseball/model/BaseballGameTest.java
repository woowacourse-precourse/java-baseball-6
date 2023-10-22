package baseball.model;

import baseball.controller.BaseballGameController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseballGameTest {

    @Test
    @DisplayName("난수 반환 메서드 테스트")
    public void makeRandomTest() {

        //given
        int randomNumber;

        for(int i = 0; i < 100; i++) {
            //when
            randomNumber = BaseballGame.makeRandomNumber();

            //then
            // 정수인지 확인
            Assertions.assertThat(randomNumber).isInstanceOf(Integer.class);

            // 전달한 범위 안에 있는 정수인지 확인
            Assertions.assertThat(randomNumber).isGreaterThanOrEqualTo(baseball.model.RangeConstant.START_INT);
            Assertions.assertThat(randomNumber).isLessThanOrEqualTo(baseball.model.RangeConstant.END_INT);

        }
    }

    @Test
    @DisplayName("유저 입력 결과 반환 메서드 테스트")
    public void checkScoreTest() {
        //given
        int computer;
        int user;

        //when
        computer = 489;
        user = 819;

        //then
        BaseballGame baseballGame = BaseballGame.checkScore(computer, user);

        Assertions.assertThat(baseballGame.getBall()).isEqualTo(1);
        Assertions.assertThat(baseballGame.getStrike()).isEqualTo(1);
    }

}
