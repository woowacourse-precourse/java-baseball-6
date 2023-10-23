package baseball.gameutil.converter;

import baseball.gameutil.InputMod;
import java.util.List;

public interface GameInputConverter {
    List<Integer> convertBaseballInput(InputMod mod);
}
