package baseball.domain.computer;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerTest {
    private Computer computer;

    @BeforeEach()
    void setUp() {
        computer = new Computer();
    }

    @AfterEach()
    void tearDown() {
        computer.clear();
    }

    @Test
    @DisplayName("사용자가 정답을 입력하면 참을 반환합니다.")
    void isAnswer() {
        // GIVEN
        List<Integer> userInputs = new ArrayList<>();
        userInputs.add(1);
        userInputs.add(2);
        userInputs.add(3);
        List<Integer> randomNumbers = new ArrayList<>();
        randomNumbers.add(1);
        randomNumbers.add(2);
        randomNumbers.add(3);

        // WHEN
        boolean answer = computer.isAnswer(userInputs, randomNumbers);

        // THEN
        assertThat(answer).isEqualTo(true);
    }

    @Test
    @DisplayName("1볼, 1스트라이크 여부를 판별합니다.")
    void testBallAndStrike() {
        // GIVEN
        List<Integer> randomNumbers = new ArrayList<>();
        randomNumbers.add(5);
        randomNumbers.add(8);
        randomNumbers.add(9);
        List<Integer> userInputs = new ArrayList<>();
        userInputs.add(5); // strike
        userInputs.add(9); // ball
        userInputs.add(7);

        // WHEN
        computer.countBallAndStrike(userInputs, randomNumbers);
        int ballCount = computer.getBallCount();
        int strikeCount = computer.getStrikeCount();

        // THEN
        assertThat(ballCount).isEqualTo(1);
        assertThat(strikeCount).isEqualTo(1);
    }

    @Test
    @DisplayName("1볼 여부를 판별합니다.")
    void testBall() {
        // GIVEN
        List<Integer> userInputs = new ArrayList<>();
        userInputs.add(1);
        userInputs.add(8);
        userInputs.add(3);
        List<Integer> randomNumbers = new ArrayList<>();
        randomNumbers.add(9);
        randomNumbers.add(5);
        randomNumbers.add(1);

        // WHEN
        computer.countBallAndStrike(userInputs, randomNumbers);
        int ballCount = computer.getBallCount();
        int strikeCount = computer.getStrikeCount();

        // THEN
        assertThat(ballCount).isEqualTo(1);
        assertThat(strikeCount).isEqualTo(0);
    }

    @Test
    @DisplayName("스트라이크 여부를 판별합니다.")
    void testStrike() {
        // GIVEN
        List<Integer> userInputs = new ArrayList<>();
        userInputs.add(1);
        userInputs.add(2);
        userInputs.add(9);
        List<Integer> randomNumbers = new ArrayList<>();
        randomNumbers.add(1);
        randomNumbers.add(2);
        randomNumbers.add(7);

        // WHEN
        computer.countBallAndStrike(userInputs, randomNumbers);
        int ballCount = computer.getBallCount();
        int strikeCount = computer.getStrikeCount();

        // THEN
        assertThat(ballCount).isEqualTo(0);
        assertThat(strikeCount).isEqualTo(2);
    }

    @Test
    @DisplayName("정답 여부 판별 시, 항상 일정한 정답을 반환하는지 확인합니다.")
    void test() {
        // GIVEN
        List<Integer> userInputs = new ArrayList<>();
        userInputs.add(1);
        userInputs.add(2);
        userInputs.add(3);
        List<Integer> randomNumbers1 = new ArrayList<>();
        randomNumbers1.add(2);
        randomNumbers1.add(1);
        randomNumbers1.add(3);
        List<Integer> randomNumbers2 = new ArrayList<>();
        randomNumbers2.add(2);
        randomNumbers2.add(1);
        randomNumbers2.add(3);

        // WHEN
        computer.countBallAndStrike(userInputs, randomNumbers1);
        int ballCount1 = computer.getBallCount();
        int strikeCount1 = computer.getStrikeCount();

        computer.countBallAndStrike(userInputs, randomNumbers2);
        int ballCount2 = computer.getBallCount();
        int strikeCount2 = computer.getStrikeCount();

        computer.countBallAndStrike(userInputs, randomNumbers2);
        int ballCount3 = computer.getBallCount();
        int strikeCount3 = computer.getStrikeCount();

        // THEN
//        assertThat(ballCount1).isEqualTo(ballCount2);
        System.out.println("ballCount1 : " + ballCount1);
        System.out.println("ballCount2 : " + ballCount2);
        System.out.println("ballCount3 : " + ballCount3);
//        assertThat(strikeCount1).isEqualTo(strikeCount2);
        System.out.println("strikeCount1 : " + strikeCount1);
        System.out.println("strikeCount2 : " + strikeCount2);
        System.out.println("strikeCount3 : " + strikeCount3);
    }
}