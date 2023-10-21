package baseball.game.service;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.game.entity.Computer;
import baseball.game.entity.NumberBaseBallGameWord;
import baseball.game.repository.ComputerRepository;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerServiceTest {
    ComputerRepository computerRepository = ComputerRepository.getInstance();
    ComputerService computerService = ComputerService.getInstance(computerRepository);

    @Test
    @DisplayName("사용자가 숫자와 위치 모두 맞히면 종료 문구를 반환한다.")
    void playResultEnd() {
        // given
        Computer computer = computerRepository.save(Computer.create(1L, List.of(1, 2, 3)));

        // when
        String result = computerService.gameResult(computer.getId(), List.of(1, 2, 3));

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
        Computer computer = computerRepository.save(Computer.create(1L, List.of(1, 2, 3)));

        // when
        String result = computerService.gameResult(computer.getId(), List.of(1, 2, 4));

        // then
        assertThat(result).isEqualTo(2 + NumberBaseBallGameWord.STRIKE.getKrName());
    }

    @Test
    @DisplayName("사용자가 숫자만 맞히면 볼 문구를 반환한다.")
    void playResultBall() {
        // given
        Computer computer = computerRepository.save(Computer.create(1L, List.of(1, 2, 3)));

        // when
        String result = computerService.gameResult(computer.getId(), List.of(3, 1, 2));

        // then
        assertThat(result).isEqualTo(3 + NumberBaseBallGameWord.BALL.getKrName());
    }
}