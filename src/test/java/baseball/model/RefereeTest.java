package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RefereeTest {

    @Test
    @DisplayName("Ground 객체를 받아 정답을 설정한다.")
    void setAnswerToGround() {
        // given
        Ground ground = Ground.of(3, 0);
        // when
        Referee.setAnswerToGround(ground);
        // then
        assertEquals("3스트라이크", Referee.getAnswer());
    }

    @Test
    @DisplayName("초기화 상태일 때")
    void setFailAnswer() {
        // given
        // when
        Referee.setFailAnswer();
        // then
        assertEquals("낫싱", Referee.getAnswer());
    }

    @Test
    @DisplayName("정답을 맞췄을 때")
    void setSuccessAnswer() {
        // given
        // when
        Referee.setSuccessAnswer();
        // then
        assertEquals("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n", Referee.getAnswer());
    }

}