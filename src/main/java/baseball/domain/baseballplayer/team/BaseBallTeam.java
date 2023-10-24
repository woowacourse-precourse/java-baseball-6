package baseball.domain.baseballplayer.team;

import baseball.domain.baseballplayer.dto.Ball;

public sealed interface BaseBallTeam permits Computer, User {
    Ball getBall();

    void createNewBall();

}
