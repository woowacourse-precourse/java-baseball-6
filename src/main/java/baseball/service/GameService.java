package baseball.service;

import baseball.domain.Game;

import java.util.List;

public interface GameService {
    Game getGame();
    void init(Game game);
    void inputMenuValidate(String input);
    void playerNumbersValidate(String input);
    String numbersMatch(List<Integer> targetNumbers, String inputNumbers);
}
