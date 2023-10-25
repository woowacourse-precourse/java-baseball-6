package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.Judgement;
import baseball.domain.Player;
import baseball.domain.Referee;
import java.util.List;
import org.junit.jupiter.api.Test;

public class RefereeTest {

    Referee referee = new Referee();

    @Test
    void 스트라이크() {
        referee.newComputerWith(List.of(1, 2, 3));
        Player player = new Player(List.of(1, 2, 3));

        Judgement indexZeroResult = referee.judge(player, 0);
        Judgement indexOneResult = referee.judge(player, 1);
        Judgement indexTwoResult = referee.judge(player, 2);

        assertThat(indexZeroResult).isEqualTo(Judgement.STRIKE);
        assertThat(indexOneResult).isEqualTo(Judgement.STRIKE);
        assertThat(indexTwoResult).isEqualTo(Judgement.STRIKE);
    }

    @Test
    void 볼() {
        referee.newComputerWith(List.of(1, 2, 3));
        Player player = new Player(List.of(3, 1, 2));

        Judgement indexZeroResult = referee.judge(player, 0);
        Judgement indexOneResult = referee.judge(player, 1);
        Judgement indexTwoResult = referee.judge(player, 2);

        assertThat(indexZeroResult).isEqualTo(Judgement.BALL);
        assertThat(indexOneResult).isEqualTo(Judgement.BALL);
        assertThat(indexTwoResult).isEqualTo(Judgement.BALL);
    }

    @Test
    void 아웃() {
        referee.newComputerWith(List.of(1, 2, 3));
        Player player = new Player(List.of(8, 9, 10));

        Judgement indexZeroResult = referee.judge(player, 0);
        Judgement indexOneResult = referee.judge(player, 1);
        Judgement indexTwoResult = referee.judge(player, 2);

        assertThat(indexZeroResult).isEqualTo(Judgement.OUT);
        assertThat(indexOneResult).isEqualTo(Judgement.OUT);
        assertThat(indexTwoResult).isEqualTo(Judgement.OUT);
    }
}