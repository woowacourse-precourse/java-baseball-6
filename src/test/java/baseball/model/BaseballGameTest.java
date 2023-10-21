package baseball.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseballGameTest {

    BaseballGame baseballGame = new BaseballGame();

    @Test
    @DisplayName("난수 반환 메서드 테스트")
    public void makeRandomTest() {

        //given
        int randomNumber;

        for(int i = 0; i < 100; i++) {
            //when
            randomNumber = baseballGame.makeRandomNumber();

            //then
            // 정수인지 확인
            Assertions.assertThat(randomNumber).isInstanceOf(Integer.class);

            // 전달한 범위 안에 있는 정수인지 확인
            Assertions.assertThat(randomNumber).isGreaterThan(99);
            Assertions.assertThat(randomNumber).isLessThan(1000);

        }





    }
}
