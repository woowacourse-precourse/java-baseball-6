package baseball.domain.player.attacker;

import baseball.domain.player.Player;
import baseball.domain.player.value.Balls;
import baseball.exception.rutime.NotInitializeBallException;

public interface Attacker extends Player {

    Balls attack() throws NotInitializeBallException;
}
