package baseball.repository;

import baseball.domain.Game;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryGameRepositoryTest {
    MemoryGameRepository repository = new MemoryGameRepository();
    private static long sequence = 0L;

    @AfterEach
    public void afterEach() { repository.clearStore();}

    public Game setGame(){
        Game game = new Game();
        game.setId(++sequence);
        game.setQuestionCount(0L);

        List<Integer> computerNumber = new ArrayList<>();
        computerNumber.add(1);
        computerNumber.add(2);
        computerNumber.add(3);

        game.setComputerNumber(computerNumber);
        game.setUserId(1L);

        repository.save(game);

        return game;
    }

    @Test
    public void save(){
        Game game = setGame();

        Game result = repository.findById(game.getId()).get();
        assertThat(game).isEqualTo(result);
    }

    @Test
    public void saveQestionCount(){
        Game game = setGame();
        Long firstCount = game.getQuestionCount();

        Game result = repository.saveQestionCount(game);
        assertThat(++firstCount).isEqualTo(result.getQuestionCount());
    }

    @Test
    public void findByUserId(){
        Game game1 = setGame();
        Game game2 = setGame();

        Stream<Game> result = repository.findByUserId(game1.getUserId());
        assertThat(result.count()).isEqualTo(2);
    }

}