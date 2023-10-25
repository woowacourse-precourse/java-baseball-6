package baseball.gameutil.converter;

import baseball.gameutil.validate.InputMod;
import java.util.List;

/**
 * 이 인터페이스를 구현하면 사용자의 입력을 변환할 수 있다.
 */
public interface GameInputConverter {
    List<Integer> convertBaseballInput(InputMod mod);
}
