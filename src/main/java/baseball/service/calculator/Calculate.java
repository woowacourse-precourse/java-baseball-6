package baseball.service.calculator;

import baseball.domain.computer.ComputerNumber;
import baseball.dto.Result;

public interface Calculate {
    Result calculateBallAndStrike(final ComputerNumber computer, final int[] input);
}
