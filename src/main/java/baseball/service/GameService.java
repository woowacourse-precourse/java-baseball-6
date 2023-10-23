package baseball.service;

import baseball.domain.Game;
import baseball.repository.MemoryGameRepository;

import java.util.List;
import java.util.Optional;

public class GameService {
    private final MemoryGameRepository gameRepository;

    public GameService(MemoryGameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    /* 새로운 게임 생성 */
    public Long join(Game game){
        gameRepository.save(game);

        return game.getId();
    }

    /* 특정 게임 조회 */
    public Optional<Game> findOne(Long gameId) {
        return gameRepository.findById(gameId);
    }

    /* 특정 유저 id로 진행된 게임 리스트 조회 */
    public List<Game> findGame(Long userId){
        return gameRepository.findByUserId(userId).toList();
    }

    /* 질문 횟수 추가 */
    public Game addQestionCount(Game game){
        return gameRepository.saveQestionCount(game);
    }
}
