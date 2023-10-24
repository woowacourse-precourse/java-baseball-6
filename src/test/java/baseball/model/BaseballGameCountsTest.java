package baseball.model;

import static baseball.model.BaseballGameCounts.STRIKE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballGameCountsTest {
    @Test
    @DisplayName("컴퓨터 번호와 동일한 유저 번호를 대입한 BasballGameCounts 객체가 3스트라이크가 되는지 테스트")
    public void 카운트_생성자_3스트라이크_테스트() throws Exception {
        // given
        ComputerNumber computer = new ComputerNumber();

        UserNumber user = new UserNumber(
                // computerNumber의 List -> String화
                computer.getComputerNumber().stream()
                        .map(Object::toString)
                        .collect(Collectors.joining())
        );

        // when
        BaseballGameCounts counts = new BaseballGameCounts(computer, user);

        // then
        assertThat(counts.getCounts().get(STRIKE)).isEqualTo(3);

    }


    @Test
    @DisplayName("승리 조건(3스트라이크)을 가진 BaseballGameCounts 객체가 승리조건을 만족하는지 확인한다.")
    public void 카운트_승리조건_테스트() throws Exception {
        // given
        ComputerNumber computer = new ComputerNumber();

        UserNumber user = new UserNumber(
                computer.getComputerNumber().stream()
                        .map(Object::toString)
                        .collect(Collectors.joining())
        );

        // when
        BaseballGameCounts counts = new BaseballGameCounts(computer, user);

        // then
        assertThat(counts.isWinCondition()).isEqualTo(true);

    }

}