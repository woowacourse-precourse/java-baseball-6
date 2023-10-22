package baseball.service;

import baseball.dto.HintDTO;
import java.util.List;

public interface GameService {

    HintDTO process(List<Integer> numbers, int[] inputNumbers);

}
