package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import baseball.domain.BallNumberGenerator;
import baseball.domain.BallScore;
import baseball.domain.CompareNumber;
import baseball.domain.ComputerNumber;
import baseball.domain.DataTypeChanger;
import baseball.domain.UserNumber;
import java.util.List;
import org.junit.jupiter.api.Test;

public class UserNumberTest {
    @Test
    void 점수_저장_테스트_3스트라이크() {
        List<CompareNumber> randomNumber = DataTypeChanger.compareNumberFormat(new BallNumberGenerator().generateBallNumber());
        ComputerNumber computerNumber = new ComputerNumber(randomNumber);
        UserNumber userNumber = new UserNumber(randomNumber);
        assertThatCode(() -> userNumber.getScore(computerNumber)).doesNotThrowAnyException();
        assertThat(userNumber.getScore(computerNumber).getResult(BallScore.STRIKE)).isEqualTo(3);
    }
}
