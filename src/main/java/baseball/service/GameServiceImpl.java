package baseball.service;

import baseball.domain.entity.player.Player;
import baseball.domain.entity.Referee;
import baseball.domain.dto.GameResponse;

public class GameServiceImpl implements GameService {

    private final Referee referee;

    public GameServiceImpl(Referee referee) {
        this.referee = referee;
    }

    public GameResponse playGame(Player user, Player computer) {
        referee.playGame(user, computer);
        return referee.toResponse();
    }
}
