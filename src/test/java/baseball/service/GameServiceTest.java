package baseball.service;

import baseball.repository.MemoryGameRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameServiceTest {
    private GameService gameService;
    MemoryGameRepository memoryGameRepository;

    @BeforeEach
    public void beforeEach(){
        memoryGameRepository = new MemoryGameRepository();
        gameService= new GameService(memoryGameRepository);
    }

    @Test
    void join() {
    }

    @Test
    void findOne() {
    }

    @Test
    void findGame() {
    }

    @Test
    void addQestionCount() {
    }
}