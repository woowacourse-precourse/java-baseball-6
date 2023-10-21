package baseball.domain.player;

import baseball.domain.Baseball;
import baseball.dto.BattedBallsDTO;
import java.util.List;

public interface Batter {

    List<Baseball> tryBatting(BattedBallsDTO battedBallsDTO);
}
