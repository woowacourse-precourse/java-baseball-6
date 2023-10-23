package baseball.core;

import baseball.dto.GameResult;

import java.util.List;

public interface GameRule {
    GameResult apply(List<Integer> computerNumbers, List<Integer> userNumbers);
}
