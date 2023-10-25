package baseball.service;

import baseball.domain.Computer;
import baseball.domain.Numbers;
import baseball.domain.User;
import baseball.dto.response.GameResultResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameServiceTest {
    private static GameService gameService;
    @BeforeEach
    public void beforeEach() {
        gameService = new GameService();
    }

    @Test
    @DisplayName("컴퓨터와 사용자 숫자를 비교하여 볼, 스트라이크 개수를 반환한다.")
    public void 숫자_계산() throws Exception {

        // given
        Computer computer = new Computer(new Numbers(List.of(1, 2, 3)));
        User user = new User(new Numbers(List.of(1, 3, 2)));

        // when
        GameResultResponse result = gameService.getResult(computer, user);
        int ballCountExpect = 2;
        int strikeCountExpect = 1;

        // then
        assertThat(result.getBallCount()).isEqualTo(ballCountExpect);
        assertThat(result.getStrikeCount()).isEqualTo(strikeCountExpect);
    }
}