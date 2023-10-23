package baseball.application;

import baseball.controller.NumericString;

public interface GameUseCase {

    BaseBallResult umpire(NumericString playerInput);
}
