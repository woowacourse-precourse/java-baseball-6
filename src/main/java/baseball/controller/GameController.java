package baseball.controller;

import baseball.model.Answer;
import baseball.model.Referee;
import baseball.model.dto.PlayerDto;
import baseball.model.dto.ResultDto;
import baseball.view.GameView;
import baseball.view.PlayerView;
import baseball.view.RefereeView;

public class GameController {

    private final PlayerView playerView = new PlayerView();
    private final RefereeView refereeView = new RefereeView();
    private final GameView gameView = new GameView();

    public void startGame() {
        Referee referee = new Referee(Answer.generate());

        while (referee.keepGoing()) {
            PlayerDto playerDto = new PlayerDto(playerView.getPlayerInput());
            ResultDto resultDto = referee.decidesResult(playerDto);
            refereeView.printResult(resultDto);
        }

        if (gameView.restart()) {
            startGame();
        }
    }

    public GameController() {
        gameView.printGameStart();
    }
}