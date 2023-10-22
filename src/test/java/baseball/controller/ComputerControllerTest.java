package baseball.controller;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import baseball.common.RandomUtility;
import baseball.model.BallAndStrikeCount;
import baseball.model.ComputerNumber;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerControllerTest {
    ComputerController computerController = new ComputerController();

    @Test
    @DisplayName("1~9까지 서로 다른 수로 이루어진 3자리 수 생성")
    void createComputerNumber() {
        //given
        //when
        List<Integer> computerNumber = RandomUtility.createComputerNumber();

        //then
        //3자리 수 검증
        assertThat(computerNumber.size()).isEqualTo(3);
        //1~9까지 서로 다른 수 검증
        boolean[] isIncluded = new boolean[10];
        for(Integer num : computerNumber) {
            assertThat(num).isGreaterThan(0).isLessThan(10);
            assertThat(isIncluded[num]).isFalse();
            isIncluded[num] = true;
        }
    }

    @Test
    @DisplayName("볼과 스트라이크 갯수 반환")
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
}