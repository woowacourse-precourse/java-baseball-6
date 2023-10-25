package baseball.game.io;

import baseball.game.model.dto.GameResultDto;

public interface Output {

    void printMessage(String message);
    void printLineMessage(String message);
    void printGameResult(GameResultDto resultDto);

}
