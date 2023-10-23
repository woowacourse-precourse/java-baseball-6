package baseball.application;

import baseball.domain.BaseBallNumberList;

public interface GameUseCase {

    BaseBallResult execute(BaseBallNumberList playerInput);
}
