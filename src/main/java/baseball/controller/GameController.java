package baseball.controller;

import baseball.domain.GameService;

import java.util.List;

public class GameController {

    GameService service = new GameService();

    public void start() {
        List<Integer> numbers = service.generateNumbers();
    }
}
