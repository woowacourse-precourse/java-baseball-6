package baseball.rule;

import baseball.computer.Computer;
import baseball.domain.number.GameNumber;
import baseball.domain.result.Result;

public interface Rule {

    Result check(GameNumber userNumber, Computer computer);
}
