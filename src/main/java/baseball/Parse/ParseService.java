package baseball.Parse;

import java.util.List;

public interface ParseService {
    List<Integer> stringParseToNumbers(String StringNumbers);
    boolean isRestart(String flag);
}
