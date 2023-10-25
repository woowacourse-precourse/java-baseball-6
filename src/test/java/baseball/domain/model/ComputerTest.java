package baseball.domain.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {
    Computer computer;

    @BeforeEach
    void setUp() {
        computer = new Computer(List.of("3", "5", "7"));
    }

    @Test
    void BallCount_판정_스트라이크() {
        assertThat(computer.compareWithUserBall("3", 0)).isEqualTo(BallCount.STRIKE);
        assertThat(computer.compareWithUserBall("5", 1)).isEqualTo(BallCount.STRIKE);
        assertThat(computer.compareWithUserBall("7", 2)).isEqualTo(BallCount.STRIKE);
    }

    @Test
    void BallCount_판정_볼() {
        assertThat(computer.compareWithUserBall("3", 1)).isEqualTo(BallCount.BALL);
        assertThat(computer.compareWithUserBall("5", 2)).isEqualTo(BallCount.BALL);
        assertThat(computer.compareWithUserBall("7", 0)).isEqualTo(BallCount.BALL);
    }

    @Test
    void BallCount_판정_아웃() {
        assertThat(computer.compareWithUserBall("4", 1)).isEqualTo(BallCount.OUT);
        assertThat(computer.compareWithUserBall("9", 2)).isEqualTo(BallCount.OUT);
        assertThat(computer.compareWithUserBall("6", 0)).isEqualTo(BallCount.OUT);
    }


}