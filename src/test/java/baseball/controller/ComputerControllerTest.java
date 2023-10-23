package baseball.controller;

import static org.assertj.core.api.Assertions.*;

import baseball.common.RandomUtility;
import baseball.model.BallAndStrikeCount;
import baseball.model.ComputerNumber;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerControllerTest {
    ComputerController computerController = new ComputerController();

    @Test
    @DisplayName("랜덤값 3자리수 검증")
    void createComputerNumber1() {
        //when
        List<Integer> computerNumber = RandomUtility.createComputerNumber();

        //then
        assertThat(computerNumber.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("랜덤값 서로 다른 1~9 사이의 수 인지 검증")
    void createComputerNumber2() {
        //when
        List<Integer> computerNumber = RandomUtility.createComputerNumber();

        //then
        boolean[] isIncluded = new boolean[10];
        for(Integer num : computerNumber) {
            assertThat(num).isGreaterThan(0).isLessThan(10);
            assertThat(isIncluded[num]).isFalse();
            isIncluded[num] = true;
        }
    }

    @Test
    @DisplayName("볼과 스트라이크 갯수 검증")
    void getBallAndStrikeCount() {
        //given
        List<Integer> computerNumber = new ArrayList<>();
        computerNumber.add(1);
        computerNumber.add(2);
        computerNumber.add(3);
        ComputerNumber computerNumberObj = new ComputerNumber(computerNumber);

        //when
        BallAndStrikeCount threeStrikeCount = computerController.getBallAndStrikeCount(computerNumberObj, "123");
        BallAndStrikeCount oneBalloneStrikeCount = computerController.getBallAndStrikeCount(computerNumberObj, "324");
        BallAndStrikeCount zeroCount = computerController.getBallAndStrikeCount(computerNumberObj, "456");

        //then
        assertThat(threeStrikeCount.getStrikeCount()).isEqualTo(3);

        assertThat(oneBalloneStrikeCount.getBallCount()).isEqualTo(1);
        assertThat(oneBalloneStrikeCount.getStrikeCount()).isEqualTo(1);

        assertThat(zeroCount.getStrikeCount()).isEqualTo(0);
        assertThat(zeroCount.getBallCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("Hint 메시지 검증")
    void getHint() {
        //given
        BallAndStrikeCount threeStrike = new BallAndStrikeCount(0, 3);
        BallAndStrikeCount zero = new BallAndStrikeCount(0, 0);
        BallAndStrikeCount oneBalloneStrike = new BallAndStrikeCount(1, 1);

        //when
        String threeStrikeHint = computerController.getHint(threeStrike);
        String nothingHint = computerController.getHint(zero);
        String oneBalloneStrikeHint = computerController.getHint(oneBalloneStrike);

        //then
        assertThat(threeStrikeHint).isEqualTo("3스트라이크 ");
        assertThat(nothingHint).isEqualTo("낫싱");
        assertThat(oneBalloneStrikeHint).isEqualTo("1볼 1스트라이크 ");
    }
}