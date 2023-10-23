package baseball.application;

import baseball.domain.BaseBallNumberList;

public interface GameUseCase {

    BaseBallResult execution(BaseBallNumberList playerInput);
}
