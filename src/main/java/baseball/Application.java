package baseball;

import baseball.controller.GameController;
import baseball.repository.MemoryGameRepository;
import baseball.repository.MemoryUserRepository;

public class Application {
    public static void main(String[] args) {
        MemoryGameRepository memoryGameRepository = new MemoryGameRepository();
        MemoryUserRepository memoryUserRepository = new MemoryUserRepository();

        GameController gameController = new GameController(memoryGameRepository, memoryUserRepository);
        gameController.startProgram();
    }
}
