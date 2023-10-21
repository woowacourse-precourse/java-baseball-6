package baseball.view;

import baseball.domain.BallStatus;
import baseball.domain.Referee;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OutputViewTest {

    @Test
    void asdf() {
        List<BallStatus> statuses = Arrays.asList(BallStatus.STRIKE,BallStatus.BALL, BallStatus.STRIKE);
        Referee referee = new Referee(statuses);
        OutputView ov = new OutputView();
        assertThat(referee.getBallNum()).isEqualTo(1);
        assertThat(referee.getStrikeNum()).isEqualTo(1);
        ov.printResult(referee);
    }
}
