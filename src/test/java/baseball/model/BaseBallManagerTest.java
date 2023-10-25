package baseball.model;

import baseball.stub.BaseBallManagerStub;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class BaseBallManagerTest {

    @Test
    @DisplayName("player가 입력한 공과 computer가 생성한 공의 위치와 값이 같으면 스트라이크 3개가 나와야 한다.")
    void assert_strike_if_player_ball_is_same_computer_ball() {
        // stub
        List<Integer> stubBallNumbers = new ArrayList<>();
        for (int ballNumber = 1; ballNumber <= 3; ballNumber++) {
            stubBallNumbers.add(ballNumber);
        }
        BallNumberGroup stubBallNumberGroup = new BallNumberGroup(stubBallNumbers);

        // set ballNumberGroup
        BaseBallManagerStub stubManager = new BaseBallManagerStub();
        stubManager.setComputerBaseBallNumber(stubBallNumberGroup);

        // given
        List<Integer> testPlayerBallNumberGroup = new ArrayList<>();
        for (int ballNumber = 1; ballNumber <= 3; ballNumber++) {
            testPlayerBallNumberGroup.add(ballNumber);
        }
        BallNumberGroup testPlayerBallNumber = new BallNumberGroup(testPlayerBallNumberGroup);

        // when
        Map<String, Integer> testCompareResult = stubManager.compareBaseBall(testPlayerBallNumber);

        // then
        Assertions.assertEquals(3, testCompareResult.get("스트라이크"));
    }
}