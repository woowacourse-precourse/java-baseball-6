package baseball.controller;

import baseball.controller.dto.BaseBallGameDto;

public interface Game {

    String play(BaseBallGameDto input);
}
