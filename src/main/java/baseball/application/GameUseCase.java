package baseball.application;

import baseball.domain.NumericString;

public interface GameUseCase {

    BaseBallResult execute(NumericString playerInput);
}
