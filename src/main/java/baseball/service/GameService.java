package baseball.service;

import baseball.dto.JudgeDTO;
import java.util.List;

public interface GameService {
    
    JudgeDTO process(List<Integer> numbers, int[] inputNumbers);

}
