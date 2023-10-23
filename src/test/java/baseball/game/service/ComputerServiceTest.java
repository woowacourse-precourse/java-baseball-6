package baseball.game.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import baseball.game.entity.Computer;
import baseball.game.entity.NumberBaseBallGameWord;
import baseball.game.repository.ComputerRepository;
import baseball.game.repository.GameResultRepository;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerServiceTest {
    ComputerRepository computerRepository = ComputerRepository.getInstance();
    GameResultRepository gameResultRepository = GameResultRepository.getInstance();
    ComputerService computerService = ComputerService.getInstance(computerRepository, gameResultRepository);

    @Test
    @DisplayName("사용자가 숫자와 위치 모두 맞히면 종료 문구를 반환한다.")
    void playResultEnd() {
        // given
        Computer computer = computerRepository.save(Computer.create(1L, List.of(1, 2, 3)));
        String gameResult = getEndGameResult();

        // when
        String result = computerService.startGame(computer.getId(), List.of(1, 2, 3));

        // then
        Computer findComputer = computerRepository.findBy(1L).get();
        assertAll(
                () -> assertThat(findComputer.getBallCount()).isEqualTo(0),
                () -> assertThat(findComputer.getStrikeCount()).isEqualTo(3),
                () -> assertThat(result).isEqualTo(gameResult)
        );
    }

    @Test
    @DisplayName("사용자가 1개 또는 2개의 숫자와 위치를 맞히면 스트라이크 문구를 반환한다.")
    void playResultStrike() {
        // given
        Computer computer = computerRepository.save(Computer.create(1L, List.of(1, 2, 3)));

        // when
        String result = computerService.startGame(computer.getId(), List.of(1, 2, 4));

        // then
        Computer findComputer = computerRepository.findBy(1L).get();
        assertAll(
                () -> assertThat(findComputer.getBallCount()).isEqualTo(0),
                () -> assertThat(findComputer.getStrikeCount()).isEqualTo(2),
                () -> assertThat(result).isEqualTo(2 + NumberBaseBallGameWord.STRIKE.getMessage())
        );
    }

    @Test
    @DisplayName("사용자가 숫자만 맞히면 볼 문구를 반환한다.")
    void playResultBall() {
        // given
        Computer computer = computerRepository.save(Computer.create(1L, List.of(1, 2, 3)));

        // when
        String result = computerService.startGame(computer.getId(), List.of(3, 1, 2));

        // then
        Computer findComputer = computerRepository.findBy(1L).get();
        assertAll(
                () -> assertThat(findComputer.getBallCount()).isEqualTo(3),
                () -> assertThat(findComputer.getStrikeCount()).isEqualTo(0),
                () -> assertThat(result).isEqualTo(3 + NumberBaseBallGameWord.BALL.getMessage())
        );
    }

    @Test
    @DisplayName("사용자가 1개의 숫만 맞히고 1개의 숫자와 위치를 맞힌 경우이면 1볼 1스트라이크 문구를 반환한다.")
    void playResultBallAndStrike() {
        // given
        Computer computer = computerRepository.save(Computer.create(1L, List.of(1, 2, 3)));

        // when
        String result = computerService.startGame(computer.getId(), List.of(1, 3, 9));

        // then
        Computer findComputer = computerRepository.findBy(1L).get();
        assertAll(
                () -> assertThat(findComputer.getBallCount()).isEqualTo(1),
                () -> assertThat(findComputer.getStrikeCount()).isEqualTo(1),
                () -> assertThat(result).isEqualTo(1 + NumberBaseBallGameWord.BALL.getMessage()
                        + " "
                        + 1 + NumberBaseBallGameWord.STRIKE.getMessage())
        );
    }


    private String getEndGameResult() {
        StringBuilder sb = new StringBuilder();
        sb.append(3).append(NumberBaseBallGameWord.STRIKE.getMessage()).append("\n");
        sb.append(NumberBaseBallGameWord.END.getMessage());

        return sb.toString();
    }
}