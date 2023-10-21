package baseball.domain;

import baseball.dto.BattedBallsDTO;
import java.util.List;

public interface Batter {

    List<Baseball> tryBatting(BattedBallsDTO battedBallsDTO);
}
