package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import baseball.domain.BallNumberGenerator;
import baseball.domain.CompareNumber;
import baseball.domain.ComputerNumber;
import baseball.domain.DataTypeChanger;
import java.util.List;
import org.junit.jupiter.api.Test;

class ComputerNumberTest {

    @Test
    void 스트라이크를_리턴() {
        List<CompareNumber> randomNumber = DataTypeChanger.compareNumberFormat(new BallNumberGenerator().generateBallNumber());
        ComputerNumber computerNumber = new ComputerNumber(randomNumber);
        assertThatCode(() -> computerNumber.getScore(randomNumber.get(0))).doesNotThrowAnyException();
        assertThat(computerNumber.getScore(randomNumber.get(0)).isStrike()).isTrue();

    }
}