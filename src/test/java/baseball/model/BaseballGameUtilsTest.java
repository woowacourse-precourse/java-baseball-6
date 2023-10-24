package baseball.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;

public class BaseballGameUtilsTest {

    BaseballGameUtils baseballGameUtils = new BaseballGameUtils();

    @Test
    @DisplayName("난수 반환 메서드 테스트")
    public void makeRandomTest() {

        //given
        ComputerNumber computerNumber;

        //when
        computerNumber = new ComputerNumber();

        //then
        Assertions.assertThat(computerNumber.getNumber().size()).isEqualTo(3);

        for (int i = 0; i < computerNumber.getNumber().size(); i++) {
            Assertions.assertThat(computerNumber.getNumber().get(i)).isGreaterThanOrEqualTo(1);
            Assertions.assertThat(computerNumber.getNumber().get(i)).isLessThanOrEqualTo(9);
        }

    }

    @Test
    @DisplayName("유저 입력 결과 반환 메서드 테스트")
    public void checkScoreTest() {
        //given
        List<Integer> computerNumber = new ArrayList<>();
        List<Integer> userNumber = new ArrayList<>();

        //when
        computerNumber.add(4);
        computerNumber.add(8);
        computerNumber.add(9);

        userNumber.add(8);
        userNumber.add(1);
        userNumber.add(9);

        //then
        Score score = baseballGameUtils.checkScore(computerNumber, userNumber);

        Assertions.assertThat(score.getBall()).isEqualTo(1);
        Assertions.assertThat(score.getStrike()).isEqualTo(1);
    }

}
