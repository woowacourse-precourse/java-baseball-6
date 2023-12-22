package baseball.check;

import java.util.List;

public interface CheckService {
    Hint checkNumber(List<Integer> computer, List<Integer> numbers);

    boolean checkGameOver(Hint hint);
}
