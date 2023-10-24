package baseball.model;

import static baseball.model.BaseballGameCounts.BALL;
import static baseball.model.BaseballGameCounts.STRIKE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballGameCountsTest {
    @Test
    @DisplayName("컴퓨터 번호와 동일한 유저 번호를 대입한 BasballGameCounts 객체가 3스트라이크가 되는지 테스트")
    public void 카운트_생성자_3스트라이크_테스트() throws Exception {
        // given
        ComputerNumber computer = new ComputerNumber("123");

        UserNumber user = new UserNumber("123");

        // when
        BaseballGameCounts counts = new BaseballGameCounts(computer, user);

        // then
        assertThat(counts.getCounts().get(STRIKE)).isEqualTo(3);

    }


    @Test
    @DisplayName("스트라이크와 볼이 둘다 들어왔을 때, counts에 올바른 값이 들어간다.")
    public void 스트라이크_볼_테스트() throws Exception {
        // given
        ComputerNumber computer = new ComputerNumber("123");

        UserNumber user = new UserNumber("136");

        // when
        BaseballGameCounts counts = new BaseballGameCounts(computer, user);

        // then
        assertThat(counts.getCounts().get(BALL)).isEqualTo(1);
        assertThat(counts.getCounts().get(STRIKE)).isEqualTo(1);
    }

    @Test
    @DisplayName("스트라이크/볼이 없을 때 카운트는 0,0으로 들어간다.")
    public void 낫싱_테스트() throws Exception{
        // given
        ComputerNumber computer = new ComputerNumber("123");

        UserNumber user = new UserNumber("456");

        // when
        BaseballGameCounts counts = new BaseballGameCounts(computer, user);

        // then
        assertThat(counts.getCounts().get(BALL)).isEqualTo(0);
        assertThat(counts.getCounts().get(STRIKE)).isEqualTo(0);
    }

    @Test
    @DisplayName("승리 조건(3스트라이크)을 가진 BaseballGameCounts 객체가 승리조건을 만족하는지 확인한다.")
    public void 카운트_승리조건_테스트() throws Exception {
        // given
        ComputerNumber computer = new ComputerNumber("123");

        UserNumber user = new UserNumber("123");

        // when
        BaseballGameCounts counts = new BaseballGameCounts(computer, user);

        // then
        assertThat(counts.isWinCondition()).isEqualTo(true);

    }

}