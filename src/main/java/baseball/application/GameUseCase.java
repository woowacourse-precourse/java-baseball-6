package baseball.application;

import baseball.controller.NumericString;

public interface GameUseCase {

    BaseBallResult execute(NumericString playerInput);
}
