package baseball.game;

import java.util.List;

public interface GameUtil {
    List<Integer> setComputerNum();

    int[] calculateResult(List<Integer> computerNum, List<Integer> inputNum);
}
