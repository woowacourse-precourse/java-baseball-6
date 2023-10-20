package baseball.game.service;

import baseball.game.entity.Computer;
import baseball.game.entity.NumberBaseBallGameWord;
import baseball.game.repository.ComputerRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ComputerServiceTest {
    ComputerRepository numberBaseBallRepository = new ComputerRepository();

    @Test
    @DisplayName("사용자가 숫자와 위치 모두 맞히면 종료 문구를 반환한다.")
    void playResultEnd() {
        // given
        ComputerService game = new ComputerService(numberBaseBallRepository);
        Computer computer = numberBaseBallRepository.save(Computer.create(1L, List.of(1, 2, 3)));

        // when
        String result = game.gameResult(computer.getId(), List.of(1, 2, 3));

        // then
        StringBuilder sb = new StringBuilder();
        sb.append(3).append(NumberBaseBallGameWord.STRIKE.getKrName()).append("\n");
        sb.append(NumberBaseBallGameWord.END.getKrName());
        assertThat(result).isEqualTo(sb.toString());
    }

    @Test
    @DisplayName("사용자가 1개 또는 2개의 숫자와 위치를 맞히면 스트라이크 문구를 반환한다.")
    void playResultStrike() {
        // given
        ComputerService game = new ComputerService(numberBaseBallRepository);
        Computer computer = numberBaseBallRepository.save(Computer.create(1L, List.of(1, 2, 3)));

        // when
        String result = game.gameResult(computer.getId(), List.of(1, 2, 4));

        // then
        assertThat(result).isEqualTo(2+NumberBaseBallGameWord.STRIKE.getKrName());
    }

    @Test
    @DisplayName("사용자가 숫자만 맞히면 볼 문구를 반환한다.")
    void playResultBall() {
        // given
        ComputerService game = new ComputerService(numberBaseBallRepository);
        Computer computer = numberBaseBallRepository.save(Computer.create(1L, List.of(1, 2, 3)));

        // when
        String result = game.gameResult(computer.getId(), List.of(3, 1, 2));

        // then
        assertThat(result).isEqualTo(3+NumberBaseBallGameWord.BALL.getKrName());
    }
}